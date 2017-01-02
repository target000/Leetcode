import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class UndirectedGraphNode {
    int label;
    ArrayList<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}

class CloneGraph {

    // 1
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;

        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);

        queue.add(node);
        map.put(node, newHead);

        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.pop();
            ArrayList<UndirectedGraphNode> currNeighbors = curr.neighbors;

            for (UndirectedGraphNode aNeighbor : currNeighbors) {
                if (!map.containsKey(aNeighbor)) {
                    UndirectedGraphNode copy = new UndirectedGraphNode(aNeighbor.label);
                    map.put(aNeighbor, copy);
                    map.get(curr).neighbors.add(copy);
                    queue.add(aNeighbor);
                } else {
                    map.get(curr).neighbors.add(map.get(aNeighbor));
                }
            }

        }
        return newHead;
    }

    // 2
    public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        if (node == null)
            return null;

        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();

        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode top = queue.poll();
            map.put(top, new UndirectedGraphNode(top.label));

            for (UndirectedGraphNode n : top.neighbors) {
                if (!map.containsKey(n))
                    queue.offer(n);
            }
        }

        queue.offer(node);
        Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        set.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode top = queue.poll();
            for (UndirectedGraphNode n : top.neighbors) {
                if (!set.contains(n)) {
                    queue.offer(n);
                    set.add(n);
                }
                map.get(top).neighbors.add(map.get(n));
            }
        }

        return map.get(node);
    }
}