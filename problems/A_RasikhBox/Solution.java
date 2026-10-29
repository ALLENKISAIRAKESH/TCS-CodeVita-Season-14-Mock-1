import java.util.*;
import java.io.*;

public class RasikhBox {
    static void gravity(char[][] g) {
        int r = g.length, c = g[0].length;
        for (int j = 0; j < c; j++) {
            int write = r - 1;
            for (int i = r - 1; i >= 0; i--) {
                if (g[i][j] == '*') {
                    g[i][j] = '.';
                    g[write][j] = '*';
                    write--;
                }
            }
        }
    }

    static char[][] rotateRight(char[][] g) {
        int r = g.length, c = g[0].length;
        char[][] res = new char[c][r];
        for (int i = 0; i < c; i++)
            for (int j = 0; j < r; j++)
                res[i][j] = g[r - 1 - j][i];
        return res;
    }

    static char[][] rotateLeft(char[][] g) {
        int r = g.length, c = g[0].length;
        char[][] res = new char[c][r];
        for (int i = 0; i < c; i++)
            for (int j = 0; j < r; j++)
                res[i][j] = g[j][c - 1 - i];
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder all = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) all.append(line).append(' ');
        StringTokenizer st = new StringTokenizer(all.toString());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        char[][] g = new char[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                g[i][j] = st.nextToken().charAt(0);

        int k = Integer.parseInt(st.nextToken());
        gravity(g);

        for (int i = 0; i < k; i++) {
            String ins = st.nextToken();
            if (ins.equalsIgnoreCase("right")) g = rotateRight(g);
            else g = rotateLeft(g);
            gravity(g);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                if (j > 0) sb.append(' ');
                sb.append(g[i][j]);
            }
            if (i < g.length - 1) sb.append('\n');
        }
        System.out.print(sb);
    }
}
