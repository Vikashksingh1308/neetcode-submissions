class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int maxLength = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char c = s.charAt(windowEnd);

            if (lastSeen.containsKey(c) && lastSeen.get(c) >= windowStart) {
                windowStart = lastSeen.get(c) + 1;
            }

            lastSeen.put(c, windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }
}