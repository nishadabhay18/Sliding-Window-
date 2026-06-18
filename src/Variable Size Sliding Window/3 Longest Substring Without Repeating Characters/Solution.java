class Solution {
    // TC-> O(n) SC-> O(n)
    public int lengthOfLongestSubstring(String str) {
        int n = str.length();
        int len = 0, maxLen = 0, left = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        for(int right=0; right<n; right++){
            char ch = str.charAt(right);
            if(!mp.containsKey(ch)) mp.put(ch, 1);
            else{
                while(ch != str.charAt(left)) mp.remove(str.charAt(left++));
                mp.remove(str.charAt(left++));
            }
            mp.put(ch, 1);
            maxLen = Math.max(maxLen, mp.size());
        }
        return maxLen;
    }
}
