package com.example.receitas.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.receitas.R
import com.example.receitas.data.RecipeRepository
import com.example.receitas.databinding.ActivityRecipeDetailBinding
import com.example.receitas.model.Recipe

// Tela 2: detalhes de uma receita
class RecipeDetailActivity : AppCompatActivity() {

    companion object {
        // Chave usada para passar o id da receita pela Intent
        const val EXTRA_RECIPE_ID = "extra_recipe_id"
    }

    private lateinit var binding: ActivityRecipeDetailBinding

    // Estado local da tela: a receita está favoritada?
    private var isFavorite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mostra a seta de voltar na ActionBar (volta para a MainActivity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Lê o id enviado pela MainActivity (-1 se não vier nada)
        val id = intent.getIntExtra(EXTRA_RECIPE_ID, -1)

        // Busca no repositório; se não achar, avisa e fecha a tela
        val recipe = RecipeRepository.getById(id)
        if (recipe == null) {
            Toast.makeText(this, R.string.error_recipe_not_found, Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        showRecipe(recipe)
        setupFavoriteButton(recipe)
    }

    // Preenche as Views com os dados da receita
    private fun showRecipe(recipe: Recipe) {
        title = recipe.name

        with(binding) {
            // Imagem opcional: se null, usa a imagem padrão
            imageRecipe.setImageResource(recipe.imageRes ?: R.drawable.ic_recipe_default)
            textPrepTime.text = getString(R.string.prep_time, recipe.prepTimeMinutes)
            textName.text = recipe.name
            textDescription.text = recipe.description
            textServings.text = getString(R.string.servings, recipe.servings)

            // Ingredientes: quantidade opcional -> "• 1 lata Leite condensado" ou só "• Sal"
            textIngredients.text = recipe.ingredients.joinToString("\n") { ingredient ->
                val quantity = ingredient.quantity?.let { "$it " } ?: ""
                "• $quantity${ingredient.name}"
            }

            // Modo de preparo numerado: "1. ...", "2. ..."
            textSteps.text = recipe.steps
                .mapIndexed { index, step -> "${index + 1}. $step" }
                .joinToString("\n")

            // Dica opcional: se existir, mostra o texto; se for null, esconde o TextView (GONE)
            textTip.visibility = View.GONE
            recipe.tip?.let { tip ->
                textTip.text = getString(R.string.tip_format, tip)
                textTip.visibility = View.VISIBLE
            }
        }
    }

    // Botão Favoritar: alterna o estado e atualiza a interface
    private fun setupFavoriteButton(recipe: Recipe) {
        updateFavoriteButton()
        binding.buttonFavorite.setOnClickListener {
            isFavorite = !isFavorite
            updateFavoriteButton()

            val message = if (isFavorite) R.string.toast_favorited else R.string.toast_unfavorited
            Toast.makeText(this, getString(message, recipe.name), Toast.LENGTH_SHORT).show()
        }
    }

    // Muda o texto do botão conforme o estado atual
    private fun updateFavoriteButton() {
        binding.buttonFavorite.setText(
            if (isFavorite) R.string.button_favorited else R.string.button_favorite
        )
    }

    // Trata o clique na seta de voltar da ActionBar
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
