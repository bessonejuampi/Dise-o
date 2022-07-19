package com.utn.pobreTITO.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.utn.pobreTITO.models.Claim

@Dao
interface claimDAO {

    @Insert
    fun InsertClaim(claim : Claim)

    @Query("SELECT * FROM claim WHERE email=:email")
    fun getClaimForEmail(email:String) : List<Claim>
}