package pgdp.stack;

import java.util.ArrayList;
import java.util.List;

public class Stack <T> {
    List<T> stack = new ArrayList<>();

    public void push(T t) {
        stack.add(t);
    }

    public T pop() {
        int stack_size = stack.size();
        if(stack_size == 0){
            return null;
        }
        T t = stack.get(stack_size - 1);
        stack.remove(stack_size - 1);
        return t;
    }
}
