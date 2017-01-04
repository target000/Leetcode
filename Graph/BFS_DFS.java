import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

// need to run with both adjacency list and adjacency matrix

public class BFS_DFS {
    private static int[][] adjacencyMatrix;
    private static boolean[] visited;

    public static void main(String[] args) {
        int numNodes = 6;
        adjacencyMatrix = new int[numNodes][numNodes];
        visited = new boolean[numNodes];

        // define edges
        adjacencyMatrix[0][1] = 1;
        adjacencyMatrix[0][2] = 1;
        adjacencyMatrix[0][3] = 1;
        adjacencyMatrix[1][0] = 1;
        adjacencyMatrix[1][4] = 1;
        adjacencyMatrix[1][5] = 1;
        adjacencyMatrix[2][0] = 1;
        adjacencyMatrix[2][5] = 1;
        adjacencyMatrix[3][0] = 1;
        adjacencyMatrix[4][1] = 1;
        adjacencyMatrix[5][1] = 1;
        adjacencyMatrix[5][2] = 1;

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            System.out.println(Arrays.toString(adjacencyMatrix[i]));
        }

        System.out.println("DFS");
        DFS(0);

        System.out.println("BFS");
        BFS(0);
    }

    // Step 1: Push the root node in the Stack.
    // Step 2: Loop until stack is empty.
    // Step 3: Peek the node of the stack.
    // Step 4: If the node has unvisited child nodes, get the unvisited child
    // node, mark it as traversed and push it on stack.
    // Step 5: If the node does not have any unvisited child nodes, pop the node
    // from the stack.
    public static void DFS(int rootNode) {
        Deque<Integer> stack = new ArrayDeque<Integer>();

        stack.push(rootNode);
        visited[rootNode] = true;
        printNode(rootNode);

        while (!stack.isEmpty()) {

            int n = stack.peek();
            int child = getUnvisitedChildNode(n);

            if (child != -1) {
                visited[child] = true;
                printNode(child);
                stack.push(child);
            } else {
                stack.pop();
            }
        }

        // Clear visited property of nodes
        clearAllVisited();
    }

    // Step 1: Push the root node in the Queue.
    // Step 2: Loop until the queue is empty.
    // Step 3: Remove the node from the Queue.
    // Step 4: If the removed node has unvisited child nodes, mark them as
    // visited and insert the unvisited children in the queue.
    public static void BFS(int root) {
        // BFS uses Queue data structure
        Queue<Integer> queue = new ArrayDeque<Integer>();

        queue.add(root);
        printNode(root);
        visited[root] = true;

        while (!queue.isEmpty()) {

            int node = queue.remove();
            int child = -1;

            while ((child = getUnvisitedChildNode(node)) != -1) {
                visited[child] = true;
                printNode(child);
                queue.add(child);
            }
        }

        // Clear visited property of nodes
        clearAllVisited();
    }

    private static void clearAllVisited() {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
    }

    /**
     * walks through adjacency matrix to find edges from this node 'n' to neighbouring nodes which have not yet been visited
     * 
     * returns -1 if none found, ie. all visited/ no outgoing edges
     * 
     * @param n
     * @return
     */
    private static int getUnvisitedChildNode(int n) {
        // visit all columns for row n
        for (int i = 0; i < adjacencyMatrix[n].length; i++) {
            if (adjacencyMatrix[n][i] == 1 && !visited[i]) {
                return i;
            }
        }
        
        return -1;
    }

    private static void printNode(int node) {
        System.out.println("visited node: " + (char) (node + 'A'));
    }
}