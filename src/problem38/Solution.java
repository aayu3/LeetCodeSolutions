package problem38;

class Solution {
    public String countAndSay(int n) {
        if(1 == n) {
            return "1";
        }

        String s = countAndSay(n-1);
        StringBuffer buffer = new StringBuffer();
        final char[] chars = s.toCharArray();

        int i = 0;
        while(i < s.length()) {
            int consecutiveChars = consecutiveChars(chars[i], chars, i);
            buffer.append(consecutiveChars);
            buffer.append(chars[i]);
            i = i + consecutiveChars;
        }

        return buffer.toString();
    }

    public int consecutiveChars(char c, char[] chars, int idx) {
        int result = 1;
        for(int i = idx + 1; i < chars.length; i++) {
            if(chars[i] != c) {
                return result;
            }
            result++;
        }
        return result;
    }
}