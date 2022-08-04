package com.utn.pobreTITO.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User (
    @PrimaryKey(autoGenerate = false) var dni : String,
    @ColumnInfo(name = "name") var name : String,
    @ColumnInfo(name = "surname") var surname :String,
    @ColumnInfo(name = "pass") var pass : String,
    @ColumnInfo(name = "email") var email :String
    ){
}