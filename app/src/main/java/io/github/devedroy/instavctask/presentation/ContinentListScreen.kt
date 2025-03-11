package io.github.devedroy.instavctask.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ContinentListScreen(
    viewModel: ContinentViewModel = hiltViewModel(),
) {

    LaunchedEffect(Unit) {
        viewModel.getAllContinents()
    }

    val continents by viewModel.continents.collectAsState()


    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        items(continents) { continent ->
            ContinentItem(
                name = continent.name,
                population = continent.population
            )
        }
    }

}


@Composable
fun ContinentItem(name: String, population: Double) {

    Column(
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = name)
        Text(
            text = population.toString()
        )
    }

}

@Preview
@Composable
private fun ContinentPreview() {
    ContinentItem(
        name = "Asia",
        population = 4.56
    )
}