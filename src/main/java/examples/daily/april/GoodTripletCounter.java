package examples.daily.april;

public class GoodTripletCounter {

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        int n = arr.length;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) > a) continue;
                for (int k = j + 1; k < n; k++) {
                    if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        GoodTripletCounter solver = new GoodTripletCounter();
        System.out.println(solver.countGoodTriplets(new int[]{3, 0, 1, 1, 9, 7}, 7, 2, 3)); //  4
        System.out.println(solver.countGoodTriplets(new int[]{1, 1, 2, 2, 3}, 0, 0, 1));    //  0
    }
}
