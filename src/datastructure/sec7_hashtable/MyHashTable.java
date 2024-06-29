package datastructure.sec7_hashtable;

import java.util.LinkedList;
import java.util.List;

public class MyHashTable {
    private LinkedList<KeyValue>[] data;

    @SuppressWarnings("unchecked")
    public MyHashTable(int size) {
        data = new LinkedList[size];
    }

    public void put(String key, int value) {
        var hash = hash(key);
        if (data[hash] == null) {
            data[hash] = new LinkedList<>();
        }
        for (KeyValue kv : data[hash]) {
            if (key.equals(kv.key)) {
                kv.value = value;
                return;
            }
        }
        var kv = new KeyValue();
        kv.key = key;
        kv.value = value;
        data[hash].add(kv);
    }

    public Integer get(String key) {
        var kvs = data[hash(key)];
        if (kvs == null || kvs.isEmpty()) {
            return null;
        }
        for (int i = 0; i < kvs.size(); i++) {
            var kv = kvs.get(i);
            if (kv.key.equals(key))
                return kv.value;
        }
        return null;
    }

    public List<String> keys() {
        var keys = new LinkedList<String>();
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                for (var kv : data[i]) {
                    keys.add(kv.key);
                }
            }
        }
        return keys;
    }

    private int hash(String key) {
        var hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash + key.charAt(i) * i) % data.length;
        }
        return hash;
    }

    private static class KeyValue {
        private String key;
        private Integer value;
    }

    public static void main(String[] args) {
        MyHashTable hashTable = new MyHashTable(1);
        hashTable.put("grape", 10000);
        System.out.println(hashTable.get("grape"));
        hashTable.put("apples", 9);
        System.out.println(hashTable.get("apples"));
        hashTable.put("grape", 20000);
        System.out.println(hashTable.get("grape"));
        System.out.println(hashTable.keys());
    }

}
