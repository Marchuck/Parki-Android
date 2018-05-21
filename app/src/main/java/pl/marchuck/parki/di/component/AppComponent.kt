package pl.marchuck.parki.di.component

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import pl.marchuck.parki.App
import pl.marchuck.parki.di.module.ActivityBindModule
import pl.marchuck.parki.di.module.AppModule
import javax.inject.Singleton

/**
 * Created by zouzheng on 18-3-8.
 */
@Singleton
@Component(modules = [AppModule::class,
    ActivityBindModule::class,
    AndroidSupportInjectionModule::class])

interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()


}