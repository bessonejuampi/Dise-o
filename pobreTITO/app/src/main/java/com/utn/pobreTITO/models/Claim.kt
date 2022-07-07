package com.utn.pobreTITO.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.utn.pobreTITO.common.EnumCodition

@Entity(tableName = "claim")
data class Claim(
    @ColumnInfo(name = "title") var title : String,
    @ColumnInfo(name = "category") var category: String,
    @ColumnInfo(name = "description") var description : String,
    @ColumnInfo(name = "direction") var direction : String,
    @ColumnInfo(name = "condition") var condition : String,
    @ColumnInfo(name = "email") var email : String
) {
    @PrimaryKey(autoGenerate = true) var id : Int= 0
}