package com.example.receitas.data

import com.example.receitas.R
import com.example.receitas.model.Ingredient
import com.example.receitas.model.Recipe

// Repositório com dados simulados (mock) em memória: sem API e sem banco de dados.
// "object" cria uma única instância (singleton) acessível de qualquer tela.
object RecipeRepository {

    private val recipes = listOf(
        Recipe(
            id = 1,
            name = "Brigadeiro",
            description = "O doce mais famoso das festas brasileiras.",
            prepTimeMinutes = 20,
            servings = 25,
            imageRes = R.drawable.ic_recipe_dessert,
            tip = "Unte as mãos com manteiga para enrolar sem grudar.",
            ingredients = listOf(
                Ingredient("Leite condensado", "1 lata"),
                Ingredient("Chocolate em pó", "2 colheres de sopa"),
                Ingredient("Manteiga", "1 colher de sopa"),
                Ingredient("Chocolate granulado", null) // sem quantidade: "a gosto"
            ),
            steps = listOf(
                "Misture o leite condensado, o chocolate e a manteiga em uma panela.",
                "Cozinhe em fogo baixo, mexendo sempre, até desgrudar do fundo.",
                "Deixe esfriar, enrole as bolinhas e passe no granulado."
            )
        ),
        Recipe(
            id = 2,
            name = "Bolo de cenoura",
            description = "Bolo fofinho de cenoura com cobertura de chocolate.",
            prepTimeMinutes = 50,
            servings = 10,
            imageRes = R.drawable.ic_recipe_cake,
            tip = null, // sem dica: a seção ficará escondida
            ingredients = listOf(
                Ingredient("Cenoura média", "3 unidades"),
                Ingredient("Ovos", "3 unidades"),
                Ingredient("Óleo", "1 xícara"),
                Ingredient("Açúcar", "2 xícaras"),
                Ingredient("Farinha de trigo", "2 xícaras"),
                Ingredient("Fermento em pó", "1 colher de sopa")
            ),
            steps = listOf(
                "Bata no liquidificador a cenoura, os ovos e o óleo.",
                "Em uma tigela, misture com o açúcar e a farinha.",
                "Adicione o fermento e misture delicadamente.",
                "Asse em forno médio (180 °C) por cerca de 40 minutos."
            )
        ),
        Recipe(
            id = 3,
            name = "Pão de queijo",
            description = "Clássico mineiro, crocante por fora e macio por dentro.",
            prepTimeMinutes = 40,
            servings = 20,
            imageRes = null, // sem imagem: será exibida a imagem padrão
            tip = "Congele as bolinhas cruas e asse quando quiser.",
            ingredients = listOf(
                Ingredient("Polvilho azedo", "500 g"),
                Ingredient("Leite", "1 xícara"),
                Ingredient("Óleo", "1/2 xícara"),
                Ingredient("Ovos", "2 unidades"),
                Ingredient("Queijo minas ralado", "200 g"),
                Ingredient("Sal", null)
            ),
            steps = listOf(
                "Ferva o leite com o óleo e o sal e escalde o polvilho.",
                "Espere amornar e acrescente os ovos e o queijo.",
                "Sove até a massa ficar lisa e faça bolinhas.",
                "Asse em forno a 200 °C por 25 minutos."
            )
        ),
        Recipe(
            id = 4,
            name = "Arroz carreteiro",
            description = "Prato gaúcho feito com arroz e carne seca.",
            prepTimeMinutes = 60,
            servings = 4,
            imageRes = R.drawable.ic_recipe_meal,
            tip = null, // sem dica
            ingredients = listOf(
                Ingredient("Carne seca dessalgada", "500 g"),
                Ingredient("Arroz", "2 xícaras"),
                Ingredient("Cebola picada", "1 unidade"),
                Ingredient("Alho", "2 dentes"),
                Ingredient("Cheiro-verde", null)
            ),
            steps = listOf(
                "Refogue a carne seca desfiada com a cebola e o alho.",
                "Junte o arroz e refogue por mais 2 minutos.",
                "Cubra com água quente e cozinhe até secar.",
                "Finalize com cheiro-verde."
            )
        ),
        Recipe(
            id = 5,
            name = "Mousse de maracujá",
            description = "Sobremesa gelada, rápida e refrescante.",
            prepTimeMinutes = 15,
            servings = 6,
            imageRes = R.drawable.ic_recipe_dessert,
            tip = "Leve à geladeira por pelo menos 3 horas antes de servir.",
            ingredients = listOf(
                Ingredient("Leite condensado", "1 lata"),
                Ingredient("Creme de leite", "1 caixa"),
                Ingredient("Suco concentrado de maracujá", "1 lata (medida do leite condensado)")
            ),
            steps = listOf(
                "Bata todos os ingredientes no liquidificador por 3 minutos.",
                "Despeje em uma travessa e leve à geladeira."
            )
        )
    )

    // Retorna todas as receitas
    fun getAll(): List<Recipe> = recipes

    // Busca uma receita pelo id; retorna null se não encontrar
    fun getById(id: Int): Recipe? = recipes.find { it.id == id }
}
