class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 0;

        for (int ele : nums) {
            if (map.containsKey(ele))
                count += map.get(ele);

            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        return count;
    }
}