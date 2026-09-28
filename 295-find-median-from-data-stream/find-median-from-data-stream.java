class MedianFinder {
	ArrayList<Integer> arr;
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {
        arr = new ArrayList<>();
    }
    
    public void addNum(int num) {
        if(maxHeap.size() == 0) maxHeap.add(num);
        else {
        	if (num < maxHeap.peek()) maxHeap.add(num);
        	else minHeap.add(num);
        }
        if (maxHeap.size() == minHeap.size() + 2)
        		minHeap.add(maxHeap.remove());
        if (minHeap.size() == maxHeap.size() + 2)
        	maxHeap.add(minHeap.remove());
    }
    
    public double findMedian() {
//        Collections.sort(arr);
//        int n = arr.size();
//        if (n % 2 == 1) return (arr.get(n / 2));
//        else {
//        	return (arr.get(n / 2) + arr.get(n / 2 - 1))/2.0;
//        }
    	
    	if(maxHeap.size() == minHeap.size() + 1)
    		return maxHeap.peek();
    	else if(minHeap.size() == maxHeap.size() + 1)
    		return minHeap.peek();
    	else return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
	
	}