package com.akushwah.algo1;

public class MyLinkedList {

	private Node head;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public void insert(Node n) {
		if (head == null) {
			head = n;
		} else {
			Node current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(n);
		}
	}

	public void print() {
		if (head != null) {
			Node current = head;
			System.out.print(current.getData() + " ");
			while (current.getNext() != null) {
				current = current.getNext();
				System.out.print(current.getData() + " ");
			}
		}
		System.out.println();
	}

	public void delete(Node startNode, Node toBeDelNode) {
		if(startNode.equals(toBeDelNode)) {
			if(startNode.getNext() == null) {
				System.out.println("List can not be empty not deleting");
			}else {
				head = startNode.getNext();
				System.out.println("Deleted");
			}
			return;
		}else {
			Node current = startNode;
			Node left = current;
			boolean found = false;
			while(current.getNext()!=null) {
				left = current;
				current = current.getNext();
				if(current.equals(toBeDelNode)) {
					found = true;
					break;
				}
			}
			
			if(!found) {
				System.out.println("Not found");
			}else {
				left.setNext(current.getNext());
				System.out.println("Deleted");
			}
		}
	}
}
