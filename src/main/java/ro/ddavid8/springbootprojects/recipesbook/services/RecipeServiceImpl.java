package ro.ddavid8.springbootprojects.recipesbook.services;

import org.springframework.stereotype.Service;
import ro.ddavid8.springbootprojects.recipesbook.models.Recipe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final List<Recipe> recipes = new ArrayList<>();

    @Override
    public Recipe addRecipe(Recipe recipe) {
        recipe.setId(UUID.randomUUID());
        recipes.add(recipe);
        return recipe;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipes;
    }

    @Override
    public List<Recipe> searchRecipes(List<String> ingredients, String dishType) {
        List<Recipe> matchedRecipes = new ArrayList<>();
        for (Recipe currentRecipe : recipes) {
            List<String> currentIngredients = currentRecipe.getIngredients().stream()
                    .map(String::toLowerCase)
                    .toList();
            List<String> searchedIngredients = ingredients.stream()
                    .map(String::toLowerCase)
                    .toList();
            if (currentRecipe.getDishType().equalsIgnoreCase(dishType) &&
                    new HashSet<>(currentIngredients).containsAll(searchedIngredients)) {
                matchedRecipes.add(currentRecipe);
            }
        }
        return matchedRecipes;
    }
}
