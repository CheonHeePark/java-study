package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_2178 {
    private static class Map {
        int x, y, count;
        public Map(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < line.length(); ++j) {
                map[i][j + 1] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        int answer = 0;
        boolean[][] visit = new boolean[N + 1][M + 1];
        ArrayDeque<Map> q = new ArrayDeque<>();
        q.offer(new Map(1,1, 1));
        while (!q.isEmpty()) {
            Map current = q.poll();
            int x = current.x;
            int y = current.y;
            int c = current.count;
            answer = c;
            if (x == N && y == M) break;
            visit[x][y] = true;
            if (x + 1 <= N && map[x + 1][y] == 1 && !visit[x + 1][y]) {
                visit[x + 1][y] = true;
                q.offer(new Map(x + 1, y, c + 1));
            }
            if (x - 1 >= 1 && map[x - 1][y] == 1 && !visit[x - 1][y]) {
                visit[x - 1][y] = true;
                q.offer(new Map(x - 1, y, c + 1));
            }
            if (y + 1 <= M && map[x][y + 1] == 1 && !visit[x][y + 1]) {
                visit[x][y + 1] = true;
                q.offer(new Map(x , y + 1, c + 1));
            }
            if (y - 1 >= 1 && map[x][y - 1] == 1 && !visit[x][y - 1]) {
                visit[x][y - 1] = true;
                q.offer(new Map(x, y - 1, c + 1));
            }
        }
        System.out.println(answer);
    }
}
