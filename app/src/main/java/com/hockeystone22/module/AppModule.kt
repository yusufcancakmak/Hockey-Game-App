package com.hockeystone22.module

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.hockeystone22.BuildConfig
import com.hockeystone22.data.PlayerDatabase
import com.hockeystone22.helper.Contants
import com.hockeystone22.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun BASE_URL()=Contants.BASE_URL

    @Provides
    @Singleton
    fun RetrofitInstance(gson: Gson, okHttpClient: OkHttpClient):ApiService =
        Retrofit.Builder()
            .baseUrl(Contants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
            .create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideOkHttpClient(application: Application) : OkHttpClient {
        val okHttpBuilder : OkHttpClient.Builder = OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .callTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60,TimeUnit.SECONDS)
            .readTimeout(60,TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            okHttpBuilder.addInterceptor(logging)
        }
        return okHttpBuilder.build()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .create()
    }


    @Provides
    @Singleton
    fun providesDatabase(app: Application): PlayerDatabase =
        Room.databaseBuilder(app, PlayerDatabase::class.java,"player.db").build()
}