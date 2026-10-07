package com.example.receitas.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.receitas.R
import com.example.receitas.databinding.ItemRecipeBinding
import com.example.receitas.model.Recipe

// Adapter da lista: transforma cada Recipe em uma linha (item_recipe.xml).
// Recebe a lista e uma lambda chamada quando o usuário toca em um item.
class RecipeAdapter(
    private val recipes: List<Recipe>,
    private val onClick: (Recipe) -> Unit
) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    // O ViewHolder guarda o binding do item (sem findViewById)
    class RecipeViewHolder(val binding: ItemRecipeBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding = ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        val context = holder.itemView.context

        with(holder.binding) {
            textName.text = recipe.name
            textInfo.text = context.getString(
                R.string.recipe_info, recipe.prepTimeMinutes, recipe.servings
            )
            // Imagem opcional: se for null, usa o drawable padrão (operador Elvis ?:)
            imageRecipe.setImageResource(recipe.imageRes ?: R.drawable.ic_recipe_default)
            // Clique no item: repassa a receita para quem criou o adapter
            root.setOnClickListener { onClick(recipe) }
        }
    }

    override fun getItemCount(): Int = recipes.size
}
