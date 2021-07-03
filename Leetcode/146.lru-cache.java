/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class Node {
    public int key;
    public int val;
    public Node prev, next;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}


class DoubleList {
    private Node head, tail;
    private int size;
    
    public int size() {
        return size;
    }
    
    public void addFirst(Node x) {
        if (head == null) {
            head = tail = x;
        } else {
            Node n = head;
            n.prev = x;
            x.next = n;
            head = x;
        }
        size++;
    }
    
    public void remove(Node x) {
        if (head == x && tail == x) {
            head = null;
            tail = null;
        } else if (tail == x) {
            x.prev.next = null;
            tail = x.prev;
        } else if (head == x) {
            head.next.prev = null;
            head = x.next;
        } else {
            x.prev.next = x.next;
            x.next.prev = x.prev;
        }
        size--;
    }
    
    public Node removeLast() {
        Node node = tail;
        remove(tail);
        return node;
    }
}


class LRUCache {
    int cap;
    DoubleList cache;
    HashMap<Integer, Node> map;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new DoubleList();
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).val;
        put(key, val);
        return val;
    }
    
    public void put(int key, int value) {
        Node x = new Node(key, value);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
            cache.addFirst(x);
            map.put(key, x);
        } else {
            if (cap == cache.size()) {
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(x);
            map.put(key, x);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

