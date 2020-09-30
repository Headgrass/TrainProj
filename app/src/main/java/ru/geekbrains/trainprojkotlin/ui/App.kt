package ru.geekbrains.trainprojkotlin.ui

import android.app.Application
import org.koin.android.ext.android.startKoin
import ru.geekbrains.trainprojkotlin.di.appModule
import ru.geekbrains.trainprojkotlin.di.mainModule
import ru.geekbrains.trainprojkotlin.di.noteModule
import ru.geekbrains.trainprojkotlin.di.splashModule

class App : Application() {
    companion object {
        lateinit var instance: App
        private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        startKoin(this, listOf(appModule, splashModule, mainModule, noteModule))
    }
}
