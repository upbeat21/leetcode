public class LRUCache {
    
    DoublyLinkedListNode head;
    DoublyLinkedListNode tail;
    Map<Integer, DoublyLinkedListNode> map;
    int capacity;
    int size;
    
    public static class DoublyLinkedListNode {
        int key;
        int val;
        DoublyLinkedListNode prev;
        DoublyLinkedListNode next;
        public DoublyLinkedListNode(int k, int v) {
            this.key = k;
            this.val = v;
            prev = null;
            next = null;
        }
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DoublyLinkedListNode(-1, -1);
        tail = new DoublyLinkedListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<Integer, DoublyLinkedListNode>();
        size = 0;
    }
    
    public int get(int key) {
        int result = 0;
        if(map.containsKey(key)) {
            DoublyLinkedListNode node = map.get(key);
            result = node.val;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            appendToTail(node);
        } else result = -1;
        return result;
    }
    
    public void set(int key, int value) {
        DoublyLinkedListNode node = null;
        if(map.containsKey(key)) {
        	node = map.get(key);
        	node.prev.next = node.next;
        	node.next.prev = node.prev;
        	node = new DoublyLinkedListNode(key, value);
        }
        else {
            node = new DoublyLinkedListNode(key, value);
            size++;
        }
        appendToTail(node);
        if(size > capacity) {
            DoublyLinkedListNode h = removeHead();
            size--;
            map.remove(h.key);
        }
        map.put(key, node);
    }
    
    public void appendToTail(DoublyLinkedListNode node) {
        DoublyLinkedListNode prev = tail.prev;
        node.next = tail;
        tail.prev = node;
        prev.next = node;
        node.prev = prev;
    }
    
    public DoublyLinkedListNode removeHead() {
        DoublyLinkedListNode node = head.next;
        head.next = node.next;
        node.next.prev = head;
        return node;
    }
}
