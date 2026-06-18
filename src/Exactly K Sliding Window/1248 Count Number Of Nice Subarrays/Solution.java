class Solution {
    // TC-> O(n) SC-> O(n)
    public int numberOfSubarrays(int[] nums, int k) {
        int n=nums.length;
        for(int i=0; i<n; i++){
            if(nums[i]%2 == 0) nums[i]=0;
        }
        for(int i=1; i<n; i++) nums[i] += nums[i-1];
        HashMap<Integer, Integer> mp=new HashMap<>();
        mp.put(0, 0);
        int count = 0;
        for(int i=0; i<n; i++){
            int val = nums[i] - k;
            if(nums[i] == k) count++;
            if(mp.containsKey(val)) count += mp.get(val);
            if(mp.containsKey(nums[i])) mp.put(nums[i], mp.get(nums[i]) + 1);
            else mp.put(nums[i], 1);
        }
        return count;
    }

    // TC-> O(n) SC-> O(n) recursion space
    public int numberOfSubarrays(int[] arr, int k){
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0) arr[i]=0;
        }
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