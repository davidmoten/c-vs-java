# c-vs-java
Performance comparison on 2D array of Java and C

Method
----------
A 2D array of double with one million entries is subjected to a transformation over 1000 steps of each cell into the average of itself and its neighbours (up, down, left, right).

[src/main/c/main.c](src/main/c/main.c) is compiled using *gcc* with maximum optimizations (```-Ofast```) on Linux.

[src/main/java/Main.java](src/main/java/Main.java) in java is compiled with *javac* and executed with the ```-server``` option.

Two scripts are provided that compile and execute the relevant source:

* ```run-c.sh```
* ```run-java.sh```


Results
-----------
Using gcc 4.6.3, javac 1.8u25:

| Machine | Mean Java run time (s) | Mean C run time (s) | Java to C run time ratio |
| ------------- | ------------- | ------------- | ------------- |
| 2009 i5 laptop | 7.89 | 4.85 | **1.7**  |
| 2012 Xeon i7 desktop | 4.43 | 2.50 | **1.8** |

Using gcc 5.4.0, javac 1.8u151:

| Machine | Mean Java run time (s) | Mean C run time (s) | Java to C run time ratio |
| ------------- | ------------- | ------------- | ------------- |
| i5-6200U @ 2.30GHz | 6.58 | 6.38 | **1.03**  |

It appears that gcc 5 has some large performance regressions compared to gcc 4.6.3. Will be good to compare gcc 6 and 7 with Java to see if regressions fixed. 


