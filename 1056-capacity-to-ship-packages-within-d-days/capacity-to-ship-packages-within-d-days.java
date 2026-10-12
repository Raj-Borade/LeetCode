class Solution {
    public int shipWithinDays(int[] arr, int days) {
        int max = Integer.MIN_VALUE, sum = 0;
    	for (int ele : arr)
    	{
    		max = Math.max(max,  ele);
    		sum += ele;
    	}
    	int lo = max, hi = sum, ans = -1;
    	while (lo <= hi) {
    		int mid = lo + (hi - lo) / 2;
    		if (day(mid, arr) <= days) {
    			hi = mid - 1;
    			ans = mid;
    		}
    		else  lo = mid + 1;
    	}
    	return ans;
    	
    }

	private int day(int capacity, int[] arr) {
		
		// TODO Auto-generated method stub
		int day = 0;
		int c = capacity;
		for (int ele : arr) {
			if (c >= ele) c -= ele;
			else {
				day++;
				c = capacity - ele;;
				
			}
		}
		day++;
		return day;
    }
}