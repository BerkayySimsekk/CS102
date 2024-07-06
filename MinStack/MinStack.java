package MinStack;

import java.util.*;

public class MinStack {
    private ArrayList<Integer> stack;
    
    public MinStack() {
        stack = new ArrayList<Integer>();
    }

    public void push(int val) {
       stack.add(0, val);
    }
    
    public void pop() {
        if(stack.size() > 0) {
            stack.remove(0);    
        }
    }
    
    public int top() {
        if(stack.size() > 0) {
            return stack.get(0);
        }

        return -1;
    }
    
    public int getMin() {
        int minValue;

        minValue = Integer.MAX_VALUE;

        if(stack.size() > 0) {
            for(int n = 0; n < stack.size(); n++) {
                if(stack.get(n) < minValue) {
                    minValue = stack.get(n);
                }
            }
        }
        
        return minValue;
    }
}
