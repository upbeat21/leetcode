public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
		boolean[] visited = new boolean[num.length];
		helper(list, visited, new ArrayList<Integer>(), num);
		return list;
    }
	public void helper(List<List<Integer>> list, boolean[] visited, List<Integer> t, int[] num) {
		if(t.size() == num.length) {
			list.add(new ArrayList<Integer>(t));
			return;
		}
		for(int i=0;i<num.length;i++) {
			if(!visited[i]) {
				t.add(num[i]);
				visited[i] = true;
				helper(list, visited, t, num);
				t.remove(t.size()-1);
				visited[i] = false;
			}
		}
	}
}
