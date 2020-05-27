package com.sbnri.pawankumarsbnri.database

import android.content.Context
import androidx.room.*
import com.sbnri.pawankumarsbnri.model.DataResponse

@Database(
    entities = [DataResponse::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(PermissionConverter::class,LicenceConverter::class)
abstract class GithubDatabase : RoomDatabase() {

    abstract fun reposDao(): RoomDao

    companion object {

        @Volatile
        private var INSTANCE: GithubDatabase? = null

        fun getInstance(context: Context): GithubDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                GithubDatabase::class.java, "repo.db")
                .build()
    }
}