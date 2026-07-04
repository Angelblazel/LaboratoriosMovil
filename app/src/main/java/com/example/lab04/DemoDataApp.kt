package com.example.lab04

import android.app.Application
import com.example.lab04.data.local.FileStorageManager
import com.example.lab04.data.local.DemoDataDatabase
import com.example.lab04.data.repository.AudioRepository
import com.example.lab04.data.repository.GpsRepository
import com.example.lab04.data.repository.MediaRepository
import com.example.lab04.data.session.SessionManager

class DemoDataApp : Application() {

    val database     by lazy { DemoDataDatabase.getInstance(this) }
    val fileStorage  by lazy { FileStorageManager(this) }
    val sessionManager by lazy { SessionManager(this) }

    val gpsRepository by lazy {
        GpsRepository(database.gpsGoogleDao(), database.gpsSensorsDao())
    }
    val mediaRepository by lazy {
        MediaRepository(database.mediaDao(), fileStorage)
    }
    val audioRepository by lazy {
        AudioRepository(database.audioDao(), fileStorage)
    }
}