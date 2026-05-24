class Solution {
    public int kDistinctChar(String str, int k) {
        int n = str.length();
        int maxLenString = 0, left = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        for(int right=0; right<n; right++){
            char ch = str.charAt(right);
            if(mp.containsKey(ch)) mp.put(ch, mp.get(ch) + 1);
            else mp.put(ch, 1);
            while(mp.size() > k){
                char dh = str.charAt(left);
                mp.put(dh, mp.get(dh) - 1);
                if(mp.get(dh) == 0) mp.remove(dh);
                left++;
            }
            maxLenString = Math.max(maxLenString, right - left + 1);
        }
        return maxLenString;
    }
}