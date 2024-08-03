package examples.interviewquestions.strings;

import java.util.HashMap;
import java.util.Map;

public class ReformatDate {
    public static void main(String[] args) {
        String date = "20th Oct 2052";
        String reformattedDate = reformatDate(date);
        System.out.println("Reformatted Date: " + reformattedDate);
    }

    public static String reformatDate(String date) {

        Map<String, String> monthMap = new HashMap<>();
        monthMap.put("Jan", "01");
        monthMap.put("Feb", "02");
        monthMap.put("Mar", "03");
        monthMap.put("Apr", "04");
        monthMap.put("May", "05");
        monthMap.put("Jun", "06");
        monthMap.put("Jul", "07");
        monthMap.put("Aug", "08");
        monthMap.put("Sep", "09");
        monthMap.put("Oct", "10");
        monthMap.put("Nov", "11");
        monthMap.put("Dec", "12");

        String[] parts = date.split(" ");
        String day = parts[0].replaceAll("\\D", "");
        String month = monthMap.get(parts[1]);
        String year = parts[2];

        if (day.length() == 1) {
            day = "0" + day;
        }

        return year + "-" + month + "-" + day;
    }
}
