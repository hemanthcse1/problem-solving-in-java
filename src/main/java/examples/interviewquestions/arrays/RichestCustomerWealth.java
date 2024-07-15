package examples.interviewquestions.arrays;

public class RichestCustomerWealth {
    public static int richestCustomer(int[][] accounts){
        int maxWealth = 0;

        for (int[] account: accounts){
            int amount = 0;
            for (int money :  account){
                amount += money;
            }
            if (amount > maxWealth){
                maxWealth = amount;
            }
        }
        return maxWealth;
    }

    public static void main(String[] args) {
        int[][] accounts = {{1,2,3},{3,2,1},{5,1,2}};

        System.out.println("Richest customers wealth "+richestCustomer(accounts));
    }
}
