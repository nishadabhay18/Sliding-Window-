class Solution {
    // TC-> O(n) SC-> O(1)
    public int longestOnes(int[] arr, int k){
        int n = arr.length;
        int left=0, ans=0, window=0;
        for(int right=0; right<n; right++){
            window += arr[right];
            while(window + k < right-left+1)  window -= arr[left++];
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}