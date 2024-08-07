package examples.hashtables.easy;

import java.util.LinkedList;
import java.util.ListIterator;

public class MyHashSet {
    private final int SIZE = 10000;
    private LinkedList<Integer>[] buckets;

    public MyHashSet() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getHash(int key) {
        return key % SIZE;
    }

    public void add(int key) {
        int hash = getHash(key);
        LinkedList<Integer> bucket = buckets[hash];
        ListIterator<Integer> iterator = bucket.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next() == key) {
                return;
            }
        }
        bucket.add(key);
    }

    public void remove(int key) {
        int hash = getHash(key);
        LinkedList<Integer> bucket = buckets[hash];
        ListIterator<Integer> iterator = bucket.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next() == key) {
                iterator.remove();
                return;
            }
        }
    }

    public boolean contains(int key) {
        int hash = getHash(key);
        LinkedList<Integer> bucket = buckets[hash];
        for (int k : bucket) {
            if (k == key) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(2);
        System.out.println(myHashSet.contains(1));
        System.out.println(myHashSet.contains(3));
        myHashSet.add(2);
        System.out.println(myHashSet.contains(2));
        myHashSet.remove(2);
        System.out.println(myHashSet.contains(2));
    }
}
