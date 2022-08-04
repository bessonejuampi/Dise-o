package com.utn.pobreTITO.database.dao

import android.provider.ContactsContract
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.utn.pobreTITO.models.User

@Dao
interface userDAO {
    @Insert
    fun InsertUser(user: User)

    @Query("SELECT * FROM  user WHERE email=:email AND pass=:pass")
    fun LogIn(email: String, pass : String) : User

    @Query("SELECT * FROM user WHERE email=:email")
    fun getUser(email:String) : User
}