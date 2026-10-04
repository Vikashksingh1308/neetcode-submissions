class Solution {
    public boolean isPalindrome(String s) {
        String cleaned = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        char[] str1 = cleaned.toCharArray();
        char[] str2 = new char[str1.length];

        for(int i=0; i < str1.length; i++){
            str2[i] = str1[str1.length -1 -i];
        }

        for (int i = 0; i < str1.length; i++) {
            if (str1[i] != str2[i]) {
                return false;
            }
        }
        return true;
    }
}
