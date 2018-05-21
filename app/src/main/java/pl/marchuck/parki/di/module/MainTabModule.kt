package pl.marchuck.parki.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.marchuck.parki.di.FragmentScope
import pl.marchuck.parki.ui.home.HomeFragment

@Module
abstract class MainTabModule {

    @FragmentScope
    @ContributesAndroidInjector()
    abstract fun contributeHomeInjector(): HomeFragment

//    @FragmentScope
//    @ContributesAndroidInjector()
//    abstract fun contributeBookFragmentInjector(): BookFragment
//
//    @FragmentScope
//    @ContributesAndroidInjector()
//    abstract fun contributeRememberFragmentInjector(): RememberFragment
//
//    @FragmentScope
//    @ContributesAndroidInjector()
//    abstract fun contributeSettingFragmentInjector(): SettingFragment
}