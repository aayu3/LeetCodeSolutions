package problem58;

class Solution {
    public int lengthOfLastWord(String s) {

        int i = s.length()-1;

        int len=0;

        while(i>=0) {

            if(s.charAt(i)!=' ') {
                len++;
            }
            else {
                if(i!=s.length()-1 && len!=0) {
                    break;
                }
            }
            i--;
        }

        return len;
    }
}