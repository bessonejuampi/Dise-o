package com.utn.pobreTITO.database.dao

import androidx.room.Dao
import androidx.room.Insert
import com.utn.pobreTITO.models.Claim

@Dao
interface claimDAO {

    @Insert
    fun InsertClaim(claim : Claim)
}