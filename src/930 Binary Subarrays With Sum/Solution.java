class Solution {
    // TC-> O(n) SC-> O(n)
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        for(int i=1; i<n; i++) nums[i] += nums[i-1];
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 0);
        int count = 0;
        for(int i=0; i<n; i++){
            int val = nums[i] - goal;
            if(nums[i] == goal) count++;
            if(mp.containsKey(val)) count += mp.get(val);
            if(mp.containsKey(nums[i])) mp.put(nums[i], mp.get(nums[i]) + 1);
            else mp.put(nums[i], 1);
        }
        return count;
    }

    // TC-> O(n) SC-> O(1)
    public int numSubarraysWithSum(int[] arr, int k){
        return helper(arr, k) - helper(arr, k-1);
    }
    public int helper(int[] arr, int k){
        if(k < 0) return 0;
        int n = arr.length;
        int sum = 0, count = 0, left = 0;
        for(int right = 0; right < n; right++){
            sum += arr[right];
            while(sum > k) sum -= arr[left++];
            count += right - left + 1;
        }
        return count;
    }
}