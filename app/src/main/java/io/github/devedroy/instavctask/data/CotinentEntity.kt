package io.github.devedroy.instavctask.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ContinentEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val population: Double

)