package com.mbucic.starwarspeople.model

data class ResponseData(
    val next: String?,
    val results: List<StarWarsCharacter>
)

data class StarWarsCharacter(
    val name: String,
    val height: String,
    val mass: String,
    val gender: String
)
