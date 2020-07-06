package problem14;

class Solution {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"flower","flow","flight"}));
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String cmnPref = strs[0];
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("")) {
                return "";
            }
            if (strs[i].charAt(0) != cmnPref.charAt(0)) {
                return "";
            }
            else {
                //index starts at 1 since prev means we already have first char match
                int index = 1;
                String newCmnPref = "" + cmnPref.charAt(0);
                while (index < strs[i].length() && index < cmnPref.length()) {
                    if (strs[i].charAt(index) != cmnPref.charAt(index)) {
                        cmnPref = newCmnPref;
                        break;
                    }
                    else {
                        newCmnPref += cmnPref.charAt(index);
                        index ++;
                    }
                }
                cmnPref = newCmnPref;
            }
        }
        return cmnPref;
    }

}
