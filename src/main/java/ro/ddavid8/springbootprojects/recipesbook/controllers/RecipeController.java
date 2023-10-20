package ro.ddavid8.springbootprojects.recipesbook.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ddavid8.springbootprojects.recipesbook.models.Recipe;
import ro.ddavid8.springbootprojects.recipesbook.services.RecipeService;

import java.util.List;

@RestController
@RequestMapping("/api/recipesBook/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    /**
     * Adds a new recipe to the database.
     *
     * @param recipe the recipe object to be added
     * @return ResponseEntity with the added recipe
     */
    @PostMapping()
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
        return ResponseEntity.ok(recipeService.addRecipe(recipe));
    }

    /**
     * Retrieves all recipes from the database.
     *
     * @return ResponseEntity containing a list of all recipes
     */
    @GetMapping()
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        return ResponseEntity.ok(recipeService.getAllRecipes());
    }

    /**
     * Searches for recipes based on the provided list of ingredients and dish type.
     *
     * @param ingredients list of ingredients to be used in the search
     * @param dishType    the type of dish to be included in the search
     * @return ResponseEntity containing a list of matching recipes
     */
    @GetMapping("/{ingredients}/{dishType}")
    public ResponseEntity<List<Recipe>> searchRecipe(
            @PathVariable List<String> ingredients,
            @PathVariable String dishType) {
        return ResponseEntity.ok(recipeService.searchRecipes(ingredients, dishType));
    }
}
