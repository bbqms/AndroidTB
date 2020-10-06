package com.example.practicaparcial

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.practicaparcial.entity.Tarea

@Database(entities = arrayOf(Tarea::class), version=1)
abstract class AppDatabase:RoomDatabase(){
    abstract fun tareaDao(): TareaDAO

    companion object{
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context:Context) : AppDatabase{
            if(INSTANCE==null)
            {
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java,"database"
                ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
            }
            return  INSTANCE!!
        }
    }
}
