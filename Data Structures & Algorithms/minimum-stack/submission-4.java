class MinStack {
    /*
    1. Initialise array stack for main storage stack and minimum value storage Stack, stack and minStack
    2. Initialise them both in the constructor
    3. for every push, check and compare  the push value to top value in minStack. If the last entry is smaller than push that entry again, if not then push the current value or when stack is empty.add()
    4. Since we are pushing value with every push in minStack, similarly with every pop a value must be popped out as well
    */

    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack() {
        //stack and minStack should be of type Deque and array
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()){
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
