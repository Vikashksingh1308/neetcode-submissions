class KthLargest {
    // instaialise
    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
        }

        while (minHeap.size() > k) {
            minHeap.poll();
        }
    }

    public int add(int num) {
        if (minHeap.size() < k) {
            minHeap.add(num);
        } else if (num > minHeap.peek()) {
            // if minHeap is not less than k, means its equals k then, add nums and remove the first
            // number in the queue
            minHeap.add(num);
            minHeap.poll();
        }
        return minHeap.peek();
    }
}