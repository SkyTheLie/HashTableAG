package main;

import AGHashList.AGHashTableList;
import hash.OpenHashTable;

public class main {

	public static void main(String[] args) {
	/*
	 	OpenHashTable test = new OpenHashTable<Integer, Integer>(12);
		for(int i = 0 ; i < test.getCapacity(); i++) {
			test.add(i, null);
		}
		
		test.printTable();
		
		test.add(22, null);
		test.add(22, null);
		test.add(23, null);
		
		test.printTable();
		
		test.remove(23);
		test.remove(22);
		
		test.printTable();
		
*/
		OpenHashTable<Integer, Integer> oht = new OpenHashTable<Integer, Integer>(5);
		oht.add(0, 0);
		oht.add(1, 1);
		oht.add(2, 2);
		oht.add(3, 3);
		oht.add(3, 4);
		oht.add(4, 5);
		oht.add(5, 6);
		oht.printTable();
		
		oht.add(8, 7);
		oht.add(1, 8);
		oht.add(13, 9);
		oht.printTable();
		oht.remove(1);
		oht.printTable();
		oht.add(18, 10);
		oht.printTable();
		oht.add(18, 11);
		oht.printTable();
		
		AGHashTableList<Integer, Integer> test = new AGHashTableList<Integer, Integer>(5);
		test.add(1, 1);
		System.out.println(test.getSize() + " ");
		test.add(6, 1);
		System.out.println(test.getSize() + " ");
		test.remove(6);
		System.out.println(test.getSize() + " ");
		test.remove(1);
		System.out.println(test.getSize() + " ");
	}

}
