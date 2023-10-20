# Recipes book

## 1. Add a recipe

This endpoint allows you to add a new recipe to the system.

- Endpoint: `/api/recipeBook/recipes`
- Method: `POST`
- Request Body:

```json
{
  "title": "Chocolate Cake",
  "ingredients": [
    "flour",
    "sugar",
    "cocoa powder",
    "eggs"
  ],
  "instructions": "1. Preheat oven. 2. Mix dry ingredients. 3. Beat eggs and add melted butter and vanilla. 4. Combine wet and dry mixtures. 5. Bake until done.",
  "dishType": "dessert"
}
```

## 2. Get all recipes

This endpoint retrieves a list of recipes from the server.

- Endpoint: `/api/recipesBook/recipes`
- Method: `GET`

## 3. Search recipes by ingredients and main course

This endpoint allows you to search for recipes based on ingredients and dish type.

Endpoint: `/api/recipesBook/recipes/{ingredients}/{dishType}`

Method: `GET`

Example: `/api/recipesBook/recipes/eggs,sugar/dessert`