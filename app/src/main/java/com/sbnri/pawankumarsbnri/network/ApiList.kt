package com.sbnri.pawankumarsbnri.network

import com.sbnri.pawankumarsbnri.model.DataResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface ApiList {
    @GET("orgs/octokit/repos")
    fun searchRepos(
        @Query("page") page: Int,
        @Query("per_page") itemsPerPage: Int
    ): Observable<Response<List<DataResponse>>>
}