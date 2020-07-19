package problem28;

class Solution {
    public int strStr(String h, String needle) {
        if(needle.length() == 0 || needle == null || h.equals(needle)) return 0;
        if(h.length() < needle.length() || !h.contains(needle)) return -1;

        int i = 0;
        while(i<h.length()){

            int aindex = i;
            int j = 0;

            while(j<needle.length()){
                char a = h.charAt(aindex);
                char b = needle.charAt(j);
                if(a==b){
                    aindex++;
                    j++;
                }
                else{
                    break;
                }
                if(j >= needle.length())
                    return i;
            }
            i++;
        }
        return -1;
    }
}