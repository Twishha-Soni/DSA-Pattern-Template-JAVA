Queue<int[]> q = new LinkedList<>();
boolean[][] visited = new boolean[m][n];

q.offer(start);
visited[r][c] = true;          // mark at OFFER time, not poll time

int steps = 0;

while (!q.isEmpty()) {
    int size = q.size();        // snapshot level size FIRST
    for (int i = 0; i < size; i++) {
        int[] cur = q.poll();
        // process cur — check goal here for shortest path
        for (int[] dir : DIRS) {
            int nr = cur[0] + dir[0];
            int nc = cur[1] + dir[1];
            if (inBounds(nr, nc) && !visited[nr][nc]) {
                visited[nr][nc] = true;   // mark before offer
                q.offer(new int[]{nr, nc});
            }
        }
    }
    steps++;
}