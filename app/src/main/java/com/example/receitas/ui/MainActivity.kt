package com.example.receitas.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.receitas.data.RecipeRepository
import com.example.receitas.databinding.ActivityMainBinding

// Tela 1: lista de receitas
class MainActivity : AppCompatActivity() {

    // Binding gerado a partir de activity_main.xml
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configura a RecyclerView com lista vertical e o adapter
        binding.recyclerRecipes.layoutManager = LinearLayoutManager(this)
        binding.recyclerRecipes.adapter = RecipeAdapter(RecipeRepository.getAll()) { recipe ->
            // Intent explícita: abre a tela de detalhes passando só o id da receita
            val intent = Intent(this, RecipeDetailActivity::class.java)
            intent.putExtra(RecipeDetailActivity.EXTRA_RECIPE_ID, recipe.id)
            startActivity(intent)
        }
    }
}
