package ru.geekbrains.trainprojkotlin.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import ru.geekbrains.trainprojkotlin.data.NotesRepository
import ru.geekbrains.trainprojkotlin.data.provider.DataProvider
import ru.geekbrains.trainprojkotlin.data.provider.FirestoreProvider
import ru.geekbrains.trainprojkotlin.ui.main.MainViewModel
import ru.geekbrains.trainprojkotlin.ui.note.NoteViewModel
import ru.geekbrains.trainprojkotlin.ui.splash.SplashViewModel

val appModule = module {
    single { FirebaseAuth.getInstance() }
    single { FirebaseFirestore.getInstance() }
    single<DataProvider> { FirestoreProvider(get(), get()) }
    single { NotesRepository(get()) }
}

val splashModule = module {
    viewModel { SplashViewModel(get()) }
}

val mainModule = module {
    viewModel { MainViewModel(get()) }
}

val noteModule = module {
    viewModel { NoteViewModel(get()) }
}