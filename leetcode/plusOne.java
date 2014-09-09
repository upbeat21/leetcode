public class Solution {
    public int[] plusOne(int[] digits) {
		boolean allNine = true;
		for(int i=0;i<digits.length;i++) {
			if(digits[i] != 9) allNine = false;
		}
		if(!allNine) {
			int i = digits.length-1;
			while(digits[i] == 9) {
				digits[i] = 0;
				i--;
			}
			digits[i]++;
			return digits;
		} else {
			int[] result = new int[digits.length + 1];
			result[0] = 1;
			for(int i=1;i<result.length;i++) {
				result[i] = 0;
			}
			return result;
		}
    }
}
