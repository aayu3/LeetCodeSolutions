package problem125;

class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        int left = 0;
        int right = str.length() - 1;

        while(left <= right) {
            if(!Character.isLetterOrDigit(str.charAt(left))) {
                left++;
                continue;t
            } else if(!Character.isLetterOrDigit(str.charAt(right))) {
                right--;
                continue;
            } else if(str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}