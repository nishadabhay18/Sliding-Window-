class Solution {
    // Longest Subarray Sum With Distinct Elements
    // TC-> O(n) SC-> O(n)
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        int left = 0, sum = 0, maxSum = 0;
        for (int right = 0; right < n; right++) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                sum -= nums[left++];
            }
            set.add(nums[right]);
            sum += nums[right];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}