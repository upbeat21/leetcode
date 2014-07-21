public class Solution {
    public List<String> anagrams(String[] strs) {
		List<String> list = new ArrayList<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0;i<strs.length;i++) {
			String s = sort(strs[i]);
			if(map.containsKey(s)) {
				if(map.get(s) != -1) {
					list.add(strs[map.get(s)]);
					map.put(s, -1);
				}
				list.add(strs[i]);
			} else {
				map.put(s, i);
			}
		}
		return list;
    }
	public String sort(String s) {
		List<Character> list = new ArrayList<Character>();
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(c >= 'a' && c <= 'z') list.add(c);
		}
		Collections.sort(list, new Comparator<Character>() {
			@Override
			public int compare(Character a, Character b) {
				return a - b;
			}
		});
		StringBuilder sb = new StringBuilder();
		for(char c : list) {
			sb.append(c);
		}
		return sb.toString();
	}
}
