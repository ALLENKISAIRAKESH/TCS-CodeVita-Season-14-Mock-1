import java.util.*;

public class SmallestRegion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] r = new int[n][4];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 4; j++)
                r[i][j] = sc.nextInt();
        int px1 = sc.nextInt(), py1 = sc.nextInt(), px2 = sc.nextInt(), py2 = sc.nextInt();

        int w = minGap(r, 0, 2, px1, px2);
        int h = minGap(r, 1, 3, py1, py2);
        System.out.print(w * h);
    }

    static int minGap(int[][] r, int lo, int hi, int start, int end) {
        int prev = start;
        int best = Integer.MAX_VALUE;
        for (int p = start + 1; p <= end; p++) {
            boolean ok = true;
            if (p < end) {
                for (int[] q : r) {
                    if (q[lo] < p && p < q[hi]) {
                        ok = false;
                        break;
                    }
                }
            }
            if (ok) {
                best = Math.min(best, p - prev);
                prev = p;
            }
        }
        return best;
    }
}
