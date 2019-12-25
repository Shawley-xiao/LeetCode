import java.util.ArrayList;

/**
 * MinStack
 */
public class MinStack {

    ArrayList<Integer> list;
    ArrayList<Integer> minList;

    /** initialize your data structure here. */
    public MinStack() {
        this.list = new ArrayList<Integer>();
        this.minList = new ArrayList<Integer>();
    }
    
    public void push(int x) {
        Integer valueX = Integer.valueOf(x);
        this.list.add(valueX);
        int findIndex = -1;
        for (int i = 0; i < this.minList.size(); i++) {
            if (x < this.minList.get(i).intValue()) {
                findIndex = i;
                break;
            }
        }

        if (findIndex >= 0) {
            this.minList.add(findIndex, valueX);
        } else {
            this.minList.add(valueX);
        }
    }
    
    public void pop() {
        if (this.list.isEmpty()) {
            return;
        }

        Integer popValue = this.list.remove(this.list.size()-1);
        // System.out.println(popValue);
        this.minList.remove(popValue);
    }
    
    public int top() {
        return this.list.get(this.list.size()-1).intValue();
    }
    
    public int getMin() {
        return this.minList.get(0).intValue();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();   
        minStack.pop();
        minStack.top();      
        minStack.getMin();   
    }
}