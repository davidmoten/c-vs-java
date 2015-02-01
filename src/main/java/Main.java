public class Main {

	public static void main(String[] args) {
		final int SIZE = 1000;
		final int MINOR_LOOPS = 1000;
		final int LOOPS = 10;
		final double[][] a = new double[SIZE][SIZE];
		int n;
		for (n = 0; n < LOOPS; n++) {
			int i, j;
			// init array
			for (i = 0; i < SIZE; i++) {
				for (j = 0; j < SIZE; j++) {
					a[i][j] = 0;
				}
			}

			long start = System.currentTimeMillis();
			int k;
			for (k = 0; k < MINOR_LOOPS; k++) {
				a[0][0] = 1;
				// average
				for (i = 1; i < SIZE - 1; i++) {
					for (j = 1; j < SIZE - 1; j++) {
						a[i][j] = (a[i][j] + a[i - 1][j] + a[i + 1][j]
								+ a[i][j + 1] + a[i][j - 1]) / 5;
					}
				}
			}
			long diff = System.currentTimeMillis() - start;
			System.out.printf("Time taken %f seconds\n", diff / 1000.0);
		}
	}
}
