package examples.daily.february;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class NumberContainers {

    private Map<Integer, Integer> indexMap;
    private Map<Integer, TreeSet<Integer>> numMap;

    public NumberContainers() {
        indexMap = new HashMap<>();
        numMap = new HashMap<>();
    }

    public void change(int index, int number) {

        if (indexMap.containsKey(index)) {
            int oldNumber = indexMap.get(index);
            numMap.get(oldNumber).remove(index);
            if (numMap.get(oldNumber).isEmpty()) {
                numMap.remove(oldNumber);
            }
        }


        indexMap.put(index, number);


        numMap.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }

    public int find(int number) {

        return numMap.containsKey(number) && !numMap.get(number).isEmpty() ? numMap.get(number).first() : -1;
    }

    public static void main(String[] args) {
        NumberContainers nc = new NumberContainers();
        System.out.println(nc.find(10)); // -1
        nc.change(2, 10);
        nc.change(1, 10);
        nc.change(3, 10);
        nc.change(5, 10);
        System.out.println(nc.find(10)); // 1
        nc.change(1, 20);
        System.out.println(nc.find(10)); // 2
    }
}
