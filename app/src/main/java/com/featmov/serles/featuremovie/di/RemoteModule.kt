package com.featmov.serles.featuremovie.di

import com.featmov.serles.featuremovie.data.RemoteDataSource
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Singleton
@Module
class RemoteModule {

    @Provides
    fun provideHttpClient() : OkHttpClient = OkHttpClient.Builder()
            .addNetworkInterceptor(HttpLoggingInterceptor()
                    .apply { level = HttpLoggingInterceptor.Level.BASIC })
            .build()

    @Provides
    fun provideGson() : Gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()

    @Provides
    fun provideConverterFactory(gson : Gson) : Converter.Factory = GsonConverterFactory.create(gson)

    @Provides
    fun provideCallFactory() : CallAdapter.Factory = RxJava2CallAdapterFactory.create()

    @Provides
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

    @Provides
    fun provideRemoteDataSource(retrofit : Retrofit/*, okHttpClient : OkHttpClient*/) : RemoteDataSource =
            RemoteDataSource(retrofit/*, okHttpClient*/)
}