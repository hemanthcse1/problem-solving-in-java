package examples.daily;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class FindBuildingWhereAliceAndBobCanMeetSolution {

    static class Query {
        long max_h;
        int m;
        int index;
        int ai;
        int bi;

        Query(long max_h, int m, int index, int ai, int bi){
            this.max_h = max_h;
            this.m = m;
            this.index = index;
            this.ai = ai;
            this.bi = bi;
        }
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int q = queries.length;
        int[] ans = new int[q];
        List<Query> type2B = new ArrayList<>();

        for(int i = 0; i < q; i++) {
            int ai = queries[i][0];
            int bi = queries[i][1];
            if(ai == bi){
                ans[i] = ai;
            }
            else{
                int m = Math.max(ai, bi);
                long max_h = Math.max((long)heights[ai], (long)heights[bi]);
                type2B.add(new Query(max_h, m, i, ai, bi));
            }
        }


        type2B.sort((a, b) -> Long.compare(b.max_h, a.max_h));


        int[][] sortedBuildings = new int[n][2];
        for(int i = 0; i < n; i++) {
            sortedBuildings[i][0] = heights[i];
            sortedBuildings[i][1] = i;
        }
        Arrays.sort(sortedBuildings, (a, b) -> {
            if(b[0] != a[0]) return Integer.compare(b[0], a[0]);
            else return Integer.compare(a[1], b[1]);
        });

        TreeSet<Integer> treeSet = new TreeSet<>();
        int pointer = 0;
        for(Query query : type2B){
            while(pointer < n && (long)sortedBuildings[pointer][0] > query.max_h){
                treeSet.add(sortedBuildings[pointer][1]);
                pointer++;
            }


            Integer j_from_TreeSet = treeSet.ceiling(query.m + 1);


            int min_j = Integer.MAX_VALUE;


            if(heights[query.ai] > heights[query.bi] && query.ai >= query.m){
                min_j = Math.min(min_j, query.ai);
            }


            if(heights[query.bi] > heights[query.ai] && query.bi >= query.m){
                min_j = Math.min(min_j, query.bi);
            }


            if(j_from_TreeSet != null){
                min_j = Math.min(min_j, j_from_TreeSet);
            }


            ans[query.index] = (min_j != Integer.MAX_VALUE) ? min_j : -1;
        }

        return ans;
    }

    public static void main(String[] args){
        FindBuildingWhereAliceAndBobCanMeetSolution solution = new FindBuildingWhereAliceAndBobCanMeetSolution();

        int[] heights1 = {6,4,8,5,2,7};
        int[][] queries1 = {{0,1},{0,3},{2,4},{3,4},{2,2}};
        System.out.println(Arrays.toString(solution.leftmostBuildingQueries(heights1, queries1)));

        int[] heights2 = {5,3,8,2,6,1,4,6};
        int[][] queries2 = {{0,7},{3,5},{5,2},{3,0},{1,6}};
        System.out.println(Arrays.toString(solution.leftmostBuildingQueries(heights2, queries2)));

    }
}
