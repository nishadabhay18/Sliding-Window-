class Solution {
    // TC-> O(n) SC-> O(1)
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int left = 0, zero = 0, ones = 0;
        for(int right = 0; right<n; right++){
            if(nums[right] == 0) zero++;
            while(zero > 1){
                if(nums[left] == 0) zero--;
                left++;
            }
            ones = Math.max(ones, right - left + 1);
        }
        return ones-1;
    }
}