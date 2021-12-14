package AGHash;

public class AGHashNode<K, V> {
	private K key;
	private V value;
	
	private AGHashNode<K, V> next;
	
	public AGHashNode(K key, V value){
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return this.key;
	}
	
	public V getValue() {
		return this.value;
	}
	
	public AGHashNode<K, V> getNext(){
		return this.next;
	}
	
	public void setKey(K key) {
		this.key = key;
	}
	
	public void setValue(V value) {
		this.value = value;
	}
	
	public void setNext(AGHashNode<K, V> next) {
		this.next = next;
	}
}
