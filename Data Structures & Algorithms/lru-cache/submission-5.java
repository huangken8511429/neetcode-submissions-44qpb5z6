class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    Node left;
    Node right;
    int capacity;
    private HashMap<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.left = this.right = new Node(0, 0);
        this.cache = new HashMap<>();
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    private void insert(Node node) {
        Node prev = this.right.prev;
        Node next = this.right;
        prev.next = next.prev = node;
        node.prev = prev;
        node.next = next; 
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node nxt = node.next;
        prev.next = nxt;
        nxt.prev = prev;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node node = new Node(key, value);
        insert(node); 
        cache.put(node.key, node);

        if (cache.size() > capacity) {
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
