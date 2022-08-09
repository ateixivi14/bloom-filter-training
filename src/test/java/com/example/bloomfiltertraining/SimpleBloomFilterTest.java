package com.example.bloomfiltertraining;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBloomFilterTest {
    
    private static final String INSERTED_STRING_1 = "hola";
    private static final String INSERTED_STRING_2 = "holo";
    private static final String INSERTED_STRING_3 = "hehe";

    private static final String NOT_INSERTED_STRING_2 = "hole";
    private static final String NOT_INSERTED_STRING_3 = "hol";

    SimpleBloomFilter simpleBloomFilter =  new SimpleBloomFilter(100);
    
    @Test
    void mightContainsInsertedStrings() {
        
        simpleBloomFilter.addValue(INSERTED_STRING_1);
        simpleBloomFilter.addValue(INSERTED_STRING_2);
        simpleBloomFilter.addValue(INSERTED_STRING_3);

        assertEquals(true, simpleBloomFilter.mightContain(INSERTED_STRING_1));
        assertEquals(true, simpleBloomFilter.mightContain(INSERTED_STRING_2));
        assertEquals(true, simpleBloomFilter.mightContain(INSERTED_STRING_3));
        
    }
    
    @Test
    void mightNotContainNotInsertedStrings() {

        simpleBloomFilter.addValue(INSERTED_STRING_1);
        simpleBloomFilter.addValue(INSERTED_STRING_2);
        simpleBloomFilter.addValue(INSERTED_STRING_3);

        assertEquals(false, simpleBloomFilter.mightContain(NOT_INSERTED_STRING_2));
        assertEquals(false, simpleBloomFilter.mightContain(NOT_INSERTED_STRING_3));

    }
}
