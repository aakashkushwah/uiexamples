package com.akushwah.examples.inmemorycache;

public interface Cache<K, V> {
	void put(K key, V item);
	 
    V get(K key);
 
    void cleanUp();
}
