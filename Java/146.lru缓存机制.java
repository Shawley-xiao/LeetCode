import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 */

// @lc code=start
class LRUCache {

    HashMap<Integer, DLinkedNode> cache = new HashMap<>();
    private int size, capacity;
    private DLinkedNode head, tail;

    /**
     * 146.lru缓存机制
     */
    public class DLinkedNode {
        int key;
        int value;
        DLinkedNode prve;
        DLinkedNode next;
    }

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        tail = new DLinkedNode();

        head.next = tail;
        tail.prve = head;
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }

        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);

            ++size;

            if (size > capacity) {
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    public void addNode(DLinkedNode node) {
        node.prve = head;
        node.next = head.next;

        head.next.prve = node;
        head.next = node;
    }
    
    public void removeNode(DLinkedNode node) {
        DLinkedNode prve = node.prve;
        DLinkedNode next = node.next;

        prve.next = next;
        next.prve = prve;
    }

    public void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    public DLinkedNode popTail() {
        DLinkedNode res = tail.prve;
        removeNode(res);
        return res;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

