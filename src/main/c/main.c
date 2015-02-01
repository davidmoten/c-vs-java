// hello.c
#include <stdio.h>
#include <time.h>
 
int main() {
    printf("Starting\n");  
    int SIZE = 1000;
    int MINOR_LOOPS = 1000;
    int LOOPS = 10;
    double a[SIZE][SIZE];
    int n;
    for  (n=0;n<LOOPS;n++) {
		int i,j;
		for (i=0;i<SIZE;i++) {
		    for (j=0;j<SIZE;j++) {
		        a[i][j]=0;
		    }
		}
		a[0][0]=1;
		clock_t start, diff;
		start = clock();

		int k;
		for (k=0;k<MINOR_LOOPS;k++) {
		  for (i=1;i<SIZE-1;i++) {
		    for (j=1;j<SIZE-1;j++) {
		        a[i][j]=(a[i][j]  + a[i-1][j] + a[i+1][j]  + a[i][j+1] + a[i][j-1])/5;
		    }
		  }
		}

		diff = clock() - start;
		int msec = diff * 1000 / CLOCKS_PER_SEC;
		printf("Time taken %f seconds\n", msec/1000.0);    
    }
    return 0;

}
