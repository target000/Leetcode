import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// UndirectedNode
class MyNode {
    int label;
    List<MyNode> neighbors;

    MyNode(int x) {
        label = x;
        neighbors = new ArrayList<MyNode>();
    }
}

public class CloneGraph {

    private Map<Integer, MyNode> map = new HashMap<>();

    public MyNode cloneGraph(MyNode node) {
        return clone(node);
    }

    private MyNode clone(MyNode node) {

        if (node == null)
            return null;

        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }

        MyNode clone = new MyNode(node.label);
        map.put(clone.label, clone);

        for (MyNode neighbor : node.neighbors) {
            clone.neighbors.add(clone(neighbor));
        }

        return clone;
    }
}