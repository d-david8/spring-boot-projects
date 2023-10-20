package ro.ddavid8.springbootprojects.recipesbook.models;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Recipe {
    private UUID id;
    private String title;
    private List<String> ingredients;
    private String instructions;
    private String dishType;
}
