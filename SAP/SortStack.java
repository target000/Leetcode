import java.util.Stack;

public class SortStack {
    public static Stack<Integer> sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<Integer>();
        // Iteratively take elements from unsorted stack until none remain
        while (!s.isEmpty()) {
            int tmp = s.pop();
            // First remove elements > tmp from sorted stack
            while (!r.isEmpty() && r.peek() > tmp) {
                s.push(r.pop());
            }
            // Second, place tmp into correct location in sorted stack
            r.push(tmp);
        }
        return r;
    }

}
