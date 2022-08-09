package com.example.bloomfiltertraining;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComplexBloomFilterTest {

    private static final int INSERTED_INTEGER_1 = 1;
    private static final int INSERTED_INTEGER_2 = 9;
    private static final int INSERTED_INTEGER_3 = 11;

    private static final int NOT_INSERTED_INTEGER_1 = 10;
    private static final int NOT_INSERTED_INTEGER_2 = 5;

    ComplexBloomFilter complexBloomFilter =  new ComplexBloomFilter(64);

    @Test
    void mightContainsInsertedStrings() {

        complexBloomFilter.addValue(INSERTED_INTEGER_1);
        complexBloomFilter.addValue(INSERTED_INTEGER_2);
        complexBloomFilter.addValue(INSERTED_INTEGER_3);

        assertEquals(true, complexBloomFilter.mightContain(INSERTED_INTEGER_1));
        assertEquals(true, complexBloomFilter.mightContain(INSERTED_INTEGER_2));
        assertEquals(true, complexBloomFilter.mightContain(INSERTED_INTEGER_3));

    }

    @Test
    void mightNotContainNotInsertedStrings() {

        complexBloomFilter.addValue(INSERTED_INTEGER_1);
        complexBloomFilter.addValue(INSERTED_INTEGER_2);
        complexBloomFilter.addValue(INSERTED_INTEGER_3);

        assertEquals(false, complexBloomFilter.mightContain(NOT_INSERTED_INTEGER_1));
        assertEquals(false, complexBloomFilter.mightContain(NOT_INSERTED_INTEGER_2));

    }
}
