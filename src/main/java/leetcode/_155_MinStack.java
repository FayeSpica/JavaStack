package leetcode;

import java.util.Stack;

public class _155_MinStack {
    Stack<Integer> stack=new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    /** initialize your data structure here. */
    public _155_MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if(minStack.empty()||x<=minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop() {
        System.out.println(stack.peek()+","+minStack.peek());
        if(stack.peek().equals(minStack.peek())){
            minStack.pop();
            System.out.println("poped");
        }
        stack.pop();
    }

    public int top() {
        if(stack.empty()){
            throw new RuntimeException();
        }
        return stack.peek();
    }

    public int getMin() {
        if(minStack.empty()){
            throw new RuntimeException();
        }
        return minStack.peek();
    }

    public static void main(String[] args){
        _155_MinStack minStack = new _155_MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        System.out.println(minStack.stack);
        System.out.println(minStack.minStack);
        minStack.pop();
        System.out.println(minStack.getMin());
        System.out.println(minStack.stack);
        System.out.println(minStack.minStack);
        minStack.pop();
        System.out.println(minStack.getMin());
        System.out.println(minStack.stack);
        System.out.println(minStack.minStack);
        minStack.pop();
        System.out.println(minStack.getMin());

        System.out.println(minStack.isValid("([)"));
    }

    Stack<Character> cStack = new Stack<>();

    public boolean isValid(String s) {
        for(int i=0;i<s.length();i++){
            if(cStack.empty()){
                cStack.push(s.charAt(i));
            }else{
                System.out.println(cStack.peek()+","+s.charAt(i));
                if(match(cStack.peek(),s.charAt(i))){
                    cStack.pop();
                }else {
                    cStack.push(s.charAt(i));
                }
            }
        }
        return cStack.empty();
    }

    public boolean match(char a, char b){
        return (a=='('&&b==')')||(a=='['&&b==']')||(a=='{'&&b=='}');
    }

}
