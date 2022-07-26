package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int[] kWeakestRows(int[][] mat, int k) {
        int[] res = new int[k];
        Map<Integer,Integer> counts = new HashMap<>();

        for (int i = 0; i < mat.length; i++ ){
            counts.put(i, 0);
            for (int j = 0; j < mat[1].length; j++){
                if (mat[i][j] == 0) break;
                else counts.put(i, counts.get(i) + 1);
            }
        }

        for (int i = 0; i < k; i++){
            int minVal = mat[1].length+1;
            int minj = -1;
            for (Integer j: counts.keySet()) {
                if (counts.get(j) < minVal) {
                    minj = j;
                    minVal = counts.get(j);
                }
            }
            res[i] = minj;
            counts.remove(minj);

        }


        return res;
    }
    public static void main(String[] args) {
	// write your code here
        int[][] mat = {{1,1,0,0,0},
                    {1,1,1,1,0},
                    {1,0,0,0,0},
                    {1,1,0,0,0},
                    {1,1,1,1,1}};

        System.out.println(Arrays.toString(kWeakestRows(mat, 3)));
    }
}
