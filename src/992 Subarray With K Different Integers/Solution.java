class Solution {
    // TC-> O(n) SC-> O(n)
    public int helper(int[] nums, int k){
        int n = nums.length;
        int count = 0, left = 0, right = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        while(right < n){
            if(!mp.containsKey(nums[right])) mp.put(nums[right], 1);
            else mp.put(nums[right], mp.get(nums[right]) + 1);
            while(mp.size() > k){
                mp.put(nums[left], mp.get(nums[left]) - 1);
                if(mp.get(nums[left]) == 0) mp.remove(nums[left]);
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
    }
}