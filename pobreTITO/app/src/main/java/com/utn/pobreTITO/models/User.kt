package com.utn.pobreTITO.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User (
    @PrimaryKey( autoGenerate = false) var dni : String,
    @ColumnInfo(name = "nombre") var name : String,
    @ColumnInfo(name = "apellido") var surname :String,
    @ColumnInfo(name = "pass") var pass : String
    ){
}