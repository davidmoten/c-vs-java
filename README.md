# c-vs-java
Performance comparison on 2D array of Java and C

Method
----------
A 2D array of double with one million entries is subjected to manipulations vaguely like the application of heat transfer (at each of a 1000 time steps each cell is a function of itself and the 4 adjacent cells (up, down, left, right)).

[src/main/c/main.c](src/main/c/main.c) is compiled using *gcc 4.6.3* with maximum optimizations (```-Ofast```) on Linux.

[src/main/java/Main.java](src/main/java/Main.java) in java is compiled using *javac 1.8u25* and executed with the ```-server``` option.

Two scripts are provided that compile and execute the relevant source:

* ```run-c.sh```
* ```run-java.sh```


Results
-----------

| Machine | Mean Java run time (s) | Mean C run time (s) | Java to C run time ratio |
| ------------- | ------------- |
| 5 year old i5 laptop | 6.00 | 3.46 | **1.7**  |
| 4 year old i7 desktop  | 3.52 | 2.46 | **1.4**  |
| 2 year old Xeon i7 desktop | 1.55 | 1.41 | **1.1**  |



