public class heap_topk {

    import java.util.PriorityQueue;
    
    // ── Template A: k-th Largest / Top K ──────────────────────────────────────
    // Min-heap of size k. Root = k-th largest at all times.
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // natural order = min-heap
    
    for (int num : nums) {
        minHeap.offer(num);
        if (minHeap.size() > k) {
            minHeap.poll();          // evict the weakest champion
        }
    }
    int kthLargest = minHeap.peek(); // root = k-th largest
    
    
    // ── Template B: Top K by Custom Key (e.g. frequency) ──────────────────────
    // Min-heap ordered by the key you care about (frequency, distance, etc.)
    PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    // a[0] = value, a[1] = key (frequency / -distance / etc.)
    
    for (Map.Entry<Integer, Integer> e : freqMap.entrySet()) {
        heap.offer(new int[]{e.getKey(), e.getValue()});
        if (heap.size() > k) heap.poll();
    }
    // heap now contains the top-k entries by key
    
    
    // ── Template C: Two-Heap (Median Stream) ──────────────────────────────────
    PriorityQueue<Integer> lo = new PriorityQueue<>(Collections.reverseOrder()); // max-heap, lower half
    PriorityQueue<Integer> hi = new PriorityQueue<>();                           // min-heap, upper half
    
    void addNum(int num) {
        lo.offer(num);               // always enter through lo
        hi.offer(lo.poll());         // push lo's max to hi (balance)
        if (hi.size() > lo.size())   // lo must be >= hi in size
            lo.offer(hi.poll());
    }
    
    double getMedian() {
        return lo.size() > hi.size()
            ? lo.peek()
            : (lo.peek() + hi.peek()) / 2.0;
    }
    
    
    // ── Java PriorityQueue cheat-sheet ────────────────────────────────────────
    // new PriorityQueue<>()                    → min-heap (natural order)
    // new PriorityQueue<>(Collections.reverseOrder()) → max-heap
    // new PriorityQueue<>((a,b) -> a[1]-b[1]) → min-heap by second element
    // .offer(x)  — insert, O(log n)
    // .poll()    — remove & return root (min), O(log n)
    // .peek()    — read root without removing, O(1)
    // .size()    — count, O(1)import java.util.Collections;
import java.util.Map;

}