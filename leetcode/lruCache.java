public class LRUCache {
	DoublyLinkedList list;
	HashMap<Integer, DoublyLinkedNode> map;
	int capacity;
	public static class DoublyLinkedNode {
		int key;
		int val
		DoublyLinkedNode prev;
		DoublyLinkedNode next;
		public DoublyLinkedNode(int k, int v) {
			key = k;
			val = v;
			prev = null;
			next = null;
		}
	}
	
	public static class DoublyLinkedList {
		private DoublyLinkedNode oldest;
		private DoublyLinkedNode latest;
		private int size;
		public DoublyLinkedList() {
			oldest == null;
			latest == null;
		}
		public void addToEnd(DoublyLinkedList node) {
			if(oldest == null && latest == null) {
				oldest = node;
				latest = node;
			} else {
				latest.next = node;
				node.prev = latest;
				latest = node;
			}
			size++;
		}
		public DoublyLinkedNode deleteFront() {
			if(oldest == null && latest == null) {
				throw new NullPointerException();
			}
			DoublyLinkedNode tmp = oldest;
			tmp.next = null;
			oldest = oldest.next;
			oldest.prev = null;
			size--;
			return tmp;
		}
		public int size() {
			return size;
		}
		public boolean isEmpty() {
			return size == 0;
		}
	}
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
		list = new DoublyLinkedList();
		map = new HashMap<Integer, DoublyLinkedNode>();
    }
    
    public int get(int key) {
        return map.get(key).value;
    }
    
    public void set(int key, int value) {
		if(map.contains(key)) {
			DoublyLinkedNode entry = map.get(key);
			entry.prev.next = entry.next;
			entry.prev = null;
			entry.next = null;
			list.addToEnd(entry);
		} else {
			DoublyLinkedNode entry = new DoublyLinkedNode(key, value);
			list.addToEnd(entry);
			map.add(key, entry);
			if(list.size() > capacity) {
				DoublyLinkedNode node = list.deleteFront();
				map.remove(node.key);
			}
		}
        
    }
}
