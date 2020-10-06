package com.example.practicaparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Dao
import com.example.practicaparcial.entity.Tarea
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var tareaDao: TareaDAO



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tareaDao = AppDatabase.getInstance(this).tareaDao()

        val tareas = ArrayList<Tarea>(tareaDao.getTareas())

        btnGuardarTarea.setOnClickListener {
            val tareaCreada = Tarea(etNombreTarea.text.toString(),false)
            tareaDao.insertarTarea(tareaCreada)
        }
        btnVerTareas.setOnClickListener {
            Log.i("Tareas",tareaDao.getTareas().toString())
        }

    }

}