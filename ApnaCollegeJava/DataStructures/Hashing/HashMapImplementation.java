package DataStructures.Hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImplementation {
    public static class HashMap<K, V> { // generics
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // n - no. of nodes = size of linkedlist
        private int N; // N - buckets = size of array
        private LinkedList<Node>[] buckets; // N = buckets.length

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0; i<4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) { // 0 to N-1
            int bucketIndex = key.hashCode();
            return Math.abs(bucketIndex) % N;
        }

        private int searchInLL(K key, int bucketIndex) {
            LinkedList<Node> ll = buckets[bucketIndex];
            for(int i=0; i<ll.size(); i++) {
                if(ll.get(i).key.equals(key)) {
                    return i; // data index
                }
            }

            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node>[] oldBucket = buckets;
            N = N * 2;
            n = 0;
            buckets = new LinkedList[N];

            for(int i=0; i<N; i++) {
                buckets[i] = new LinkedList<>();
            }

            for(int i=0; i<oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for(int j=0; j<ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        public boolean isEmpty() {
            return n == 0;
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for(int i=0; i<buckets.length; i++) { // bucket index
                LinkedList<Node> ll = buckets[i];
                for(int j=0; j<ll.size(); j++) { // data index
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }

            return keys;
        }

        public void put(K key, V value) {
            int bucketIndex = hashFunction(key); // index of data in array
            int dataIndex = searchInLL(key, bucketIndex); // data index - index of data in linkedlist

            if(dataIndex == -1) {// key doesn't exist
                buckets[bucketIndex].add(new Node(key, value));
                n++;
            } else { // key exist
                Node node = buckets[bucketIndex].get(dataIndex);
                node.value = value;
            }

            double lambda = (double)n / N;
            if(lambda > 2.0) {
                //rehashing
                rehash();
            }
        }

        public V get(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLL(key, bucketIndex);

            if(dataIndex == -1) { // key doesn't exist
                return null;
            } else { // key exists
                Node node = buckets[bucketIndex].get(dataIndex);
                return node.value;
            }
        }

        public boolean containsKey(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLL(key, bucketIndex);

            if(dataIndex == -1) { // key doesn't exists
                return false;
            } else { // key exists
                return true;
            }
        }

        public V remove(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLL(key, bucketIndex);

            if(dataIndex == -1) { // key doesn't exists
                return null;
            } else { // key exists
                Node node = buckets[bucketIndex].remove(dataIndex);
                n--;
                return node.value;
            }
        }

        public int size() {
            return n;
        }
    }
    
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 120);
        map.put("China", 150);
        map.put("US", 30);

        ArrayList<String> keys = map.keySet();

        for(int i=0; i<keys.size(); i++) {
            System.out.println(keys.get(i) + " : " + map.get(keys.get(i)));
        }

        map.remove("India");
        System.out.println(map.get("India"));
    }
}