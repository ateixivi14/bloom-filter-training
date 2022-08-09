package com.example.bloomfiltertraining;

public class SimpleBloomFilter implements BloomFilterI {

    private int[] array;
    
    private final int size;

    public SimpleBloomFilter(int size) {
        this.size = size;
        array = new int[size];
    }

    @Override
    public void addValue(Object value) {
        int firstPosition = simpleHashCodeFunction(value) % size;
        int secondPosition = hashCodeFunction(value) % size;
        
        array[firstPosition] = 1;
        array[secondPosition] = 1;
        
    }

    @Override
    public boolean mightContain(Object value) {
        int firstPosition = simpleHashCodeFunction(value) % size;
        int secondPosition = hashCodeFunction(value) % size;
        
        return containsPosition(firstPosition) && containsPosition(secondPosition);
    }
    
    private int simpleHashCodeFunction(Object value) {
        return value.hashCode();
    }
    
    private int hashCodeFunction(Object value) {
        int intValue = value.hashCode();
        return ((2 * intValue) + 3) % 5;
    }
    
    private boolean containsPosition(int position) {
        return array[position] == 1; 
    }
    
}
