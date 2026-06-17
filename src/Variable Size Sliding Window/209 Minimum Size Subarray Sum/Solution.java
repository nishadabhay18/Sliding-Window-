class Solution {
    // TC-> O(n) SC-> O(n)
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> mp = new HashMap<>();
        int len = 0, min = Integer.MAX_VALUE, sum = 0;
        for(int i=0; i<n; i++){
            sum += nums[i];
            int ele = sum - target;
            if(ele < 0) mp.put(sum, i);
            else if(!mp.containsKey(ele)) mp.put(sum, i);
            else{
                len = i - mp.get(ele);
                if(min > len) min = len;
            }
        }
        return (min == Integer.MAX_VALUE) ? 0 : min;
    }

    // TC-> O(n) SC-> O(1)
    public int minSubArrayLen(int target, int[] nums){
        int n = nums.length;
        int left = 0, len = Integer.MAX_VALUE, sum = 0;
        for(int right=0; right<n; right++){
            sum += nums[right];
            while(sum >= target){
                len = Math.min(len, right - left + 1);
                sum -= nums[left++];
            }
        }
        return (len==Integer.MAX_VALUE) ? 0 : len;
    }
}