package com.akushwah.examples.dp.prototype;

public interface Prototype extends Cloneable {
	
	public AccessControl clone() throws CloneNotSupportedException;

}
