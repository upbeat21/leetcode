public class Solution {
    public String intToRoman(int num) {
        int digits = 0;
        String result = "";
        int n = num;
        while(n > 0) {
            digits++;
            n /= 10;
        }
        if(digits > 4) return null;
        while(digits > 0) {
            int d = (int)(num / Math.pow(10, digits-1));
            if(d == 0) {
                digits--;
                continue;
            }
            num = num - (int)(d * Math.pow(10, digits-1));
            if(digits == 4) {
                for(int i=1;i<=d;i++) result += "M";
            } else if(digits == 3) {
                if(d >= 1 && d <= 3) {
                    for(int i=1;i<=d;i++) result += "C";
                } else if(d == 4) result += "CD";
                else if(d == 9) result += "CM";
                else {
                    result += "D";
                    for(int i=0;i<d-5;i++) result += "C";
                }
            } else if(digits == 2) {
                if(d >=1 && d<= 3) {
                    for(int i=1;i<=d;i++) result += "X";
                } else if(d == 4) result += "XL";
                else if(d == 9) result += "XC";
                else {
                    result += "L";
                    for(int i=0;i<d-5;i++) result += "X";
                }
            } else {
                if(d >= 1 && d <= 3) {
                    for(int i=1;i<=d;i++) result += "I";
                } else if(d == 4) result += "IV";
                else if(d == 9) result += "IX";
                else {
                    result += "V";
                    for(int i=0;i<d-5;i++) result += "I";
                }
            }
            digits--;
        }
        return result;
    }
}
