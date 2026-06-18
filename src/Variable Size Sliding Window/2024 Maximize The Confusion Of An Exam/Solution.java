class Solution {
    // TC-> O(n) SC-> O(1)
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int countT = 0, countF = 0;
        int left = 0, right = 0, max = 0;
        while(right < n){
            char ch = answerKey.charAt(right);
            if(ch == 'T') countT++;
            else countF++;
            while(Math.min(countT, countF) > k){
                char leftChar = answerKey.charAt(left);
                if(leftChar == 'T') countT--;
                else countF--;
                left++;
            }
            max = Math.max(right - left + 1, max);
            right++;
        }
        return max;
    }
}