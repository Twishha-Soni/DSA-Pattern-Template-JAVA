public class MonotonicStack {

// MONOTONIC STACK — decreasing variant (for Next Greater Element)
// For Next Smaller: flip the comparison (stack top > nums[i])
// For Previous Greater: iterate right-to-left

int[] result = new int[n];
Arrays.fill(result, -1);          // default: no answer found

Deque<Integer> stack = new ArrayDeque<>();  // stores INDICES (almost always)

for (int i = 0; i < n; i++) {
    // While stack has candidates AND current element breaks the invariant:
    while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
        int idx = stack.pop();
        result[idx] = nums[i];    // nums[i] is the answer for idx
    }
    stack.push(i);                // current index is now waiting for its answer
}
// anything left in stack → result stays -1
return result;
}