package io.github.devedroy.instavctask.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.devedroy.instavctask.data.ContinentDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext application: Context): ContinentDatabase {
        return Room.databaseBuilder(application, ContinentDatabase::class.java, "item_database")
            .build()
    }

    @Provides
    @Singleton
    fun provideDao(database: ContinentDatabase) = database.getDao()
}

