class Solution {
    // TC-> O(2k) SC-> O(1)
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int lsum = 0, maxSum = 0;
        for(int i=0; i<k; i++){
            lsum += cardPoints[i];
            maxSum = lsum;
        }
        int rsum = 0, x = n-1;
        for(int j=k-1; j>=0; j--){
            lsum -= cardPoints[j];
            rsum += cardPoints[x--];
            maxSum = Math.max(lsum + rsum, maxSum);
        }
        return maxSum;
    }
}