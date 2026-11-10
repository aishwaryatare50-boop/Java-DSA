package Striver_A_to_Z_DSA.Basics.BasicHashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImplementation {

    static class HashMap<K, V> { // Generics

        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // number of nodes
        private int N; // number of buckets
        private double lambda = 2.0; // threashold value
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[N];
            for(int i=0; i<N; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        public int hashValue(K key) {
            int hashVal = key.hashCode();
            hashVal = Math.abs(hashVal) % N;
            return hashVal;
        }

        public int searchInLL(K key, int bucketIndex) {
            LinkedList<Node> list = buckets[bucketIndex];
            int i = 0;
            for(Node node : list) {
                if(node.key.equals(key)) {
                    return i;
                }
                i++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        public void reHash() {
            N = N * 2;
            n = 0;
            
            LinkedList<Node> oldBucket[] = buckets;
            
            buckets = new LinkedList[N];
            for(int i=0; i<N; i++) {
                buckets[i] = new LinkedList<>();
            }

            for(int i=0; i<oldBucket.length; i++) {
                LinkedList<Node> list = oldBucket[i];
                for(int j=0; j<list.size(); j++) {
                    Node node = list.get(j);
                    put(node.key, node.value);
                }
            }
        }

        public boolean isEmpty() {
            return n == 0;
        }

        public int size() {
            return n;
        }

        public void put(K key, V value) {
            int bucketIndex = hashValue(key);
            int dataIndex = searchInLL(key, bucketIndex);

            if(dataIndex == -1) {
                Node newNode = new Node(key, value);
                buckets[bucketIndex].add(newNode);
                n++;
            } else {
                buckets[bucketIndex].get(dataIndex).value = value;
            }

            if((double)n / N > lambda) {
                reHash();
            }
        }

        public V get(K key) {
            int bucketIndex = hashValue(key);
            int dataIndex = searchInLL(key, bucketIndex);

            if(dataIndex == -1) {
                return null;
            } else {
                return buckets[bucketIndex].get(dataIndex).value;
            }
        }

        public boolean containsKey(K key) {
            int bucketIndex = hashValue(key);
            int dataIndex = searchInLL(key, bucketIndex);

            if(dataIndex == -1) {
                return false;
            } else {
                return true;
            }
        }

        public V remove(K key) {
            int bucketIndex = hashValue(key);
            int dataIndex = searchInLL(key, bucketIndex);

            if(dataIndex == -1) {
                return null;
            } else {
                V value = buckets[bucketIndex].get(dataIndex).value;
                buckets[bucketIndex].remove(dataIndex);
                n--;
                return value;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for(int i=0; i<buckets.length; i++) {
                LinkedList<Node> list = buckets[i];
                for(int j=0; j<list.size(); j++) {
                    Node node = list.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }
        
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("India", 200);
        map.put("China", 180);
        System.out.println(map.keySet());

    }      
}