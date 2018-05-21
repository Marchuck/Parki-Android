package pl.marchuck.parki.di.module

import dagger.Module

@Module(includes = [MainTabModule::class])
abstract class ActivityBindModule {


//    @ActivityScope
//    @ContributesAndroidInjector(modules = [MainTabModule::class])
//    abstract fun contributeMainActivityInjector(): MainActivity

}