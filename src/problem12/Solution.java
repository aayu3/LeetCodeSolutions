package problem12;

public class Solution {
    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {
        String output = "";
        if (num == 0) {
            return output;
        }
        int thousands = num/1000;
        num -= thousands*1000;
        if (thousands > 0) {
            output = "M".repeat(thousands) + output;
        }
        if (num == 0) {
            return output;
        }
        if (num >= 900) {
            output = output + "CM";
            num -= 900;
        }
        if (num >= 500) {
            output = output + "D";
            num -= 500;
        }
        if (num >= 400) {
            output = output + "CD";
            num -= 400;
        }
        int hundreds = num/100;
        if (hundreds > 0) {
                output = output + "C".repeat(hundreds);
                num -= 100*hundreds;
        }
        if (num == 0) {
            return output;
        }
        if (num >= 90) {
            output = output + "XC";
            num -= 90;
        }
        if (num >= 50) {
            output = output + "L";
            num -= 50;
        }
        if (num >= 40) {
            output = output + "XL";
            num-= 40;
        }
        int tens = num/10;
        if (tens > 0) {
            output = output + "X".repeat(tens);
            num -= 10*tens;
        }
        if (num == 0) {
            return output;
        }
        if (num == 9) {
            return output + "IX";
        }
        if (num >= 5) {
            output = output + "V";
            num -= 5;
        }
        if (num == 4) {
            return output + "IV";
        }
        return output + "I".repeat(num);


    }
}
