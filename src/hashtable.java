import java.util.*;

class Entry<K, V> {
    K key;
    V value;
    int hashCode;
    Entry<K,V> next;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        this.hashCode = key.hashCode();
    }
}

class CustomHashTable<K,V> {
    private LinkedList<Entry<K,V>> [] table;
    private int size, capacity, threshold = 0; //size is the size of each bucket
    private static final int INITIAL_CAPACITY = 3;
    private static final double INITIAL_LOAD_FACTOR = 0.75;
    private double max_factor;

    public CustomHashTable (){
        this(INITIAL_CAPACITY, INITIAL_LOAD_FACTOR);
    }

    public CustomHashTable(int capacity, double maxLoadFactor){
        if (capacity < 0)
            throw new IllegalArgumentException("Illegal capacity");
        if (maxLoadFactor <= 0 || Double.isNaN(maxLoadFactor) || Double.isInfinite((maxLoadFactor))){
            throw new IllegalArgumentException("invalid maxLoadFactor");
        }

        this.max_factor = maxLoadFactor;
        this.capacity = capacity;
        this.threshold = (int) maxLoadFactor * capacity;
        this.table = new LinkedList[capacity];
    }

    private int compressor(int hashcode){
        return hashcode % capacity;
    }

    //PUT method
    public V put(K key, V value){
        return insert(key, value);
    }

    private V insert(K key, V value){
        if (key == null)
            throw new IllegalArgumentException("Key is invalid");
        Entry<K,V> newEntry = new Entry<>(key, value);
        int bucketIndex = compressor(newEntry.hashCode);
        return bucketInsertEntry(bucketIndex, newEntry);
    }

    private V bucketInsertEntry(int bucketIndex, Entry<K,V> newEntry) {
        LinkedList<Entry<K, V>> bucket = table[bucketIndex];
        if(bucket == null){
            table[bucketIndex] = bucket = new LinkedList<>();
        }
        Entry<K,V> temp = bucketSeekEntry(bucketIndex, newEntry.key);
        if (temp == null) {
            bucket.add(newEntry);
            if(++size > threshold) {
                resizeTable();
            }
            System.out.println(("Inserted"));
            return null;

        }
        else{
            return temp.value;
        }
    }

    private void resizeTable() {
        capacity *= 2;
        threshold = (int )(capacity * max_factor);

        LinkedList<Entry<K,V>> newTable [] = new LinkedList[capacity];

        for (int i = 0; i < table.length; ++i){
            if(table[i] != null){
                for (Entry<K,V> entry : table[i]){
                    int bucketIndex = compressor(entry.hashCode);
                    LinkedList<Entry <K,V>> bucket = newTable[bucketIndex];
                    if(bucket == null) newTable[bucketIndex] = bucket = new LinkedList<>();
                    bucket.add(entry);
                }
            }
        }
        table = newTable;
    }

    private Entry<K,V> bucketSeekEntry(int bucketIndex, K key) {
        if (key == null) return null;

        LinkedList<Entry<K,V>> bucket = table[bucketIndex];
        if(bucket == null)
            return null;
        for (Entry<K,V> entry : bucket){
            if (entry.key.equals(key)){
                return entry;
            }
        }
        return null;
    }

    //Get

    public V get(K key){
        if(key == null)
            return null;
        int bucketIndex = compressor(key.hashCode());
        LinkedList<Entry<K, V>> bucket = table[bucketIndex];

        Entry<K,V> entry = bucketSeekEntry(bucketIndex, key);
        if(entry != null)
            return entry.value;
        return null;
    }

    //Remove

    public V remove(K key){
        if (key == null)
            return null;
        int bucketIndex = compressor(key.hashCode());

        return bucketRemoveEntry(bucketIndex, key);

    }

    private V bucketRemoveEntry(int bucketIndex, K key) {
        Entry<K,V> entry = bucketSeekEntry(bucketIndex, key);

        if(entry == null)
            return null;

        LinkedList<Entry<K,V>> list = table[bucketIndex];
        list.remove(entry);
        --size;
        return entry.value;

    }

    public int size() {
        return size;
    }




}

public class hashtable {
    public static void main(String[] args) {

        CustomHashTable<Integer, String> table = new CustomHashTable<>();

        table.put(1, "a");
        table.put(2, "b");
        table.put(3, "c");
        table.put(4, "d");

        System.out.println(table.get(4));
        System.out.println(table.remove(1));
        System.out.println(table.get(1));


    }




}
