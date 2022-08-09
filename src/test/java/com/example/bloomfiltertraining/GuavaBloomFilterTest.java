package com.example.bloomfiltertraining;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuavaBloomFilterTest {

    private static final String INSERTED_STRING_1 = "hola";
    private static final String INSERTED_STRING_2 = "holo";
    private static final String INSERTED_STRING_3 = "hehe";

    private static final String NOT_INSERTED_STRING_2 = "hole";
    private static final String NOT_INSERTED_STRING_3 = "hol";

    private static final int INSERTED_INTEGER_1 = 1;
    private static final int INSERTED_INTEGER_2 = 9;
    private static final int INSERTED_INTEGER_3 = 11;

    private static final int NOT_INSERTED_INTEGER_1 = 10;
    private static final int NOT_INSERTED_INTEGER_2 = 5;
    
    private  BloomFilter<Integer> integerFilter = BloomFilter.create(
            Funnels.integerFunnel(),
            500,
            0.01);

    private BloomFilter<String> stringFilter = BloomFilter.create(
            Funnels.stringFunnel(Charsets.UTF_16),
            500,
            0.01);
    
           /*
            We can use the BloomFilter class from the Guava library to achieve this. We need to pass the number 
            of elements that we expect to be inserted into the filter and the desired false positive probability:
         */
    
    
    @Test
    void mightContainInsertedStringValues() {
        stringFilter.put(INSERTED_STRING_1);
        stringFilter.put(INSERTED_STRING_2);
        stringFilter.put(INSERTED_STRING_3);

        assertEquals(true, stringFilter.mightContain(INSERTED_STRING_1));
        assertEquals(true, stringFilter.mightContain(INSERTED_STRING_2));
        assertEquals(true, stringFilter.mightContain(INSERTED_STRING_3));
    }

    @Test
    void mightNotContainInsertedStringValues() {
        stringFilter.put(INSERTED_STRING_1);
        stringFilter.put(INSERTED_STRING_2);
        stringFilter.put(INSERTED_STRING_3);

        assertEquals(false, stringFilter.mightContain(NOT_INSERTED_STRING_2));
        assertEquals(false, stringFilter.mightContain(NOT_INSERTED_STRING_3));
    }

    @Test
    void mightContainInsertedIntValues() {
        stringFilter.put(INSERTED_STRING_1);
        stringFilter.put(INSERTED_STRING_2);
        stringFilter.put(INSERTED_STRING_3);

        assertEquals(true, stringFilter.mightContain(INSERTED_STRING_1));
        assertEquals(true, stringFilter.mightContain(INSERTED_STRING_2));
        assertEquals(true, stringFilter.mightContain(INSERTED_STRING_3));
    }

    @Test
    void mightNotContainInsertedIntValues() {
        integerFilter.put(INSERTED_INTEGER_1);
        integerFilter.put(INSERTED_INTEGER_2);
        integerFilter.put(INSERTED_INTEGER_3);

        assertEquals(false, integerFilter.mightContain(NOT_INSERTED_INTEGER_1));
        assertEquals(false, integerFilter.mightContain(NOT_INSERTED_INTEGER_2));
    }

}
