package com.example.roomlivedatamvvm.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "userinfo")
class UserEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val name : String,

    val email : String
)