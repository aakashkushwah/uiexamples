package com.akushwah.java8.examples.generics;

public class MyNode extends Node<Integer> {
	public MyNode(Integer data) { super(data); }

    public void setData(Integer data) {
        System.out.println("MyNode.setData");
        super.setData(data);
    }
    
    public static void main(String[] args) {
    	MyNode mn = new MyNode(5);
    	Node n = mn;            // A raw type - compiler throws an unchecked warning
    	n.setData("Hello");     
    	Integer x = mn.data;    
    	System.out.println(x);
	}
}
