package examples.interviewquestions.strings.easy;

public class FindCountOfSeniorCitizens {

    public static void main(String[] args) {
        String[] details = {"7868190130M7522","5303914400F9211","9273338290F4010"};

        System.out.println("count -> "+findSeniorCitizens(details));


    }

    public static int findSeniorCitizens(String[] details){
        int count = 0;

        for (String citizen: details){
            int age = Integer.parseInt(citizen.substring(11,13));
            if (age > 60){
                count++;
            }
        }
        return count;
    }


}
