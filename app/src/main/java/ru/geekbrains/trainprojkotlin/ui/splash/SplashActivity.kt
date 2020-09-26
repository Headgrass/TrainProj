package ru.geekbrains.trainprojkotlin.ui.splash

import android.os.Handler
import androidx.lifecycle.ViewModelProvider
import ru.geekbrains.trainprojkotlin.ui.base.BaseActivity

import ru.geekbrains.trainprojkotlin.ui.main.MainActivity

class SplashActivity : BaseActivity<Boolean?, SplashViewState>() {
    override val viewModel: SplashViewModel by lazy {
        ViewModelProvider(this).get(SplashViewModel::class.java)
    }

    override val layoutRes = null

    override fun onResume() {
        super.onResume()
        Handler().postDelayed({viewModel.requestUser()}, 1000)
        viewModel.requestUser()
    }

    override fun renderData(data: Boolean?) {
        data?.takeIf { it }?.let {
            startMainActivity()
        }
    }

    fun startMainActivity() {
        startActivity(MainActivity.getStartIntent(this))
        finish()
    }

}