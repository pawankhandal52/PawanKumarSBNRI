package com.sbnri.pawankumarsbnri.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sbnri.pawankumarsbnri.model.DataResponse

@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(posts: List<DataResponse>)


    @Query("SELECT * FROM repos")
    fun repos(): LiveData<List<DataResponse>>
}