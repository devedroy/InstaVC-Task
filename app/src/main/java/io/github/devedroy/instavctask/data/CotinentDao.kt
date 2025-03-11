package io.github.devedroy.instavctask.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ContinentDao {
    @Query("SELECT * FROM ContinentEntity")
    fun getContinents(): List<ContinentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContinents(continents: List<ContinentEntity>)

}