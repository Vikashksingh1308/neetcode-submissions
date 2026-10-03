class Solution {
    Map<Character, String> phone = new HashMap<>(){{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    //To store digits in array for lookup
    char[] arr;
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return result;
        }

        this.arr = digits.toCharArray();
        Stack<Character> stack = new Stack<>();

        helper(stack, 0);

        return result;
    }

    private void helper(Stack<Character> stack, int index){
        if(index == arr.length){
            result.add(convertStackToString(stack));
            return;
        }

        String letters = phone.get(arr[index]);
        for(char c : letters.toCharArray()){
            stack.push(c);
            helper( stack, index+1);
            stack.pop();
        }
    }

    private String convertStackToString(Stack<Character> stack){
        Iterator<Character> it = stack.iterator();
        StringBuilder sb = new StringBuilder();
        while(it.hasNext()){
            sb.append(it.next());
        }
        return sb.toString(); 
    }
}
