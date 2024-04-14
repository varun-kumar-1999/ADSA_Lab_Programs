import java.util.Scanner;

public class TSP {
    int a[][], visited[], n, cost;

    TSP() {
        cost = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter No. of Cities:");
        n = scan.nextInt();
        a = new int[n][n];
        visited = new int[n];
        System.out.println("Enter Cost Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    System.out.print("Enter distance from " + (i + 1) + " to " + (j + 1) + ":=>");
                    a[i][j] = scan.nextInt();
                }
            }
            visited[i] = 0;
        }
        scan.close();
    }

    void mincost(int city) {
        visited[city] = 1;
        System.out.print((city + 1) + "->");
        int ncity = least(city);
        if (ncity == 999) {
            ncity = 0;
            System.out.println(ncity + 1);
            cost += a[city][ncity];
            return;
        }
        mincost(ncity);
    }

    int least(int c) {
        int nc = 999;
        int min = 999;
        int kmin = 0;
        for (int i = 0; i < n; i++) {
            if ((a[c][i] != 0) && (visited[i] == 0))
                if (a[c][i] < min) {
                    min = a[i][0] + a[c][i];
                    kmin = a[c][i];
                    nc = i;
                }
        }
        if (min != 999)
            cost += kmin;
        return nc;
    }

    void put() {
        System.out.println("Minimum cost:" + cost);
    }

    public static void main(String args[]) {
        TSP t = new TSP();
        System.out.println("The Optimal Path is:");
        t.mincost(0);
        t.put();
    }
}
