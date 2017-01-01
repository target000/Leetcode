import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
    }

    public int get(int key) {

        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            setHead(node);
            return node.value;
        }

        return -1;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node oldNode = map.get(key);
            oldNode.value = value;
            remove(oldNode);
            setHead(oldNode);
        } else {
            Node newNode = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(tail.key);
                remove(tail);
            }
            setHead(newNode);

            map.put(key, newNode);
        }
    }

    public void remove(Node node) {

        if (node.pre != null) {
            node.pre.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.pre = node.pre;
        } else {
            tail = node.pre;
        }

    }

    public void setHead(Node node) {
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

}

// doubly linked list
class Node {
    int key;
    int value;
    Node pre;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
