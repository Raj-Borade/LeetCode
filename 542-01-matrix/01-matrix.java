import java.util.*;

class Solution {
    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int[][] updateMatrix(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        int[][] ans = new int[m][n];
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) q.add(new Pair(i, j));
                else ans[i][j] = -1;
            }
        }

        while (q.size() > 0) {
            Pair front = q.remove();
            int row = front.row, col = front.col;

            // Left
            if (col - 1 >= 0 && ans[row][col - 1] == -1) {
                ans[row][col - 1] = ans[row][col] + 1;
                q.add(new Pair(row, col - 1));
            }

            // Right
            if (col + 1 < n && ans[row][col + 1] == -1) {
                ans[row][col + 1] = ans[row][col] + 1;
                q.add(new Pair(row, col + 1));
            }

            // Up
            if (row - 1 >= 0 && ans[row - 1][col] == -1) {
                ans[row - 1][col] = ans[row][col] + 1;
                q.add(new Pair(row - 1, col));
            }

            // Down
            if (row + 1 < m && ans[row + 1][col] == -1) {
                ans[row + 1][col] = ans[row][col] + 1;
                q.add(new Pair(row + 1, col));
            }
        }

        return ans;
    }
}