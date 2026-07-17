void backtrack(/* choices */, int start, List<Integer> current, List<List<Integer>> result) {

    // 1. BASE CASE — when to collect
    if (/* done condition */) {
        result.add(new ArrayList<>(current));   // ← snapshot, never add `current` directly
        return;
    }

    // 2. ITERATE choices
    for (int i = start; i < choices.length; i++) {

        // 3. PRUNING (optional but critical for performance)
        if (/* skip condition */) continue;

        // 4. CHOOSE
        current.add(choices[i]);

        // 5. RECURSE
        backtrack(choices, i + 1, current, result);   // i+1 = no reuse; i = allow reuse; start fresh for permutations

        // 6. UN-CHOOSE  ← the backtrack step
        current.remove(current.size() - 1);
    }
}