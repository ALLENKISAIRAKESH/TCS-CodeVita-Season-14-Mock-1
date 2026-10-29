import java.util.*;

public class GravityGlide {
    static int n;
    static int[][] s;

    static boolean on(int i, int px, int py) {
        int x1 = s[i][0], y1 = s[i][1], x2 = s[i][2], y2 = s[i][3];
        if (px < Math.min(x1, x2) || px > Math.max(x1, x2)) return false;
        if (py < Math.min(y1, y2) || py > Math.max(y1, y2)) return false;
        return (px - x1) * (y2 - y1) == (py - y1) * (x2 - x1);
    }

    static boolean dir(int x, int y, int dx, int dy) {
        for (int i = 0; i < n; i++)
            if (on(i, x, y) && on(i, x + dx, y + dy)) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = new int[n][4];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 4; j++)
                s[i][j] = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int e = sc.nextInt();

        while (true) {
            int best = -1;
            for (int i = 0; i < n; i++) {
                int x1 = s[i][0], y1 = s[i][1], x2 = s[i][2], y2 = s[i][3];
                if (x < Math.min(x1, x2) || x > Math.max(x1, x2)) continue;
                int slope = (y2 - y1) / (x2 - x1);
                int h = y1 + slope * (x - x1);
                int low = Math.min(y1, y2);
                if (h < y || (h == y && h > low)) {
                    if (h > best) best = h;
                }
            }
            if (best < 0) {
                System.out.print(x + " 0");
                return;
            }
            y = best;

            while (true) {
                if (y == 0) {
                    System.out.print(x + " " + y);
                    return;
                }
                if (dir(x, y, -1, 1) && dir(x, y, 1, 1)) {
                    int cost = x * y;
                    if (e < cost) {
                        System.out.print(x + " " + y);
                        return;
                    }
                    e -= cost;
                }
                int d = 0;
                if (dir(x, y, -1, -1)) d = -1;
                else if (dir(x, y, 1, -1)) d = 1;
                if (d == 0) break;
                if (e < 1) {
                    System.out.print(x + " " + y);
                    return;
                }
                e--;
                x += d;
                y--;
            }
        }
    }
}
