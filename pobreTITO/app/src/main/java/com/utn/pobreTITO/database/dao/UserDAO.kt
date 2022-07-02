package com.utn.pobreTITO.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.utn.pobreTITO.models.User

@Dao
interface UserDAO {

    @Insert
    fun InstertUser(user: User)

    @Query("SELECT * FROM user_table WHERE dni=:dni AND pass=:pass")
    fun LogIn(dni:String, pass:String):User
}