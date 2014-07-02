public class Solution {
    /*
    I = 1;
    V = 5;
    X = 10;
    L = 50;
    C = 100;
    D = 500;
    M = 1000;
    */
    public String intToRoman(int num) {
        String[] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<symbol.length;i++) {
            while(num >= value[i]) {
                sb.append(symbol[i]);
                num -= value[i];
            }
        }
        return sb.toString();
    }
}
