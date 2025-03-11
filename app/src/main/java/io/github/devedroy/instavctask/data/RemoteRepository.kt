package io.github.devedroy.instavctask.data

import io.github.devedroy.instavctask.data.dto.ContinentDto
import javax.inject.Inject

class RemoteRepository @Inject constructor(
    private val service: ContinentService
) {

    suspend fun getAllContinents(): List<ContinentDto> {
        return service.getAllContinents()
    }

}