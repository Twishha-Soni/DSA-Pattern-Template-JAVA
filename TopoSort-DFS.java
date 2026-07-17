DFS variant skeleton (for when you need reverse-finish-order):


// state[]: 0=unvisited, 1=visiting(in stack), 2=done
int[] state = new int[n];
List<Integer> result = new ArrayList<>();

boolean hasCycle(int node) {
    if (state[node] == 1) return true;   // back edge = cycle
    if (state[node] == 2) return false;  // already processed
    state[node] = 1;
    for (int nei : adj.get(node))
        if (hasCycle(nei)) return true;
    state[node] = 2;
    result.add(node);                    // add at finish
    return false;
}
// Collections.reverse(result) at the end
