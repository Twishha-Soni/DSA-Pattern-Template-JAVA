import java.util.*;

public class hashing {
    

    // SHAPE A: Value/index lookup (two sum family)
    Map<Integer, Integer> map = new HashMap<>();

    //Seed with identity element if needed
    //map.put(0,-1) - for prefix sum problems

    for(int i=0; i<nums.length; i++) {
        int complement = target - nums[i]; // or: current - k , current%k, etc;

        if(map.containsKey(complement)) {
            //Found - use map.get(complement) for index/count
        }

        //Store after checking (avoids using same element twice)
        //Store first occurence for "longest subarray" problems
        map.put(nums[i],  i);
    }



    // SHAPE B : Grouping by canonical key(ANAGRAM Family)
   Map<String, List<...>> map = new HashMap<>();

    for (each element) {
        String key = canonicalize(element);  // sort chars, count freq, etc.
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(element);
    }

    return new ArrayList<>(map.values());


    

    // PREFIX SUM SETUP
    //build the prefix sum array
    int[] prefix  = new int[n+1]; //prefix[0] = 0 is the identity

    for(int i=0; i<n; i++) {
    prefix[i+1] = prefix[i] + nums[i];
    }

    //subarray sum[i..j] = prefix[j+1] - prefix[i]

    //OR Inline with HashMap - mmore common in interviews
    Map<Integer, Integer> seen = new HashMap<>();
    seen.put(0,1); //empty prefix has sum 0, seen once
    int runningSum = 0;
    for(int num: nums) {
    runningSum += num;
    //check map for (runningSm -k) , then store runningSum
    }

}

