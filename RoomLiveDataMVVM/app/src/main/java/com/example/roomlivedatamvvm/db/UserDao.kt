package com.example.roomlivedatamvvm.db

import androidx.room.*

@Dao
interface UserDao {

    @Query("SELECT * FROM userinfo")
    fun  getAllUserInfo() : List<UserEntity>

    @Insert
    fun insertUser(user: UserEntity?)

    @Delete
    fun deleteUser(user: UserEntity?)

    @Update
    fun updateUser(user:UserEntity?)


}