package com.hillel.homework.hw8.linkedList.stackQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println("My queue array");
        MyQueueArray myQueueArray = new MyQueueArray();
        System.out.println(myQueueArray.add("test1"));
        myQueueArray.add("test2");
        myQueueArray.add("test3");
        myQueueArray.add("test4");
        System.out.println(myQueueArray);
        System.out.println(myQueueArray.poll());
        System.out.println(myQueueArray);
        System.out.println(myQueueArray.poll());
        System.out.println(myQueueArray);
        System.out.println(myQueueArray.peek());
        System.out.println(myQueueArray);

        System.out.println("My queue list");
        MyQueue myQueue = new MyQueue();
        System.out.println(myQueue.add("test1"));
        myQueue.add("test2");
        myQueue.add("test3");
        myQueue.add("test4");
        System.out.println(myQueue);
        System.out.println(myQueue.poll());
        System.out.println(myQueue);
        System.out.println(myQueue.poll());
        System.out.println(myQueue);
        System.out.println(myQueue.peek());
        System.out.println(myQueue);

        System.out.println("My stack array");
        MyStackArray myStackArray = new MyStackArray();
        myStackArray.peek();
        myStackArray.pop();
        myStackArray.push(4);
        myStackArray.push(45);
        myStackArray.push(455);
        System.out.println(myStackArray);
        System.out.println(myStackArray.pop());
        System.out.println(myStackArray);
        System.out.println(myStackArray.pop());

        System.out.println("My stack linked list");
        MyStack myStack = new MyStack();
        myStack.pop();
        myStack.peek();
        myStack.push(4);
        myStack.push(45);
        myStack.push(455);
        System.out.println(myStack);
        System.out.println(myStack.pop());
        System.out.println(myStack);
        System.out.println(myStack.peek());

    }
}
