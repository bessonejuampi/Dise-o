package com.utn.pobreTITO.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.utn.pobreTITO.database.dao.claimDAO
import com.utn.pobreTITO.models.Claim
import com.utn.pobreTITO.models.User

@Database(entities = [Claim::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun claimDAO() : claimDAO?
    companion object {
        private val LOCK = Any()
        private const val DATABASE_NAME = "pobreTITO_database"
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                synchronized(LOCK) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, DATABASE_NAME
                    ).allowMainThreadQueries().build()
                }
            }
            return instance
        }
    }
}