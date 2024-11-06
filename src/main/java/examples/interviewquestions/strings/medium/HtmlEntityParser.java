package examples.interviewquestions.strings.medium;

import java.util.HashMap;
import java.util.Map;

public class HtmlEntityParser {
    public String entityParser(String text) {
        Map<String, String> entityMap = new HashMap<>();
        entityMap.put("&quot;", "\"");
        entityMap.put("&apos;", "'");
        entityMap.put("&amp;", "&");
        entityMap.put("&gt;", ">");
        entityMap.put("&lt;", "<");
        entityMap.put("&frasl;", "/");

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < text.length()) {
            if (text.charAt(i) == '&') {
                int semicolonIndex = text.indexOf(';', i);
                if (semicolonIndex != -1) {
                    String potentialEntity = text.substring(i, semicolonIndex + 1);
                    if (entityMap.containsKey(potentialEntity)) {
                        result.append(entityMap.get(potentialEntity));
                        i = semicolonIndex + 1;
                        continue;
                    }
                }
            }
            result.append(text.charAt(i));
            i++;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        HtmlEntityParser parser = new HtmlEntityParser();

        System.out.println(parser.entityParser("&amp; is an HTML entity but &ambassador; is not."));

        System.out.println(parser.entityParser("and I quote: &quot;...&quot;"));

        System.out.println(parser.entityParser("&amp;quot;&amp;apos;&amp;amp;&amp;gt;&amp;lt;&amp;frasl;"));
    }
}
