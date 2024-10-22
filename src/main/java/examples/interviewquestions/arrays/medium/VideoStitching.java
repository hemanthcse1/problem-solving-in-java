package examples.interviewquestions.arrays.medium;

import java.util.Arrays;

public class VideoStitching {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int clipsUsed = 0;
        int currentEnd = 0;
        int nextEnd = 0;

        int i = 0;
        while (i < clips.length && currentEnd < time) {
            if (clips[i][0] > currentEnd) {
                return -1;
            }

            while (i < clips.length && clips[i][0] <= currentEnd) {
                nextEnd = Math.max(nextEnd, clips[i][1]);
                i++;
            }

            clipsUsed++;
            currentEnd = nextEnd;

            if (currentEnd >= time) {
                return clipsUsed;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        VideoStitching solution = new VideoStitching();

        int[][] clips1 = {{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
        int time1 = 10;
        System.out.println(solution.videoStitching(clips1, time1));

        int[][] clips2 = {{0, 1}, {1, 2}};
        int time2 = 5;
        System.out.println(solution.videoStitching(clips2, time2));

        int[][] clips3 = {{0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7}, {1, 3}, {4, 7}, {1, 4}, {2, 5}, {2, 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}};
        int time3 = 9;
        System.out.println(solution.videoStitching(clips3, time3));
    }
}
