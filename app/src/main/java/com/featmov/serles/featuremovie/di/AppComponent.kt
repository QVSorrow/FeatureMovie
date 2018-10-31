package com.featmov.serles.featuremovie.di

import com.featmov.serles.featuremovie.App
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (AndroidSupportInjectionModule::class),
    (AppModule::class),
    (RemoteModule::class),
    (RepositoryModule::class),
    (ViewModelModule::class),
    (ActivityProvider::class)])

interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>() {
        abstract fun appModule(appModule: AppModule): Builder
    }
}