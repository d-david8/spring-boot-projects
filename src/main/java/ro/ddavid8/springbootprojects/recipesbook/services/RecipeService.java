package ro.ddavid8.springbootprojects.recipesbook.services;

import ro.ddavid8.springbootprojects.recipesbook.models.Recipe;

import java.util.List;

public interface RecipeService {

    Recipe addRecipe(Recipe recipe);

    List<Recipe> getAllRecipes();

    List<Recipe> searchRecipes(List<String> ingredients, String dishType);
}
