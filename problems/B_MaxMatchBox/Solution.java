import java.util.*;

public class MaxMatchBox {
    static int n;
    static int[] px, py;

    static boolean inside(double cx, double cy) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            if (px[i] == px[j] && px[i] > cx) {
                int lo = Math.min(py[i], py[j]);
                int hi = Math.max(py[i], py[j]);
                if (cy > lo && cy < hi) cnt++;
            }
        }
        return cnt % 2 == 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        px = new int[n];
        py = new int[n];
        for (int i = 0; i < n; i++) {
            px[i] = sc.nextInt() * 10;
            py[i] = sc.nextInt() * 10;
        }

        int minEdge = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            int len = Math.abs(px[i] - px[j]) + Math.abs(py[i] - py[j]);
            if (len > 0 && len < minEdge) minEdge = len;
        }

        int size = 250;
        int[][] pre = new int[size + 1][size + 1];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                int v = inside(i - 0.5, j - 0.5) ? 1 : 0;
                pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + v;
            }
        }

        double best = 0;
        for (int k = 1; minEdge - 2 * k >= 1 && 2 * k + 1 <= size; k++) {
            int w = 2 * k + 1;
            int cells = 0;
            for (int i = w; i <= size; i++) {
                for (int j = w; j <= size; j++) {
                    int s = pre[i][j] - pre[i - w][j] - pre[i][j - w] + pre[i - w][j - w];
                    if (s == w * w) cells++;
                }
            }
            double vol = cells / 100.0 * k / 10.0;
            if (vol > best) best = vol;
        }

        System.out.printf("%.2f", best);
    }
}
