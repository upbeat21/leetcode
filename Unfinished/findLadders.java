public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> list = new ArrayList<List<String>>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        int layer = 1;
        boolean bottom = false;
        map.put(start, 0);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                String curr = queue.poll();
                for(int j=0;j<curr.length();j++) {
                    for(char c='a';c<='z';c++) {
                        if(c == curr.charAt(j)) continue;
                        String next = replace(curr, j, c);
                        if(next.equals(end)) {
                            bottom = true;
                        } else if(dict.contains(next)) {
                            queue.offer(next);
                            map.put(next, layer);
                            dict.remove(next);
                        }
                    }
                }
            }
            if(bottom) break;
            layer++;
        }
        dfs(end, start, list, new ArrayList<String>(), layer, map);
        return list;
    }
    public void dfs(String end, String start, List<List<String>> list, List<String> t, int layer, Map<String, Integer> map) {
        if(layer == 0) {
            t.add(start);
            Collections.reverse(t);
            list.add(new ArrayList<String>(t));
            return;
        }
        t.add(end);
        for(int i=0;i<end.length();i++) {
            for(char c='a';c<='z';c++) {
                if(c == end.charAt(i)) continue;
                String next = replace(end, i, c);
                if(map.containsKey(next) && map.get(next) == layer) {
                    t.add(next);
                    dfs(next, start, list, t, layer-1, map);
                    t.remove(t.size()-1);
                }
            }
        }
    }
    public String replace(String s, int i, char c) {
        return s.substring(0, i) + c + s.substring(i+1);
    }
}
