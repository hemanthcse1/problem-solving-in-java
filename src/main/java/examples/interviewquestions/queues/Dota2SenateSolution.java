package examples.interviewquestions.queues;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2SenateSolution {

    public static String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();
        for(int i=0;i<n;i++){
            if(senate.charAt(i)=='R') radiant.offer(i);
            else dire.offer(i);
        }
        while(!radiant.isEmpty() && !dire.isEmpty()){
            int r = radiant.poll();
            int d = dire.poll();
            if(r < d){
                radiant.offer(r + n);
            }
            else{
                dire.offer(d + n);
            }
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {

        String senate1 = "RD";
        System.out.println(predictPartyVictory(senate1));

        String senate2 = "RDD";
        System.out.println(predictPartyVictory(senate2));

        String senate3 = "RRDDD";
        System.out.println(predictPartyVictory(senate3));
    }
}
