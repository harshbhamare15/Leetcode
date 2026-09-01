class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int[][] litterId = new int[m][n];

        for (int[] row : litterId) {
            Arrays.fill(row, -1);
        }

        int k = 0;
        int sr = 0;
        int sc = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char ch = classroom[r].charAt(c);

                if (ch == 'S') {
                    sr = r;
                    sc = c;
                } else if (ch == 'L') {
                    litterId[r][c] = k++;
                }
            }
        }

        if (k == 0) {
            return 0;
        }

        int fullMask = (1 << k) - 1;

        int[][][] best = new int[m][n][1 << k];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                Arrays.fill(best[r][c], -1);
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();

        best[sr][sc][0] = energy;
        queue.offer(new int[]{sr, sc, 0, energy, 0});

        int[][] dirs = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int r = cur[0];
            int c = cur[1];
            int mask = cur[2];
            int e = cur[3];
            int moves = cur[4];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                if (classroom[nr].charAt(nc) == 'X') {
                    continue;
                }

                int ne = e - 1;

                if (ne < 0) {
                    continue;
                }

                int nmask = mask;
                char ch = classroom[nr].charAt(nc);

                if (ch == 'R') {
                    ne = energy;
                }

                if (ch == 'L') {
                    nmask |= 1 << litterId[nr][nc];
                }

                if (nmask == fullMask) {
                    return moves + 1;
                }

                if (ne <= best[nr][nc][nmask]) {
                    continue;
                }

                best[nr][nc][nmask] = ne;
                queue.offer(new int[]{nr, nc, nmask, ne, moves + 1});
            }
        }

        return -1;
    }
}
