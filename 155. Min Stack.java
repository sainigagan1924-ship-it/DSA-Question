/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int value) pushes the element value onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.
*/

// CODE

class MinStack {
public:
    stack<int> s1,s2;
    MinStack() {
        
    }
    
    void push(int value) {
        s1.push(value);
        if(s2.size() != 0 && s2.top() < value){
            s2.push(s2.top());
        }
        else{
            s2.push(value);
        }
    }
    
    void pop() {
        if(s1.size() == 0){
            return ;
        }
        s1.pop();
        s2.pop();
    }
    
    int top() {
        if(s1.size() == 0){
            return INT_MIN;
        }
        return s1.top();
    }
    
    int getMin() {
        if(s1.size() == 0){
            return INT_MIN;
        }
        return s2.top();
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(value);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
