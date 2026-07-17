import java.util.ArrayList;
import java.util.List;

public class Intervals {
    

    // ── SORT ──────────────────────────────────────────────────────────────
Arrays.sort(intervals, (a, b) -> a[0] - b[0]);   // sort by start
// (for "earliest finish" greedy, sort by a[1] - b[1] instead)

// ── SWEEP ─────────────────────────────────────────────────────────────
List<int[]> result = new ArrayList<>();
int[] current = intervals[0];                      // seed with first interval

for (int i = 1; i < intervals.length; i++) {
    int[] next = intervals[i];

    if (next[0] <= current[1]) {                   // OVERLAP CHECK
        // ── MERGE: extend the right boundary ──
        current[1] = Math.max(current[1], next[1]);
    } else {
        // ── NO OVERLAP: commit current, advance ──
        result.add(current);
        current = next;
    }
}
result.add(current);                               // don't forget the last one

return result.toArray(new int[result.size()][]);
}
