package com.example.practicaparcial.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName ="tarea")
class Tarea (

    @PrimaryKey val nombre: String,
    val terminada: Boolean
) {
    override fun toString(): String {
        return "Tarea(nombre='$nombre', terminada=$terminada)"
    }
}