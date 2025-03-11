package io.github.devedroy.instavctask.data.dto


import com.google.gson.annotations.SerializedName
import io.github.devedroy.instavctask.data.ContinentEntity

data class ContinentDto(
    @SerializedName("areaSqKm")
    val areaSqKm: Int,
    @SerializedName("code")
    val code: String,
    @SerializedName("countries")
    val countries: Int,
    @SerializedName("developedCountries")
    val developedCountries: List<String>,
    @SerializedName("lines")
    val lines: List<String>,
    @SerializedName("name")
    val name: String,
    @SerializedName("oceans")
    val oceans: List<String>,
    @SerializedName("population")
    val population: Double
)


fun ContinentDto.toContinentEntity(): ContinentEntity {
    return ContinentEntity(
        name = this.name,
        population = this.population
    )
}