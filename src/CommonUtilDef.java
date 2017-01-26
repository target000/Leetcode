import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CommonUtilDef {

    public static void main(String[] args) {

        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new TreeSet<String>();
        Set<String> set3 = new LinkedHashSet<String>();

        Map<Character, Integer> map1 = new HashMap<Character, Integer>();
        Map<Character, Integer> map2 = new TreeMap<Character, Integer>();
        Map<Character, Integer> map3 = new LinkedHashMap<Character, Integer>(); // LRU

        Queue<Integer> pq = new PriorityQueue<Integer>();
        Queue<Integer> q = new LinkedList<Integer>(); // linkedlist based queue

        Deque<Integer> stack = new ArrayDeque<Integer>(); // better performance than stack
        Deque<Integer> queue = new ArrayDeque<Integer>(); // array based queue, better performance than linkedlist based

        List<Integer> ll = new LinkedList<Integer>();
        List<Integer> al = new ArrayList<Integer>();

        // Iterator
        Iterator<String> iter1 = set1.iterator();
        Iterator<String> iter2 = set2.iterator();
        Iterator<String> iter3 = set3.iterator();

        Iterator<Character> iter4 = map1.keySet().iterator();
        Iterator<Character> iter5 = map2.keySet().iterator();
        Iterator<Character> iter6 = map3.keySet().iterator();

        Iterator<Entry<Character, Integer>> iter7 = map1.entrySet().iterator();
        Iterator<Entry<Character, Integer>> iter8 = map2.entrySet().iterator();
        Iterator<Entry<Character, Integer>> iter9 = map3.entrySet().iterator();

        Iterator<Integer> iter10 = pq.iterator();
        Iterator<Integer> iter11 = q.iterator();

        Iterator<Integer> iter12 = stack.iterator();
        Iterator<Integer> iter13 = queue.iterator();

        Iterator<Integer> iter14 = ll.iterator();
        Iterator<Integer> iter15 = al.iterator();

        // how to loop through iterator
        while (iter15.hasNext()) {
            Integer myElement = (Integer) iter15.next();
        }

        // same as above only for loop
        for (Iterator<Integer> iterator = al.iterator(); iterator.hasNext();) {
            Integer integer = (Integer) iterator.next();
        }

    }

}
