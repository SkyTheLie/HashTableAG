package AGHashList;

public class AGHashNode<K, V> {
	K key;
	V value;
	
	AGHashNode<K, V> next;

	public AGHashNode(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public AGHashNode<K, V> getNext() {
		return next;
	}

	public void setNext(AGHashNode<K, V> next) {
		this.next = next;
	}
}
