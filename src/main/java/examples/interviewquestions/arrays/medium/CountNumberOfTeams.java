package examples.interviewquestions.arrays.medium;

public class CountNumberOfTeams {

    public int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;

        for (int j = 1; j < n - 1; j++) {
            int leftSmaller = 0, leftLarger = 0, rightSmaller = 0, rightLarger = 0;

            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) leftSmaller++;
                if (rating[i] > rating[j]) leftLarger++;
            }

            for (int k = j + 1; k < n; k++) {
                if (rating[k] < rating[j]) rightSmaller++;
                if (rating[k] > rating[j]) rightLarger++;
            }

            count += leftSmaller * rightLarger;
            count += leftLarger * rightSmaller;
        }

        return count;
    }

    public static void main(String[] args) {
        CountNumberOfTeams solution = new CountNumberOfTeams();
        int[] rating1 = {2, 5, 3, 4, 1};
        int[] rating2 = {2, 1, 3};
        int[] rating3 = {1, 2, 3, 4};

        System.out.println(solution.numTeams(rating1));
        System.out.println(solution.numTeams(rating2));
        System.out.println(solution.numTeams(rating3));
    }

}
