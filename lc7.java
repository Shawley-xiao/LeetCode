/**
 * lc2
 */
public class lc2 {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }

        int[] a = new int[10];
        int offset = 0;
        int orginal = x;
        while (orginal != 0) {
            a[offset] = orginal % 10;
            offset++;
            orginal /= 10;
        }

        long sum = 0;
        for (int i = 0; i < offset - 1; i++) {
            sum += a[i] * Math.pow(10, offset - i - 1);
        }

        sum += a[offset - 1];
        return sum <= (Math.pow(2, 31) - 1) && sum >= -Math.pow(2, 31) ?(int)sum :0;
    }

    public static void main(String[] args) {
        lc2 lc = new lc2();
        int res = lc.reverse(1463847412);
        System.out.println(res);
    }
}

