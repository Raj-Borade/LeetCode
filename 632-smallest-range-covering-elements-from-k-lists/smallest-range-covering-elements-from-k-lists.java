class Pair implements Comparable<Pair> {

    int val;
    int row;
    int col;

    Pair(int val, int row, int col) {
        this.val = val;
        this.row = row;
        this.col = col;
    }

    public int compareTo(Pair p) {
        return this.val - p.val;
    }
}

class Solution {

    public int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); i++) {

            int val = nums.get(i).get(0);

            pq.add(new Pair(val, i, 0));

            max = Math.max(max, val);
        }

        int start = pq.peek().val;
        int end = max;

        while (true) {

            Pair top = pq.remove();

            int min = top.val;

            if (max - min < end - start) {
                start = min;
                end = max;
            }

            int nextCol = top.col + 1;

            if (nextCol >= nums.get(top.row).size())
                break;

            int nextVal = nums.get(top.row).get(nextCol);

            pq.add(new Pair(nextVal, top.row, nextCol));

            max = Math.max(max, nextVal);
        }

        return new int[] {start, end};
    }
}