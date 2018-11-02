package com.akushwah.algo1;

public class LinkedListNodeDelete {
	public static void main(String[] args) {
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.insert(new Node("a"));
		linkedList.insert(new Node("b"));
		linkedList.insert(new Node("c"));
		linkedList.insert(new Node("d"));
		linkedList.insert(new Node("e"));
		linkedList.print();
		
		linkedList.delete(linkedList.getHead(), linkedList.getHead());
		linkedList.print();
		
		linkedList.delete(linkedList.getHead(), linkedList.getHead().getNext().getNext());
		linkedList.print();
		linkedList.delete(linkedList.getHead(), linkedList.getHead().getNext());
		linkedList.print();
		linkedList.delete(linkedList.getHead(), linkedList.getHead().getNext());
		linkedList.print();
		linkedList.delete(linkedList.getHead(), linkedList.getHead());
		linkedList.print();
	}
}
