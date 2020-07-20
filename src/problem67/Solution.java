package problem67;

class Solution {
    public String addBinary(String a, String b) {
        if (a == null || b == null || a.length() ==0 || b.length() == 0) return "";
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i>= 0 || j >=0){
            int first = (i< 0) ? 0 : a.charAt(i) - '0';
            int second = (j < 0) ? 0 : b.charAt(j) - '0';
            int sum = first + second + carry;
            sb.append(sum%2);
            carry = sum / 2;
            i--;
            j--;
        }
        if (carry != 0){
            //extra digit
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}