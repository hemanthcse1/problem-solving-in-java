package examples.interviewquestions.hashmaps.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem {

    public static void main(String[] args) {
        SearchSuggestionsSystem system = new SearchSuggestionsSystem();

        String[] products1 = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord1 = "mouse";
        System.out.println(system.suggestedProducts(products1, searchWord1));

        String[] products2 = {"havana"};
        String searchWord2 = "havana";
        System.out.println(system.suggestedProducts(products2, searchWord2));

    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        Arrays.sort(products);
        String prefix = "";
        for(char ch : searchWord.toCharArray()) {
            prefix += ch;
            List<String> suggestions = new ArrayList<>();
            for(String product : products) {
                if(product.startsWith(prefix)) {
                    suggestions.add(product);
                    if(suggestions.size() == 3) break;
                }
            }
            result.add(suggestions);
        }
        return result;
    }
}
