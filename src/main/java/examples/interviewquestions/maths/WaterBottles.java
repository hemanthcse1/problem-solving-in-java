package examples.interviewquestions.maths;

public class WaterBottles {

    public static void main(String[] args) {
        int numBottles = 15;
        int numExchange = 4;

        System.out.println("Result -> "+numberOfWaterBottles(numBottles,numExchange));
    }

    private static int numberOfWaterBottles(int numBottles, int numExchange){
        int totalBottlesDrink = 0;
        int emptyBottles = 0;

        while (numBottles > 0){
            totalBottlesDrink += numBottles;
            emptyBottles += numBottles;

            numBottles = emptyBottles / numExchange;
            emptyBottles = emptyBottles % numExchange;
        }

        return totalBottlesDrink;
    }
}
