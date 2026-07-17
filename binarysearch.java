public class binarysearch {
    
    //Flavor 1 - Classic: find exact target
    int left=0, right=nums.length-1;
    while(left <= right) {
        int mid = left + (right-left)/2;
        if(nums[mid] == target)  return mid;
        else if(nums[mid] < target) left = mid+1;
        else right = mid-1;
    }

    return -1;

    //Flavor 2 - Boundary hunt: find first index where condition flips
    //find leftmost position where f(mid) is true
    int left=0, right = nums.length-1;
    int result = -1;
    while(left<=right) {
        int mid = left + (right-left)/2;
        if(condition(mid)) {
            result = mid;
            right = mid -1;
        } else {
            left = mid+1;
        }
    }
    return result;

    //Flavor 3 - Answer space search (Koko, ship packages)
    //Search in on VALUES, Not indices
    int left = minPossibleAnswer, right = maxPossibleAnswer;
    while(left<right) {
        int mid = left+(right-left)/2;
        if(feasible(mid)) {
            right = mid;
        } else {
            left = mid+1;
        }
    }

    return left;
}
