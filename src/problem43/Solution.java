package problem43;

class Solution {
    public String multiply(String num1, String num2) {

        int n1 = num1.length(), n2 = num2.length();
        if(n1 == 0 || n2 == 0) return "";

        int[] prod = new int[n1 + n2];

        for(int i = n1 - 1; i >= 0; i -= 1){

            int dig1 = num1.charAt(i) - '0';
            int forward = 0;

            for(int j = n2 - 1; j >= 0; j -= 1){

                int dig2 = num2.charAt(j) - '0';

                int prev = prod[i + j + 1];
                prod[i + j + 1] = (prod[i + j + 1] + dig1 * dig2 + forward) % 10;
                forward = (prev + dig1 * dig2  + forward) / 10;

                if(j == 0 && forward > 0){
                    prod[i] = forward;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(index < n1+n2 && prod[index] == 0){
            index++;
        }
        while(index < n1+n2){
            sb.append(prod[index++]);
        }
        return sb.length()== 0 ? "0" : sb.toString();
    }
}