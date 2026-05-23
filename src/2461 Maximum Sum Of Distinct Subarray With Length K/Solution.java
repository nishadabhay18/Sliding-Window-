class Solution {
    // TC-> O(n) SC-> O(k)
    public long maximumSubarraySum(int[] nums, int k) {
        int n=nums.length;
        long maxSum = 0, sum = 0;
        int left = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int right = 0; right<n; right++){
            while(set.contains(nums[right])){
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
            sum += nums[right];
            set.add(nums[right]);
            if(right - left + 1 > k){
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
            if(right - left + 1 == k) maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}