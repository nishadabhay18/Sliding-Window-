class Solution {
    // TC-> O(n) SC-> O(3)
    public int countGoodSubstrings(String str) {
        int n = str.length();
        HashMap<Character, Integer> mp = new HashMap<>();
        int left=0, right=0, count=0, k=3;
        while(right < n){
            char ch = str.charAt(right);
            if(mp.containsKey(ch)) mp.put(ch, mp.get(ch) + 1);
            else mp.put(ch, 1);
            if(right-left+1 > k){
                char dh = str.charAt(left++);
                mp.put(dh, mp.get(dh)-1);
                if(mp.get(dh) == 0) mp.remove(dh);
            }
            if(right-left+1 == k && mp.size() == k) count++;
            right++;
        }
        return count;
    }
}