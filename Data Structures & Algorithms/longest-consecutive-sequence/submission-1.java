class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num); // Step 1. Set created
        }

        int best = 0; // initialise best as counter or best streak

        for (int n : set) {
            boolean hasPrev = set.contains(n - 1);

            if (hasPrev == false) {
                int curr = n;
                int len = 1;

                while (set.contains(curr + 1)) {
                    curr++;
                    len++;
                }

                best = Math.max(best, len);
            }
        }
        return best;
    }
}
