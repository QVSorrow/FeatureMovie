package com.featmov.serles.featuremovie.di

import com.featmov.serles.featuremovie.data.remote.RemoteDataSource
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val remoteModule = module {

    fun provideHttpClient() : OkHttpClient = OkHttpClient.Builder()
            .addNetworkInterceptor(HttpLoggingInterceptor()
                    .apply { level = HttpLoggingInterceptor.Level.BODY })
            .build()

    fun provideGson() : Gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()

    fun provideConverterFactory(gson : Gson) : Converter.Factory = GsonConverterFactory.create(gson)

    fun provideCallFactory() : CallAdapter.Factory = CoroutineCallAdapterFactory()

    fun provideRetrofit(
            httpClient : OkHttpClient,
            callAdapterFactory : CallAdapter.Factory,
            converterFactory : Converter.Factory)
            : Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .client(httpClient)
                .addCallAdapterFactory(callAdapterFactory)
                .addConverterFactory(converterFactory)
                .build()
    }

    fun provideRemoteDataSource(retrofit : Retrofit) : RemoteDataSource =
            RemoteDataSource(retrofit)

    single { provideHttpClient() }
    single { provideGson() }
    single { provideConverterFactory(get()) }
    single { provideCallFactory() }
    single { provideRetrofit(get(), get(), get()) }
    single { provideRemoteDataSource(get()) }
}