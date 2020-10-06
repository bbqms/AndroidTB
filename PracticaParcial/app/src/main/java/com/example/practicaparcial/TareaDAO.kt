package com.example.practicaparcial

import androidx.room.*
import com.example.practicaparcial.entity.Tarea


@Dao
interface TareaDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertarTarea(tarea: Tarea)

    @Update
    fun actualizarTarea(tarea: Tarea)

    @Delete
    fun elminarTarea(tarea:Tarea)

    @Query("SELECT * FROM tarea")
    fun getTareas(): List<Tarea>
}