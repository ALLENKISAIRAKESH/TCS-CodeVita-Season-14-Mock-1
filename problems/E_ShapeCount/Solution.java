import java.util.*;

public class ShapeCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] s = new int[n][4];
        TreeSet<Integer> tx = new TreeSet<>(), ty = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();
            s[i][0] = Math.min(a, c);
            s[i][1] = Math.min(b, d);
            s[i][2] = Math.max(a, c);
            s[i][3] = Math.max(b, d);
            tx.add(a); tx.add(c);
            ty.add(b); ty.add(d);
        }
        Integer[] xs = tx.toArray(new Integer[0]);
        Integer[] ys = ty.toArray(new Integer[0]);
        int w = xs.length, h = ys.length;
        boolean[][] hor = new boolean[h][w];
        boolean[][] ver = new boolean[w][h];

        for (int i = 0; i < n; i++) {
            int xa = Arrays.asList(xs).indexOf(s[i][0]);
            int ya = Arrays.asList(ys).indexOf(s[i][1]);
            int xb = Arrays.asList(xs).indexOf(s[i][2]);
            int yb = Arrays.asList(ys).indexOf(s[i][3]);
            if (s[i][1] == s[i][3]) {
                for (int k = xa; k < xb; k++) hor[ya][k] = true;
            } else if (s[i][0] == s[i][2]) {
                for (int k = ya; k < yb; k++) ver[xa][k] = true;
            }
        }

        int cnt = 0;
        for (int a = 0; a < h; a++) {
            for (int b = a + 1; b < h; b++) {
                for (int c = 0; c < w; c++) {
                    for (int d = c + 1; d < w; d++) {
                        boolean ok = true;
                        for (int k = c; k < d && ok; k++)
                            if (!hor[a][k] || !hor[b][k]) ok = false;
                        for (int k = a; k < b && ok; k++)
                            if (!ver[c][k] || !ver[d][k]) ok = false;
                        if (ok) cnt++;
                    }
                }
            }
        }
        System.out.print(cnt);
    }
}
