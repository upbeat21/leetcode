public class Solution {
    public String strStr(String haystack, String needle) {
        if(haystack == null) return null;
		if(needle == null) return null;
		if(needle == "") return haystack;
		int len = needle.length();
		for(int i=0;i<haystack.length();i++) {
			if(i+len > haystack.length()) return null;
			String s = haystack.substring(i, i+len);
			if(s.equals(needle)) return haystack.substring(i);
		}
		return null;
    }
}
