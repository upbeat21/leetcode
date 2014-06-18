public class Solution {
    public int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<Integer>();
		for(int n : num) set.add(n);
		int r = 0;
		for(int i=0;i<num.length;i++) {
			int l = 1;
			int j = 1;
			while(true) {
				int tmp = num[i] - j;
				if(set.contains(tmp)) {
					set.remove(tmp);
					l++;
					j++;
				}
				else break;
			}
			j = 1;
			while(true) {
				int tmp = num[i] + j;
				if(set.contains(tmp)) {
					set.remove(tmp);
					l++;
					j++;
				}
				else break;
			}
			if(r < l) r = l;
		}
		return r;
    }
}
