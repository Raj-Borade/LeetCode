class Solution {
    public int countKDifference(int[] nums, int k) {
        
        HashMap<Integer, Integer> set = new HashMap<>();
        int count = 0;

        for (int ele : nums) {
            if (set.containsKey(ele - k))
            count += set.get(ele - k);
            if (set.containsKey(ele + k))
            count += set.get(ele + k);

            set.put(ele, set.getOrDefault(ele, 0) + 1);
        }
        return count;
    }
}



//      HsashSet Brute force - O(n^2)

// class Solution {
//     public int countKDifference(int[] nums, int k) {
        
//         HashSet<Integer> set = new HashSet<>();
//         int count = 0;

//         for (int i = 0; i < nums.length; i++) {
//             for (int j = i + 1; j < nums.length; j++) {
//                 if (Math.abs(nums[i] - nums[j]) == k)
//                     count++;
//             }
//         }

//         return count;
//     }
// }