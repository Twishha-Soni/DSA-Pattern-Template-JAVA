pubic class twopointer{

    // falvor A: oppo ends(sorted array, sum problems)
    int left = 0, right = arr.length - 1;
    while(left<right) {
        int val = compute(arr[left], arr[right]);
        if(val == target) {
            //found answe
            left++; right--;  // or just return
        } else if(val<target)  {
            left++;
        } else {
            right--;
        }
    }


    //flavor B: same direction(read/write, fast/slow)
    int write = 0;
    for(int read=0; read<arr.length; read++) {
        if(shouldkeep(arr[read])) {
            arr[write++] = arr[read];
        }
    }
    //write in the new length
}