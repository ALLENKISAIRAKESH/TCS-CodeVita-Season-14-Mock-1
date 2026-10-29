import java.util.*;

public class PickSmartPlayWise {
    static ArrayList<double[]> pts = new ArrayList<>();
    static HashMap<String, Integer> ids = new HashMap<>();

    static int node(double x, double y) {
        String k = Math.round(x * 1e6) + "," + Math.round(y * 1e6);
        Integer id = ids.get(k);
        if (id == null) {
            id = pts.size();
            ids.put(k, id);
            pts.add(new double[]{x, y});
        }
        return id;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[][] s = new double[n][4];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 4; j++)
                s[i][j] = sc.nextInt();

        ArrayList<ArrayList<double[]>> on = new ArrayList<>();
        double total = 0;
        for (int i = 0; i < n; i++) {
            on.add(new ArrayList<>());
            total += Math.hypot(s[i][2] - s[i][0], s[i][3] - s[i][1]);
            on.get(i).add(new double[]{0, node(s[i][0], s[i][1])});
            on.get(i).add(new double[]{1, node(s[i][2], s[i][3])});
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double rx = s[i][2] - s[i][0], ry = s[i][3] - s[i][1];
                double qx = s[j][2] - s[j][0], qy = s[j][3] - s[j][1];
                double d = rx * qy - ry * qx;
                if (Math.abs(d) < 1e-12) continue;
                double wx = s[j][0] - s[i][0], wy = s[j][1] - s[i][1];
                double t = (wx * qy - wy * qx) / d;
                double u = (wx * ry - wy * rx) / d;
                double eps = 1e-9;
                if (t < -eps || t > 1 + eps || u < -eps || u > 1 + eps) continue;
                double px = s[i][0] + t * rx, py = s[i][1] + t * ry;
                int id = node(px, py);
                on.get(i).add(new double[]{t, id});
                on.get(j).add(new double[]{u, id});
            }
        }

        int m = pts.size();
        ArrayList<HashSet<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < m; i++) adj.add(new HashSet<>());

        for (int i = 0; i < n; i++) {
            ArrayList<double[]> l = on.get(i);
            l.sort((a, b) -> Double.compare(a[0], b[0]));
            for (int k = 0; k + 1 < l.size(); k++) {
                int a = (int) l.get(k)[1], b = (int) l.get(k + 1)[1];
                if (a == b) continue;
                adj.get(a).add(b);
                adj.get(b).add(a);
            }
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++)
            if (adj.get(i).size() <= 1) q.add(i);
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int w : new ArrayList<>(adj.get(v))) {
                adj.get(w).remove(v);
                if (adj.get(w).size() == 1) q.add(w);
            }
            adj.get(v).clear();
        }

        int start = -1;
        for (int i = 0; i < m; i++)
            if (adj.get(i).size() >= 2) { start = i; break; }

        if (start == -1) {
            System.out.print("Abandoned");
            return;
        }

        double area = 0, per = 0;
        int prev = -1, cur = start;
        do {
            int nxt = -1;
            for (int w : adj.get(cur))
                if (w != prev) { nxt = w; break; }
            double[] a = pts.get(cur), b = pts.get(nxt);
            area += a[0] * b[1] - a[1] * b[0];
            per += Math.hypot(b[0] - a[0], b[1] - a[1]);
            prev = cur;
            cur = nxt;
        } while (cur != start);
        area = Math.abs(area) / 2;

        double left = total - per;
        double comp = left * left / (4 * Math.PI);

        if (comp > area) System.out.print("Computer");
        else System.out.print("Kalyan");
    }
}
