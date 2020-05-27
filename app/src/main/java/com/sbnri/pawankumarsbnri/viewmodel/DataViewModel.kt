package com.sbnri.pawankumarsbnri.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sbnri.pawankumarsbnri.App
import com.sbnri.pawankumarsbnri.adapter.DataAdapter
import com.sbnri.pawankumarsbnri.database.GithubDatabase
import com.sbnri.pawankumarsbnri.database.RoomDao
import com.sbnri.pawankumarsbnri.model.DataResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class DataViewModel : BaseViewModel() {
    var dataAdapter = DataAdapter()
    var noDataFound:MutableLiveData<Boolean> = MutableLiveData()
    private var repoDao: RoomDao = GithubDatabase.getInstance(App.mContext).reposDao()
    private  var ioExecutor: Executor = Executors.newSingleThreadExecutor()
    private var isRequestInProgress = false
    private var lastPage:Boolean = false
    var localData: LiveData<List<DataResponse>> = MutableLiveData()
    companion object {
        private const val VISIBLE_THRESHOLD = 5
        private const val PAGE_SIZE = 10
    }


    private var lastRequestedPage = 1
    init {
         localData  = repoDao.repos()
        Log.d("data",localData.value?.size.toString())
        if(localData.value.isNullOrEmpty()){
            getReposFromServer(1,10)
        }/*else{
            noDataFound.value = false

            dataAdapter.submitList(localData.value)
            lastRequestedPage = dataAdapter.itemCount/10
        }*/



    }
    private fun getReposFromServer(page: Int,
                                   itemsPerPage: Int){
        if (isRequestInProgress) return

        isRequestInProgress = true
        subsription = postApi.searchRepos(page,itemsPerPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe{onApiCallStart()}
                .doOnTerminate{onApiCallFinish()}
                .subscribe({
                    onApiSuccess(it.body())
                },
                    {
                        loadingBar.value = false
                        isRequestInProgress = false
                        errorMessage.value = onApiCallError(it)})    }

    fun insert(repos: List<DataResponse>, insertFinished: () -> Unit) {
        ioExecutor.execute {
            Log.d("DataViewModel", "inserting ${repos.size} repos")
            repoDao.insert(repos)
            insertFinished()
        }
    }
    private fun loadMore(page: Int,
                         itemsPerPage: Int){
        if (isRequestInProgress) return

        isRequestInProgress = true

        subsription = postApi.searchRepos(page,itemsPerPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe{}
                .doOnTerminate{onApiCallFinish()}
                .subscribe({
                    onApiSuccess(it.body())
                },
                    {
                        isRequestInProgress = false
                        errorMessage.value = onApiCallError(it)})    }

    private fun onApiSuccess(body: List<DataResponse>?) {
            noDataFound.value = false
            if(body.isNullOrEmpty()){
                lastPage = true
                Log.d("data",repoDao.repos().value!!.size.toString())

                return
            }

        // dataAdapter.setData(body as ArrayList<DataResponse>)
            insert(body){
                lastRequestedPage++
                isRequestInProgress = false
            }




    }

    fun listScrolled(visibleItemCount: Int, lastVisibleItemPosition: Int, totalItemCount: Int) {
        if ((visibleItemCount + lastVisibleItemPosition + VISIBLE_THRESHOLD >= totalItemCount)&&!lastPage) {
            loadMore(lastRequestedPage, PAGE_SIZE)
        }
    }


}




