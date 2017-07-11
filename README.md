# Java Object Deep Copy Test
This test finds the most efficient object deep copying mechanism that can be applied in java.

Test results were as follows,

Starting Speed Test
-----------------

* JSON Copy time(ms) : 2.016
* Manual Copy time(ms) : 0.11666666666666667
* Java Serialization Copy time(ms) : 2.711333333333333
* Protocol buffer Copy time(ms) : 5.508666666666667

Starting Space Test
-----------------

* JSON space(MB) : 331.006339
* Java  Serialization space(MB) : 148.858127
* Protocol buffer space(MB) : 159.567347
