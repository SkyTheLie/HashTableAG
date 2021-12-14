package AGHash;

import java.util.ArrayList;

public class AGHashTable<K, V> {
	private ArrayList<AGHashNode<K, V>> liste;
	private ArrayList<Integer> tagList;
	private int capacity = 0;
	private int size = 0;
	private final static int EMPTY = 0;
	private final static  int BESETZT = 1;
	private final static int DELETED = 2;
	
	public AGHashTable(int capacity) {
		this.capacity = capacity;
		liste = new ArrayList<AGHashNode<K, V>>(capacity);
		tagList = new ArrayList<Integer>(capacity);
		
		for(int i = 0; i < capacity; i++) {
			tagList.set(i, EMPTY);
		}
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public int getHashKey(K key) {
		int hash = key.hashCode() % capacity;
		if(hash < 0) {
			hash += capacity;
		}
		return hash;
	}
	
	public int s(int i, K key) {
		return linearSondierung(i);
	}

	public int ss(int i, K key) {
		return quadeSondierung(i);
	}
	
	private int quadeSondierung(int i) {
		if(i % 2 == 0) {
			return ((i + 1) / 2) * ((i + 1) / 2);
		}else {
			return - ((i + 1) / 2) * ((i + 1) / 2);	
		}	
	}

	private int linearSondierung(int i) {
		return i;
	}
	
	public int searchIndex(K key) {
		int k = getHashKey(key);
		int i = k;
		int j = 1;
		while(tagList.get(i) != EMPTY && !key.equals(liste.get(i).getKey()) && j <= capacity) {
			i = (k - s(j++, key)) % capacity;
			if(i < 0) {
				i += capacity;
			}		
		}
		return i;
	}
	
	public int searchIndexAdd(K key) {
		int k = getHashKey(key);
		int i = k;
		int j = 1;
		while(j <= capacity && tagList.get(i) != BESETZT && !key.equals(liste.get(i).getKey())) {
			i = (i - s(j++, key)) % capacity;
			if(i < 0) {
				i += capacity;
			}
		}
		return i;
	}
	
	public void add(K key, V value) {
		if(size == capacity) {
			System.out.println("Liste ist voll!");
			return;
		}
		int index = searchIndexAdd(key);
		if(tagList.get(index) == BESETZT && key.equals(liste.get(index).getKey())) {
			System.out.print("Diese position ist schon besetzt");
		}else {
			tagList.set(index, BESETZT);
			liste.set(index, new AGHashNode<K, V>(key, value));
			size++;
		}
	}
	
	public void remove(K key) {
		int index = searchIndex(key);
		if(tagList.get(index) == BESETZT && key.equals(liste.get(index).getKey())) {
			tagList.set(index, DELETED);
			size--;
		}else {
			System.out.println("Dieser Key ist nicht vorhanden.");
		}
	}
	
	public K findKey(K key) {
		int k = key.hashCode();
		if(key.equals(liste.get(k).getKey())) {
			return liste.get(k).getKey();
		}else {
			System.out.println("Element ist nicht vorhanden.");
			return null;
		}
	}
	
	public V findValue(K key) {
		int k = key.hashCode();
		if(key.equals(liste.get(k).getKey())) {
			return liste.get(k).getValue();
		}else {
			System.out.println("Element ist nicht vorhanden.");
			return null;
		}
	}
	
}
