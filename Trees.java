// ── single return value (height, depth, count) ──────────────────
int dfs(TreeNode node) {
    if (node == null) return BASE;          // leaf's child answer
    int left  = dfs(node.left);
    int right = dfs(node.right);
    // ① update global answer (spans both sides)
    ans = Math.max(ans, f(left, right, node.val));
    // ② return single value upward (best one side)
    return g(left, right, node.val);
}

// ── pass-bounds top-down (BST validation, range checks) ─────────
boolean dfs(TreeNode node, long lo, long hi) {
    if (node == null) return true;
    if (node.val <= lo || node.val >= hi) return false;
    return dfs(node.left, lo, node.val)
        && dfs(node.right, node.val, hi);
}

// ── return-node (LCA, search) ────────────────────────────────────
TreeNode dfs(TreeNode node, int p, int q) {
    if (node == null) return null;
    TreeNode left  = dfs(node.left,  p, q);
    TreeNode right = dfs(node.right, p, q);
    if (left != null && right != null) return node; // fork
    return left != null ? left : right;
}
