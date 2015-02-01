// hello.c
#include <stdio.h>
#include <time.h>
 
int main() {
    printf("Starting\n");  
    int SIZE = 1000;
    int MINOR_LOOPS = 1000;
    int LOOPS = 5;
    double a[SIZE][SIZE];
    int n;
    for  (n=1;n<LOOPS;n++) {
		int i,j;
		for (i=0;i<SIZE;i++) {
		    for (j=0;j<SIZE;j++) {
		      if (i==0)
		        a[i][j] = 1;
		      else 
		        a[i][j]=1;
		    }
		}
		clock_t start, diff;
		start = clock();

		int k;
		for (k=0;k<MINOR_LOOPS;k++) {
		  for (i=1;i<SIZE-1;i++) {
		    for (j=1;j<SIZE-1;j++) {
		        a[i][j]=5*a[i][j] -a[i-1][j]-a[i+1][j] -a[i][j+1]-a[i][j-1];
		    }
		  }
		}

		diff = clock() - start;
		int msec = diff * 1000 / CLOCKS_PER_SEC;
		printf("Time taken %f seconds\n", msec/1000.0);    
    }
    return 0;

}
