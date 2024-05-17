package com.example.manual_di.di

import android.content.Context
import com.example.manual_di.data.AuthApi
import com.example.manual_di.data.AuthRepositoryImpl
import com.example.manual_di.domain.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

interface AppModule {
    val authApi: AuthApi
    val authRepository: AuthRepository
}

class AppModuleImpl(
    private val appContext: Context
): AppModule {
    override val authApi: AuthApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://my-url.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
    override val authRepository: AuthRepository by lazy {
        AuthRepositoryImpl(authApi)
    }
}


//@Module
//@InstallIn(SingletonComponent::class)
//object AppModule {
//    @Provides
//    @Singleton
//    fun provideAuthApi(): AuthApi {
//        return Retrofit.Builder()
//            .baseUrl("https://my-url.com")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create()
//    }
//
//    @Provides
//    @Singleton
//    fun provideAuthRepository(authApi: AuthApi): AuthRepository {
//        return AuthRepositoryImpl(authApi)
//    }
//}