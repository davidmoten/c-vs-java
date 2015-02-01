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
###i5 laptop
C:

```
Time taken 3.570000 seconds
Time taken 3.470000 seconds
Time taken 3.490000 seconds
Time taken 3.480000 seconds
```

Java:
```
Time taken 6.086000 seconds
Time taken 6.054000 seconds
Time taken 6.041000 seconds
Time taken 6.075000 seconds

```

###i7 desktop
C:
```
Time taken 2.464000 seconds
Time taken 2.459000 seconds
Time taken 2.459000 seconds
Time taken 2.460000 seconds
```

Java:
```
Time taken 3.488000 seconds
Time taken 3.489000 seconds
Time taken 3.473000 seconds
Time taken 3.474000 seconds
```

Thus run time was 1.4 to 1.7 times slower with Java than C.



