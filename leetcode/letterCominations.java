public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
		if(digits == null) return list;
		Map<Integer, List<Character>> map = new HashMap<Integer, List<Character>>();
		map.put(2, Arrays.asList('a', 'b', 'c'));
		map.put(3, Arrays.asList('d', 'e', 'f'));
		map.put(4, Arrays.asList('g', 'h', 'i'));
		map.put(5, Arrays.asList('j', 'k', 'l'));
		map.put(6, Arrays.asList('m', 'n', 'o'));
		map.put(7, Arrays.asList('p', 'q', 'r', 's'));
		map.put(8, Arrays.asList('t', 'u', 'v'));
		map.put(9, Arrays.asList('w', 'x', 'y', 'z'));
		helper(list, digits, "", map);
		return list;
    }
	public void helper(List<String> list, String digits, String s, Map<Integer, List<Character>> map) {
		if(digits.length() == 0) {
			list.add(s);
			return;
		}
		int c = digits.charAt(0) - '0';
		List<Character> characters = map.get(c);
		Iterator<Character> it = characters.iterator();
		while(it.hasNext()) {
			char d = it.next();
			helper(list, digits.substring(1), s + d, map);
		}
		
	}
}
