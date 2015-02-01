public class Main {

	public static void main(String[] args) {
		final int SIZE = 1000;
		final int MINOR_LOOPS = 1000;
		final int LOOPS = 10;
		final double[][] a = new double[1000][SIZE];
		int n;
		for (n = 1; n < LOOPS; n++) {
			int i, j;
			// init array
			for (i = 0; i < SIZE; i++) {
				for (j = 0; j < SIZE; j++) {
					if (i == 0)
						a[i][j] = 1;
					else
						a[i][j] = 1;
				}
			}
			long start, diff;
			start = System.currentTimeMillis();
			int k;
			for (k = 0; k < MINOR_LOOPS; k++) {

				// heat exchange
				for (i = 1; i < SIZE - 1; i++) {
					for (j = 1; j < SIZE - 1; j++) {
						a[i][j] = 5 * a[i][j] - a[i - 1][j] - a[i + 1][j]
								- a[i][j + 1] - a[i][j - 1];
					}
				}
			}
			diff = System.currentTimeMillis() - start;
			System.out.printf("Time taken %f seconds\n", diff / 1000.0);
		}
	}
}
