import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class MainUnsafe {

    public static final Unsafe UNSAFE;

    static {
        Unsafe u = null;
        try {
            /*
             * This mechanism for getting UNSAFE originally from:
             * 
             * Original License:
             * https://github.com/JCTools/JCTools/blob/master/LICENSE Original
             * location:
             * https://github.com/JCTools/JCTools/blob/master/jctools-core/src/
             * main/java/org/jctools/util/UnsafeAccess.java
             */
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            u = (Unsafe) field.get(null);
        } catch (Throwable e) {
            // do nothing, hasUnsafe() will return false
        }
        UNSAFE = u;
    }

    static final long ARRAY_BASE_OFFSET = UNSAFE.arrayBaseOffset(double[].class);

    public static void main(String[] args) {
        final int SIZE = 1000;
        final int MINOR_LOOPS = 1000;
        final int LOOPS = 10;
        final double[] a = new double[SIZE * SIZE];
        int n;
        for (n = 0; n < LOOPS; n++) {
            int i, j;
            // init array
            for (i = 0; i < SIZE; i++) {
                for (j = 0; j < SIZE; j++) {
                    put(a, i * SIZE + j, 0);
                }
            }

            long start = System.currentTimeMillis();
            int k;
            for (k = 0; k < MINOR_LOOPS; k++) {
                a[0] = 1;
                // average
                for (i = 1; i < SIZE - 1; i++) {
                    for (j = 1; j < SIZE - 1; j++) {
                        double d = (get(a, i * SIZE + j) + get(a, (i - 1) * SIZE + j)
                                + get(a, (i + 1) * SIZE + j) + get(a, i * SIZE + j + 1)
                                + get(a, i * SIZE + j - 1)) / 5;
                        put(a, i * SIZE + j, d);
                    }
                }
            }
            long diff = System.currentTimeMillis() - start;
            System.out.printf("Time taken %f seconds\n", diff / 1000.0);
        }
    }

    public static double get(double[] a, int i) {
        return UNSAFE.getDouble(a, i * 8 + ARRAY_BASE_OFFSET);
    }

    public static void put(double[] a, int i, double d) {
        UNSAFE.putDouble(a, i * 8 + ARRAY_BASE_OFFSET, d);
    }

}
