package com.example.bloomfiltertraining;

public interface BloomFilterI<T> {
    void addValue(T value);
    boolean mightContain(T value);
}
