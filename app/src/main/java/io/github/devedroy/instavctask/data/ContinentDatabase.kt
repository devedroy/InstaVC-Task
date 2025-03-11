package io.github.devedroy.instavctask.data

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [ContinentEntity::class], version = 1)
abstract class ContinentDatabase : RoomDatabase() {
    abstract fun getDao(): ContinentDao
}
