package io.github.devedroy.instavctask.data

import io.github.devedroy.instavctask.data.dto.ContinentDto
import retrofit2.http.GET

interface ContinentService {
    @GET("continents")
    suspend fun getAllContinents(): List<ContinentDto>
}