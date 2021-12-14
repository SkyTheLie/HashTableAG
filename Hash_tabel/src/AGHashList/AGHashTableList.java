package AGHashList;

import java.util.ArrayList;

public class AGHashTableList<K, V> {
	private ArrayList<AGHashNode<K, V>> liste;
	private int capacity;
	private int size = 0;
	
	public AGHashTableList(int capacity){
		this.capacity = capacity;
		liste = new ArrayList<AGHashNode<K, V>>(capacity);
		
		for(int i = 0; i < capacity ; i++) {
			liste.add(null);
		}
		
	}
	
	public int getSize() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return (getSize() == 0);
	}
	
	public int getHashKey(K key) {
		int k = key.hashCode() % capacity;
		if(k < 0) {
			k += capacity;
		}
		return k;
	}
	
	public void add(K key, V value) {
		int k = getHashKey(key);
		AGHashNode<K, V> head = liste.get(k);
		AGHashNode<K, V> cur = head;
		while(cur != null) {
			if(cur.getKey().equals(key)) {
				cur.setValue(value);
				return;
			}
			cur = cur.getNext();
		}
		cur = new AGHashNode<K, V>(key, value);
		cur.setNext(head);
		liste.set(k, cur);
		size++;	
	}
	
	public void remove(K key) {
		int k = getHashKey(key);
		AGHashNode<K, V> head = liste.get(k);
		AGHashNode<K, V> prev = null;
		
		while(head != null) {
			//if(head.key.equals(key)) {
			if(key.equals(head.getKey())) {
				size--;
				if(prev != null) {
					prev.setNext(head.getNext());
					//prev.next = head.next;
				}else {
					liste.set(k, head.getNext());
				}
				return;
			}
			prev = head;
			head = head.next;
		}
		return;
	}
	
	public V findvalue(K key) {
		int k = getHashKey(key);
		AGHashNode<K, V> head = liste.get(k);
		while(head != null) {
			if(head.getKey().equals(key)) {
				return head.getValue();
			}
			head = head.getNext();
		}
		System.out.println("Cant finde Element.");
		return null;
	}
}
