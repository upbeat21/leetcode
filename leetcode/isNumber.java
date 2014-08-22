public class Solution {
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0) return false;
		s = s.trim();
		if(s.length() == 0) return false;
		boolean hasNumber = false;
		boolean canSign = true;
		boolean canDot = true;
		boolean canE = false;
		boolean hasE = false;
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(c == '-' || c == '+') {
				if(!canSign) return false;
				canSign = false;
			} else if(c == '.') {
				if(!canDot) return false;
				canDot = false;
				canSign = false;
			} else if(c == 'e' || c == 'E') {
				if(!canE || hasE) return false;
				hasNumber = false;
				canE = false;
				hasE = true;
				canSign = true;
				canDot = false;
			} else if(c >= '0' && c <= '9') {
				hasNumber = true;
				canSign = false;
				canE = true;
			} else return false;
			
		}
		return hasNumber;
    }
	
}
