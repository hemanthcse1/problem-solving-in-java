package examples.hashtables.easy;

import java.util.LinkedList;
import java.util.ListIterator;

public class MyHashMap {
    private final int SIZE = 10000;
    private LinkedList<Entry>[] buckets;

    private class Entry {
        int key;
        int value;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getHash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int hash = getHash(key);
        LinkedList<Entry> bucket = buckets[hash];
        for (Entry entry : bucket) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }
        bucket.add(new Entry(key, value));
    }

    public int get(int key) {
        int hash = getHash(key);
        LinkedList<Entry> bucket = buckets[hash];
        for (Entry entry : bucket) {
            if (entry.key == key) {
                return entry.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hash = getHash(key);
        LinkedList<Entry> bucket = buckets[hash];
        ListIterator<Entry> iterator = bucket.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().key == key) {
                iterator.remove();
                return;
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(3));
        myHashMap.put(2, 1);
        System.out.println(myHashMap.get(2));
        myHashMap.remove(2);
        System.out.println(myHashMap.get(2));
    }
}
