public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> r = new ArrayList<List<String>>();
		if(s == null || s == "") return r;
		helper(s, 0, r, new ArrayList<String>());
		return r;
    }
	public void helper(String s, int start, List<List<String>> r, ArrayList<String> t) {
		if(start >= s.length()) {
			ArrayList<String> u = new ArrayList<String>(t);
			r.add(u);
			return;
		}
		for(int i=start;i<s.length();i++) {
			String tmp = s.substring(start, i+1);
			if(isPal(tmp)) {
				t.add(tmp);
				helper(s, i+1, r, t);
				t.remove(t.size()-1);
			}
		}
	}
	public boolean isPal(String s) {
		int l = 0;
		int r = s.length()-1;
		while(l <= r) {
			if(s.charAt(l) != s.charAt(r)) return false;
			l++;
			r--;
		}
		return true;
	}
}
