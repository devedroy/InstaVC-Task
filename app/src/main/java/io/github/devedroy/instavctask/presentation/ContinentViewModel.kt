package io.github.devedroy.instavctask.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.devedroy.instavctask.data.ContinentDao
import io.github.devedroy.instavctask.data.ContinentEntity
import io.github.devedroy.instavctask.data.RemoteRepository
import io.github.devedroy.instavctask.data.dto.toContinentEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContinentViewModel @Inject constructor(
    private val dao: ContinentDao,
    private val repository: RemoteRepository
) : ViewModel() {

    private val _continents = MutableStateFlow<List<ContinentEntity>>(emptyList())
    val continents = _continents.asStateFlow()

    fun getAllContinents() {
        viewModelScope.launch(Dispatchers.IO) {
            updateUI(dao.getContinents())
        }
    }

    private fun updateUI(continents: List<ContinentEntity>) {
        if (continents.isEmpty()) {
            viewModelScope.launch(Dispatchers.IO) {
                _continents.update { repository.getAllContinents().map { it.toContinentEntity() } }
                dao.insertContinents(_continents.value)
            }
        } else {
            _continents.update { continents }
        }
    }
}