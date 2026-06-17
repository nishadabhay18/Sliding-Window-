class Solution {
    // TC-> O(n) SC-> O(1)
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n=arr.length;
        int i = 0, j=k-1, sum=0, count=0;
        for(int x=0; x<=k-1; x++) sum + =arr[x];
        if((sum / k) >= threshold) count++;
        i++; j++;
        while(j < n){
            sum = sum - arr[i-1] + arr[j];
            if((sum/k) >= threshold) count++;
            i++; j++;
        }
        return count;
    }

    class Solution {
        // TC-> O(n) SC-> O(1)
        public int numOfSubarrays(int[] arr, int k, int threshold) {
            int n = arr.length;
            int left=0, count=0, sum=0;
            for(int right=0; right<n; right++){
                int ele = arr[right];
                sum += ele;
                if(right-left+1 > k) sum -= arr[left++];
                if(right-left+1 == k && sum >= k * threshold) count++;
            }
            return count;
        }
    }