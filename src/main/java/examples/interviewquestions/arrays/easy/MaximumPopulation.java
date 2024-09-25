package examples.interviewquestions.arrays.easy;

public class MaximumPopulation {
    public int maximumPopulation(int[][] logs) {
        int[] populationChanges = new int[101];

        for (int[] log : logs) {
            int birthYear = log[0];
            int deathYear = log[1];

            populationChanges[birthYear - 1950]++;
            populationChanges[deathYear - 1950]--;
        }

        int maxPopulation = 0;
        int maxYear = 1950;
        int currentPopulation = 0;

        for (int year = 0; year < 101; year++) {
            currentPopulation += populationChanges[year];

            if (currentPopulation > maxPopulation) {
                maxPopulation = currentPopulation;
                maxYear = 1950 + year;
            }
        }

        return maxYear;
    }

    public static void main(String[] args) {
        MaximumPopulation solution = new MaximumPopulation();

        int[][] logs1 = {{1993, 1999}, {2000, 2010}};
        System.out.println(solution.maximumPopulation(logs1));

        int[][] logs2 = {{1950, 1961}, {1960, 1971}, {1970, 1981}};
        System.out.println(solution.maximumPopulation(logs2));
    }
}
