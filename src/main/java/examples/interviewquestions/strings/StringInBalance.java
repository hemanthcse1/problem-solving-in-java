package examples.interviewquestions.strings;

public class StringInBalance {

    public static void main(String[] args) {
        String s = "RLRRLLRLRL";

        System.out.println("Number of pairs :"+stringInBalance(s));
    }

    public static int stringInBalance(String s){
        int balance = 0;
        int count = 0;

        for( char c : s.toCharArray()){

            if (c == 'L'){
                balance++;
            }else if (c == 'R'){
                balance--;
            }
            if (balance == 0){
                count++;
            }
        }

        return count;
    }
}
