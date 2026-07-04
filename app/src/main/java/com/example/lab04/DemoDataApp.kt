package com.example.lab04

import android.app.Application
import com.example.lab04.data.local.AppDatabase
import com.example.lab04.data.repository.GpsRepository
import com.example.lab04.data.session.SessionManager

class DemoDataApp : Application() {

    // La BD se crea una sola vez cuando se accede por primera vez
    val database by lazy { AppDatabase.getDatabase(this) }

    // El repositorio se construye sobre la misma instancia de la BD
    val gpsRepository by lazy {
        GpsRepository(database.gpsGoogleDao(), database.gpsSensorsDao())
    }

    // SessionManager también vive aquí para no duplicarlo en MainActivity
    val sessionManager by lazy { SessionManager(this) }
}