Universal Java Template — Kahn's Algorithm (BFS Topo Sort)

// Step 1: Build graph + in-degree array
int[] inDegree = new int[n];
List<List<Integer>> adj = new ArrayList<>();
for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

for (int[] edge : edges) {            // edge = [from, to]  (from → to)
    adj.get(edge[0]).add(edge[1]);
    inDegree[edge[1]]++;
}

// Step 2: Seed queue with all in-degree 0 nodes
Queue<Integer> q = new LinkedList<>();
for (int i = 0; i < n; i++)
    if (inDegree[i] == 0) q.offer(i);

// Step 3: BFS drain
List<Integer> order = new ArrayList<>();
while (!q.isEmpty()) {
    int node = q.poll();
    order.add(node);                  // or process node here
    for (int nei : adj.get(node)) {
        inDegree[nei]--;
        if (inDegree[nei] == 0) q.offer(nei);
    }
}

// Step 4: Cycle check
// order.size() == n  → valid DAG, order is the topo order
// order.size() < n   → cycle exists, no valid ordering
