package io.github.devedroy.instavctask.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.devedroy.instavctask.data.ContinentService
import io.github.devedroy.instavctask.data.RemoteRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://dummy-json.mock.beeceptor.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ContinentService {
        return retrofit.create(ContinentService::class.java)
    }

    @Singleton
    @Provides
    fun providesRepository(service: ContinentService): RemoteRepository {
        return RemoteRepository(service)
    }
}