class Solution {
    public boolean isValid(String s) {
        //Practice 3
        Map<Character, Character> pairs = Map.of(
            ')', '(',
            '}', '{',
            ']', '['
        );
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()){
            if(pairs.containsKey(c)){
                if(stack.isEmpty() || pairs.get(c) != stack.pop()){
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();        
    }
}
