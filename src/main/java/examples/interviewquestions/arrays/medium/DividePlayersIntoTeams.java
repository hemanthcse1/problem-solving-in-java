package examples.interviewquestions.arrays.medium;

import java.util.Arrays;

public class DividePlayersIntoTeams {

    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        int targetSkill = skill[0] + skill[n - 1];
        long totalChemistry = 0;

        for (int i = 0; i < n / 2; i++) {
            if (skill[i] + skill[n - 1 - i] != targetSkill) {
                return -1;
            }
            totalChemistry += (long) skill[i] * skill[n - 1 - i];
        }

        return totalChemistry;
    }

    public static void main(String[] args) {
        DividePlayersIntoTeams solution = new DividePlayersIntoTeams();

        int[] skill1 = {3, 2, 5, 1, 3, 4};
        System.out.println(solution.dividePlayers(skill1));

        int[] skill2 = {3, 4};
        System.out.println(solution.dividePlayers(skill2));

        int[] skill3 = {1, 1, 2, 3};
        System.out.println(solution.dividePlayers(skill3));
    }
}
