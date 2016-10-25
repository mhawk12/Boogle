package com.hfad.boogle;

/**
 * Created by Nishant on 10/23/16.
 */

public class Bit {
    int m, n;
    int[][] arr;    // stores matrix[][]
    int[][] BITree; // 2-D binary indexed tree
    StringBuilder strbuilder = new StringBuilder();
    public Bit(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        m = matrix.length;
        n = matrix[0].length;

        arr = new int[m][n];
        BITree = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(i, j, matrix[i][j]); // init BITree[][]
                arr[i][j] = matrix[i][j];   // init arr[][]
            }
        }
    }

   public void update(int i, int j, int val) {
        int diff = val - arr[i][j];  // get the diff
        arr[i][j] = val;             // update arr[][]

        i++;
        j++;
        for (int x = i; x <= m; x += x & (-x)) {
            for (int y = j; y <= n; y += y & (-y)) {
                BITree[x][y] += diff;
            }
        }
    }

    int getSum(int i, int j) {
        int sum = 0;

        i++;
        j++;
        for (int x = i; x > 0; x -= x & (-x)) {
            for (int y = j; y > 0; y -= y & (-y)) {
                sum += BITree[x][y];
            }
        }
        return sum;
    }

    public int sumRegion(int i1, int j1, int i2, int j2) {
        return getSum(i2, j2) - getSum(i1 - 1, j2) - getSum(i2, j1 - 1) + getSum(i1 - 1, j1 - 1);
    }
}