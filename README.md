# Getting Started
A Bloom filter is a space-efficient probabilistic data structure that is used to test whether an element is a member of a set. 

The first implementation is a simple bloom filter in which we use two different hash functions.
We add a value in the bit array in the positions determined by the hash functions.

The complex implementation the following bitwise operators are used: 


The >>> bitwise unsigned right shift - Shifts the bits of the number to the right and fills 0 on voids left as a result.
The leftmost bit is set to 0. (>>>) is unsigned-shift; it’ll insert 0. (>>) is signed, and will extend the sign bit.

The <<  bitwise left shift - Shifts the bits of the number to the left and fills 0 on voids left as a result.
Similar effect as of multiplying the number with some power of two.

The |=  bitwise or (a |= b; same as a = (a | b);) - Bitwise OR (|) This operator is a binary operator,
denoted by ‘|’. It returns bit by bit OR of input values, i.e,
if either of the bits is 1, it gives 1, else it gives 0.

Also it was implemented a test with Guava implementation for comparing. 