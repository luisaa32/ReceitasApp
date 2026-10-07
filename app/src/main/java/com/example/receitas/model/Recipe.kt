package com.example.receitas.model

import androidx.annotation.DrawableRes

// Ingrediente de uma receita.
// Data class com apenas "val": o objeto é imutável depois de criado.
data class Ingredient(
    val name: String,
    val quantity: String? // opcional: null quando não há quantidade definida (ex: "a gosto")
)

// Receita completa. Os campos com "?" são opcionais e precisam ser tratados com segurança.
data class Recipe(
    val id: Int,
    val name: String,
    val description: String,
    val prepTimeMinutes: Int,
    val servings: Int,
    @DrawableRes val imageRes: Int?, // opcional: se null, usamos uma imagem padrão
    val tip: String?,                // opcional: se null, a seção de dica fica escondida
    val ingredients: List<Ingredient>,
    val steps: List<String>
)
