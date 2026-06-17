class Solution {
//    TC-> O(n) SC-> O(1)
    public int characterReplacement(String str, int k) {
        int n = str.length();
        int maxLen = 0, left = 0, maxCount = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        for(int right=0; right<n; right++){
            char ch = str.charAt(right);
            if(mp.containsKey(ch)) mp.put(ch, mp.get(ch) + 1);
            else mp.put(ch, 1);
            maxCount = Math.max(maxCount, mp.get(ch));
            while((right - left + 1) - maxCount > k){
                char dh = str.charAt(left);
                mp.put(dh, mp.get(dh) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}