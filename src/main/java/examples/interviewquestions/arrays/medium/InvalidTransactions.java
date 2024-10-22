package examples.interviewquestions.arrays.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InvalidTransactions {

    public List<String> invalidTransactions(String[] transactions) {
        List<String> result = new ArrayList<>();
        List<Transaction> transactionList = new ArrayList<>();

        for (String transaction : transactions) {
            transactionList.add(new Transaction(transaction));
        }

        boolean[] isInvalid = new boolean[transactions.length];

        for (int i = 0; i < transactionList.size(); i++) {
            Transaction t1 = transactionList.get(i);

            if (t1.amount > 1000) {
                isInvalid[i] = true;
            }

            for (int j = 0; j < transactionList.size(); j++) {
                if (i == j) continue;

                Transaction t2 = transactionList.get(j);

                if (t1.name.equals(t2.name) && Math.abs(t1.time - t2.time) <= 60 && !t1.city.equals(t2.city)) {
                    isInvalid[i] = true;
                    isInvalid[j] = true;
                }
            }
        }
        for (int i = 0; i < isInvalid.length; i++) {
            if (isInvalid[i]) {
                result.add(transactions[i]);
            }
        }

        return result;
    }

    static class Transaction {
        String name;
        int time;
        int amount;
        String city;

        Transaction(String transaction) {
            String[] parts = transaction.split(",");
            this.name = parts[0];
            this.time = Integer.parseInt(parts[1]);
            this.amount = Integer.parseInt(parts[2]);
            this.city = parts[3];
        }
    }

    public static void main(String[] args) {
        InvalidTransactions solution = new InvalidTransactions();

        String[] transactions1 = {"alice,20,800,mtv", "alice,50,100,beijing"};
        System.out.println(solution.invalidTransactions(transactions1));

        String[] transactions2 = {"alice,20,800,mtv", "alice,50,1200,mtv"};
        System.out.println(solution.invalidTransactions(transactions2));

        String[] transactions3 = {"alice,20,800,mtv", "bob,50,1200,mtv"};
        System.out.println(solution.invalidTransactions(transactions3));

        String[] transactions4 = {"alice,20,1220,mtv", "alice,20,1220,mtv"};
        System.out.println(solution.invalidTransactions(transactions4));
    }
}
