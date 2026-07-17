public class Solution {

    public static void slidingWindow(int[] nums) {
        int n = nums.length;

        // universal template

        //variable size window
        int left = 0, result = 0;
        // windowstate can be a map, int[], counter, sum, etc

        for(int right = 0; right < n; right++) {
            //1. expand: add nums[right] into window
            windowstate.add(nums[right]);

            //2. shrink: while window violates condition, move left
            while(windowIsValid()) {
                windowstate.remove(nums[left]);
                left++;
            }

            //3. update result: window is valid here
            result = Math.max(result, right - left + 1);
        }
        return result;




        //fixed size window(size = k)
        // build first window [0..k-1], then slide:
        for(int i=k; i<n; i++) {
            windowstate.add(nums[i]);
            windowstate.remove(nums[i-k]);
            result = Math.max(result, windowstate.value());
        }

    }

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}