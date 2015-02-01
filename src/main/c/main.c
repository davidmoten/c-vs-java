// hello.c
#include <stdio.h>
#include <time.h>
 
int main() {
    
    double a[1000][1000];
    int n;
    for  (n=1;n<10;n++) {
    int i,j;
    for (i=0;i<1000;i++) {
        for (j=0;j<1000;j++) {
            a[i][j]=i/1000.0*j/1000.0;
        }
    }
    clock_t start, diff;
    start = clock();
    int k;
    for (k=0;k<1000;k++) {
      for (i=1;i<1000-1;i++) {
        for (j=1;j<1000-1;j++) {
            a[i][j]=4*a[i][j] -a[i-1][j]-a[i+1][j] -a[i][j+1]-a[i][j-1];
        }
      }
    }
    diff = clock() - start;

    int msec = diff * 1000 / CLOCKS_PER_SEC;
    printf("Time taken %d seconds %d milliseconds\n", msec/1000, msec%1000);    
    }
    return 0;

}
