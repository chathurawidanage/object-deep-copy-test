# Java Object Deep Copy Test
This test finds the most efficient object deep copying mechanism that can be applied in java.

Test results were as follows,

Speed Test
-----------------

* JSON Copy avg time(ms) : 30.733333333333334
* Manual Copy avg time(ms) : 11.733333333333333
* Java Clonable avg time(ms) : 0.6
* Java Serialization Copy avg time(ms) : 15.666666666666666
* Protocol buffer Copy avg time(ms) : 4.733333333333333
* Apache Commons Copy avg time(ms) : 7.6
* Kryo Copy avg time(ms) : 10.733333333333333
* Custom Packing avg time(ms) : 5.333333333333333

Space Test
-----------------

* JSON space(MB) : 6.963011
* Java  Serialization space(MB) : 6.118144
* Protocol buffer space(MB) : 5.29589
* Apache commons space(MB) : 6.118144
* Kryo space(MB) : 15.72864
* Custom Packing space(MB) : 5.739828
