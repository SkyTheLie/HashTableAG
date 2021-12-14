package hash;

import java.util.ArrayList;

public class OpenHashTable<K, V> {
	protected ArrayList<Integer> tagArray;
	private ArrayList<HashNode<K, V>> bucketArray;
	protected int size;
	protected int capacity;
	static final int EMPTY = 0;
	static final int OCCUPIED = 1;
	static final int DELETED = 2;

	public int size() { 
		return size;
	}

	public boolean isEmpty() { 
		return size() == 0; 
	}

	public OpenHashTable (int capacity){
		this.capacity = capacity;
		tagArray = new ArrayList<Integer>(capacity);
		bucketArray = new ArrayList<HashNode<K, V>>(capacity);
		
		for(int i = 0; i < capacity; i++) {
			tagArray.add(i, EMPTY);
			bucketArray.add(i, new HashNode<K, V>(null, null));
		}
		size = 0;
	}

	public int getHashIndex(K key) {
		int hashValue = key.hashCode() % capacity;
		//System.out.println(": " + hashValue);
		if(hashValue < 0) {
			//hashValue += capacity;
			hashValue = hashValue + capacity;
		}
		return hashValue;
	}
	
	public int s(int j, Object  key) {
		return lineares_Sondieren(j);
		//return quadratisches_Sondieren(j);
	}
	
	public int ss(int j, Object  key) {
		return quadratisches_Sondieren(j);
	}
	
	public int lineares_Sondieren( int j) {
	//public int quadratisches_Sondieren( int j) {
		return j;
	}

	public int quadratisches_Sondieren(int j) {
		if(j % 2 == 0) {
			return ((j + 1) / 2) * ((j + 1) / 2);
		}else {
			return - ((j + 1) / 2) * ((j + 1) / 2);
		}
	}
	
	public int searchIndex(K key) {
		int k = getHashIndex(key);
		int i = k;
		int j = 1;
		while(tagArray.get(i) != EMPTY && !key.equals(bucketArray.get(i).key) && j <= capacity) {
			System.out.println("i: " + i  + "  j: " + j +  "  k: " + k + "  s: " + s(j + 1, key) + "  %: " + (k - s(j + 1, key)) % capacity + "  Key: " + key.toString());
			i = (k - s(j++, key)) % capacity;
			if(i < 0)
				i += capacity;
		}
		return i;
	}
	
	public int searcheIndexForAdding(K key) {
		int k = getHashIndex(key);
		int i = k;
		int j = 1;
		while(tagArray.get(i) == OCCUPIED && !key.equals(bucketArray.get(i).key) && j <= capacity) {
			System.out.println("i: " + i  + "  j: " + j +  "  k: " + k + "  s: " + s(j + 1, key) + "  %: " + (k - s(j + 1, key)) % capacity + "  Key: " + key.toString());
			i = (k - s(j++, key)) % capacity;
			if(i < 0) {
				i += capacity;
			}
		}
		return i;
	}
	
	public void add(K key, V value) {
		if(size == capacity) {
			System.out.println("ist FULL digga");
			return;
		}
		int i = searcheIndexForAdding(key);
		if(tagArray.get(i) == OCCUPIED && key.equals(bucketArray.get(i).key)) {
			System.out.println("Schlüsel " + key.toString() + " bereits vorhanden.");
		}else {
			//System.out.println(" !" + i);
			tagArray.set(i, OCCUPIED);
			bucketArray.set(i, new HashNode<K, V>(key, value));
			size++;
		}
	}
	
	public V remove(K key) {
		int i = searchIndex(key);
		if(tagArray.get(i) == OCCUPIED && key.equals(bucketArray.get(i).key)) {
			tagArray.set(i, DELETED);
			size--;
			return bucketArray.get(i).value;
		}else {
			return null;
		}
	}

	public V find(K key) {
		int i = searchIndex(key);
		if(tagArray.get(i) == OCCUPIED && key.equals(bucketArray.get(i).key)) {
			return bucketArray.get(i).value;
		}else {
			return null;
		}
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public K getTableEntry(int i) {
		return this.bucketArray.get(i).key;
	}
	
	
	public void printTable() {
		System.out.println("---------------------------------------------------");
		for(int i = 0; i < this.capacity ; i++) {
			switch(tagArray.get(i)) {
				case EMPTY:{
					System.out.println("[   ]");
				}break;
				case DELETED:{
					//System.out.println("{ " + bucketArray.get(i).value.toString() + " }");
					System.out.println("{ " + getTableEntry(i) + " }");
				}break;
				case OCCUPIED:{
					System.out.println("  " + getTableEntry(i) + "  ");
				}break;
			}
		}
	}
	
}
