package examples.interviewquestions.hashmaps.medium;

import java.util.HashMap;

public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int boomerangs = 0;

        for (int[] p1 : points) {
            HashMap<Integer, Integer> distanceCount = new HashMap<>();

            for (int[] p2 : points) {
                if (p1 == p2) continue;
                int dx = p1[0] - p2[0];
                int dy = p1[1] - p2[1];
                int distanceSquared = dx * dx + dy * dy;

                distanceCount.put(distanceSquared, distanceCount.getOrDefault(distanceSquared, 0) + 1);
            }

            for (int count : distanceCount.values()) {
                boomerangs += count * (count - 1);
            }
        }

        return boomerangs;
    }

    public static void main(String[] args) {
        NumberOfBoomerangs boomerangs = new NumberOfBoomerangs();
        System.out.println(boomerangs.numberOfBoomerangs(new int[][]{{0,0}, {1,0}, {2,0}}));
        System.out.println(boomerangs.numberOfBoomerangs(new int[][]{{1,1}, {2,2}, {3,3}}));
        System.out.println(boomerangs.numberOfBoomerangs(new int[][]{{1,1}}));
    }
}
