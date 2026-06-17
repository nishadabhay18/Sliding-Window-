class Solution {
    // TC-> O(n) SC-> O(1)
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        int size = k*2+1;
        if(n < size) return ans;
        int left = 0, z = k;
        long sum = 0;
        for(int right=0; right<n; right++){
            sum += nums[right];
            if(right-left+1 > size) sum -= nums[left++];
            if(right-left+1 == size){
                int avg = (int)(sum / size);
                ans[z++] = avg;
            }
        }
        return ans;
    }
}