package com.example.bloomfiltertraining;

public class ComplexBloomFilter implements BloomFilterI {
    
    private int[] array;

    private final int size;

    public ComplexBloomFilter(int size) {
        this.size = size;
        if (Integer.bitCount(size) != 1){
            throw new IllegalArgumentException("Consider size being " +
                    "1,2,4,8,16,32,64,128,256,512,1024,2048,4096... Where Integer.bitCount(size) == 1 ");
        }
        array =  new int[size >>> 6];
    }

    private int mapHash(int hash) {
        return hash & (size - 1);
    }

    @Override
    public void addValue(Object value) {
        int hash = mapHash(hashCodeFunction(value));
        array[hash >>> 6] |= 1L << hash;
    }

    @Override
    public boolean mightContain(Object value) {
        int hash = mapHash(hashCodeFunction(value));
        if ((array[hash >>> 6] & (1L << hash)) == 0) {
            return false;
        }
        return true;
    }

    private int hashCodeFunction(Object value) {
        return value.hashCode();
    }
}
