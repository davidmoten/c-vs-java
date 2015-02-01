public class Main {

	public static void main(String[] args) {
		double[][] a = new double[1000][1000];
		int n;
		for (n = 1; n < 10; n++) {
			int i, j;
			for (i = 0; i < 1000; i++) {
				for (j = 0; j < 1000; j++) {
					a[i][j] = i / 1000.0 * j / 1000.0 / 100.0;
				}
			}
			long start, diff;
			start = System.currentTimeMillis();
			int k;
			for (k = 0; k < 1000; k++) {
				for (i = 1; i < 1000 - 1; i++) {
					for (j = 1; j < 1000 - 1; j++) {
						a[i][j] = 4 * a[i][j] - a[i - 1][j] - a[i + 1][j]
								- a[i][j + 1] - a[i][j - 1];
					}
				}
			}
			double d = 0;
			for (i = 0; i < 1000; i++) {
				for (j = 0; j < 1000; j++) {
					System.out.println(a[i][i]);
					d += a[i][j];
				}
			}
			diff = System.currentTimeMillis() - start;
			System.out.println(d);
			System.out.printf("Time taken %f seconds\n", diff / 1000.0);
		}
	}
}
