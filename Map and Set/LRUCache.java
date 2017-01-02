import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private int capacity;
    private Map<Integer, LRUnode> map;
    private LRUnode head;
    private LRUnode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, LRUnode>(); // lazy initialization
    }

    public int get(int key) {

        if (map.containsKey(key)) {
            LRUnode node = map.get(key);
            remove(node);
            setHead(node);
            return node.value;
        }

        return -1;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            LRUnode oldNode = map.get(key);
            oldNode.value = value;
            remove(oldNode);
            setHead(oldNode);
        } else {
            LRUnode newNode = new LRUnode(key, value);
            if (map.size() >= capacity) {
                map.remove(tail.key);
                remove(tail);
            }
            setHead(newNode);

            map.put(key, newNode);
        }
    }

    public void remove(LRUnode node) {

        if (node.pre != null) {
            node.pre.next = node.next;
        } else {
            head = node.next;
            head.pre = null;
        }

        if (node.next != null) {
            node.next.pre = node.pre;
        } else {
            tail = node.pre;
        }

    }

    public void setHead(LRUnode node) {
        node.next = head;
        node.pre = null;

        if (head != null) {
            head.pre = node;
        }

        head = node;

        if (tail == null) {
            tail = head;
        }
    }

    // main test
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(4);

        lruCache.set(1, 1);
        lruCache.set(2, 2);
        lruCache.set(3, 3);
        lruCache.set(4, 4);
        lruCache.set(5, 5);

        // note 1 has been pushed out of the cache
        System.out.println(lruCache.get(2));

    }
    
 // doubly linked list
 // the node cannot have just the value due to map element removal
 class LRUnode {
     int key;
     int value;
     LRUnode pre;
     LRUnode next;

     public LRUnode(int key, int value) {
         this.key = key;
         this.value = value;
     }
 }

}


