package PartI;

import java.util.Queue;
import java.util.Stack;
import java.util.Arrays;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RemoveMethods {

	public static void remAllStack(Stack<Object> stack, Object item) {

		Stack<Object> stack2 = new Stack<Object>();
		while (!stack.isEmpty()) {
			if (!stack.peek().equals(item)) {
				stack2.push(stack.pop());
			} else {
				stack.pop();
			}
		}
		while (!stack2.isEmpty()) {
			stack.push(stack2.pop());
		}
	}

	public static void remAllQueue(Queue<Object> queue, Object item) {
		Queue<Object> q2 = new ConcurrentLinkedQueue<Object>();
		while (!queue.isEmpty()) {
			if (!queue.peek().equals(item)) {
				q2.offer(queue.poll());
			} else {
				queue.poll();
			}
		}
		while (!q2.isEmpty()) {
			queue.offer(q2.poll());
		}
	}

	public static void main(String[] args) {
		Stack<Object> stk = new Stack<Object>();
		stk.push(new Integer(24));
		stk.push(new Integer(2));
		stk.push(new Integer(9));
		stk.push(new Integer(2));
		stk.push(new Integer(7));
		stk.push(new Integer(10));
		stk.push(new Integer(16));
		System.out.println("begin: stk is " + stk);
		RemoveMethods.remAllStack(stk, new Integer(2));
		System.out.println("end: stk is " + stk);
		RemoveMethods.remAllStack(stk, new Integer(24));
		System.out.println("end: stk is " + stk);

		Queue<Object> q = new ConcurrentLinkedQueue<Object>(); // find a concrete class for this
		q.offer(new Integer(24));
		q.offer(new Integer(2));
		q.offer(new Integer(9));
		q.offer(new Integer(2));
		q.offer(new Integer(7));
		q.offer(new Integer(10));
		q.offer(new Integer(16));
		System.out.println("begin: q is " + q);
		RemoveMethods.remAllQueue(q, new Integer(2));
		System.out.println("end: q is " + q);
		RemoveMethods.remAllQueue(q, new Integer(24));
		System.out.println("end: q is " + q);

	}
}
