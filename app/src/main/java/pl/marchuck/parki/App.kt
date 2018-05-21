package pl.marchuck.parki

import android.content.Context
import android.support.multidex.MultiDex
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import pl.marchuck.parki.di.component.DaggerAppComponent

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}