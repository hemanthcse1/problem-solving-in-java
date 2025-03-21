package examples.daily.march;

import java.util.*;

public class RecipeFinderApp {

    public static void main(String[] args) {
        String[] recipes = {"bread", "sandwich", "burger"};

        List<List<String>> ingredients = new ArrayList<>();
        ingredients.add(Arrays.asList("yeast", "flour"));
        ingredients.add(Arrays.asList("bread", "meat"));
        ingredients.add(Arrays.asList("sandwich", "meat", "bread"));

        String[] supplies = {"yeast", "flour", "meat"};

        RecipeFinderApp recipeFinder = new RecipeFinderApp();
        List<String> possibleRecipes = recipeFinder.findAllRecipes(recipes, ingredients, supplies);

        System.out.println("Recipes you can create: " + possibleRecipes);
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> available = new HashSet<>(Arrays.asList(supplies));
        Map<String, List<String>> ingredientToRecipes = new HashMap<>();
        Map<String, Integer> recipeInDegree = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            recipeInDegree.put(recipes[i], ingredients.get(i).size());
            for (String ingredient : ingredients.get(i)) {
                ingredientToRecipes.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(recipes[i]);
            }
        }

        Queue<String> queue = new LinkedList<>(available);
        List<String> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (recipeInDegree.containsKey(current)) {
                result.add(current);
            }

            if (ingredientToRecipes.containsKey(current)) {
                for (String recipe : ingredientToRecipes.get(current)) {
                    recipeInDegree.put(recipe, recipeInDegree.get(recipe) - 1);
                    if (recipeInDegree.get(recipe) == 0) {
                        queue.offer(recipe);
                    }
                }
            }
        }
        return result;
    }


}
