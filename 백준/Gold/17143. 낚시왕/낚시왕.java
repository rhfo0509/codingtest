import java.io.*;
import java.util.*;

public class Main {
    static int R, C, M, score;
    static Shark[][] grid, tempGrid;
    static class Shark {
        int s;
        int d;
        int z;
        Shark(int s, int d, int z) {
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new Shark[R + 1][C + 1];
        tempGrid = new Shark[R + 1][C + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            grid[r][c] = new Shark(s, d, z);
        }
        for (int c = 1; c <= C; c++) {
            // 낚시왕 turn
            for (int r = 1; r <= R; r++) {
                if (grid[r][c] != null) {
                    score += grid[r][c].z;
                    grid[r][c] = null;
                    break;
                }
            }
            // 상어 turn
            tempGrid = new Shark[R + 1][C + 1];
            for (int i = 1; i <= R; i++) {
                for (int j = 1; j <= C; j++) {
                    if (grid[i][j] != null) {
                        move(i, j, grid[i][j]);
                    }
                }
            }
            grid = tempGrid;
        }
        System.out.print(score);
    }
    static void move(int x, int y, Shark shark) {
        int s = shark.s;
        int d = shark.d;
        int z = shark.z;

        if (d == 1) {
            if (x - s >= 1) {
                x -= s;
            } else {
                s -= (x - 1);
                if ((s / (R - 1)) % 2 == 0) {
                    x = (s % (R - 1)) + 1;
                    d = 2;
                } else {
                    x = R - (s % (R - 1));
                }
            }
        } else if (d == 2) {
            if (x + s <= R) {
                x += s;
            } else {
                s -= (R - x);
                if ((s / (R - 1)) % 2 == 0) {
                    x = R - (s % (R - 1));
                    d = 1;
                } else {
                    x = (s % (R - 1)) + 1;
                }
            }
        } else if (d == 3) {
            if (y + s <= C) {
                y += s;
            } else {
                s -= (C - y);
                if ((s / (C - 1)) % 2 == 0) {
                    y = C - (s % (C - 1));
                    d = 4;
                } else {
                    y = (s % (C - 1)) + 1;
                }
            }
        } else {
            if (y - s >= 1) {
                y -= s;
            } else {
                s -= (y - 1);
                if ((s / (C - 1)) % 2 == 0) {
                    y = (s % (C - 1)) + 1;
                    d = 3;
                } else {
                    y = C - (s % (C - 1));
                }
            }
        }
        shark.d = d;
        if (tempGrid[x][y] == null || tempGrid[x][y].z < z) {
            tempGrid[x][y] = shark;
        }
    }
}