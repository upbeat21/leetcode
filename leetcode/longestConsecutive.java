public class Solution {
    public int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<Integer>();
		for(int n : num) set.add(n);
		int result = 0;
		for(int i=0;i<num.length;i++) {
			int sum = 1;
			int j = 1;
			while(set.contains(num[i]-j)) {
				set.remove(num[i]-j);
				j++;
				sum++;
			}
			j = 1;
			while(set.contains(num[i]+j)) {
				set.remove(num[i]+j);
				j++;
				sum++;
			}
			result = Math.max(result, sum);
		}
		return result;
    }
}
