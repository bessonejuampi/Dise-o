package com.utn.pobreTITO.database.dao

import androidx.room.Dao
import androidx.room.Insert
import com.utn.pobreTITO.models.User

@Dao
interface UserDAO {

    @Insert
    fun InstertUser(user: User)
}