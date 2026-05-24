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

    // TC-> O(n) SC-> O(1)
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0, count = 0;
        int target = k * threshold;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            if(i >= k) sum -= arr[i - k];
            if(i >= k - 1 && sum >= target) count++;
        }
        return count;
    }