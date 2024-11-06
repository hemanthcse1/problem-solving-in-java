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

        for (Map.Entry<String, String> entry : entityMap.entrySet()) {
            text = text.replace(entry.getKey(), entry.getValue());
        }

        return text;
    }

    public static void main(String[] args) {
        HtmlEntityParser parser = new HtmlEntityParser();

        System.out.println(parser.entityParser("&amp; is an HTML entity but &ambassador; is not."));


        System.out.println(parser.entityParser("and I quote: &quot;...&quot;"));
    }
}
