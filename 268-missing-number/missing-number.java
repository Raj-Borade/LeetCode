class Solution {
    public int missingNumber(int[] arr) {
		HashSet<Integer> set = new HashSet<>();
		
		for (int ele : arr)
            set.add(ele);

		for (int i = 0; i <= arr.length; i++) {
			if (!set.contains(i)) 
				return i;
		}
		return -1;
	}
}