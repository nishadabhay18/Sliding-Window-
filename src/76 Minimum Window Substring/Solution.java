class Solution {
    // TC-> O(n) SC-> O(1)
    public HashMap<Character, Integer> makeFreq(String str){
        int n = str.length();
        HashMap<Character, Integer> mp = new HashMap<>();
        for(int i=0; i<n; i++){
            char ch = str.charAt(i);
            if(mp.containsKey(ch)) mp.put(ch, mp.get(ch) + 1);
            else mp.put(ch, 1);
        }
        return mp;
    }
    public String minWindow(String str, String txt) {
        int ns = str.length(), nt = txt.length();
        if(nt > ns) return "";
        HashMap<Character,Integer> mp = makeFreq(txt);
        String ans = "";
        int left = 0, right = 0, count = nt;
        while(right < ns){
            char ch = str.charAt(right);
            if(mp.containsKey(ch)){
                mp.put(ch, mp.get(ch) - 1);
                if(mp.get(ch) >= 0) count--;
            }
            while(count == 0){
                String sub = str.substring(left, right + 1);
                if(ans == "" || sub.length() < ans.length()) ans = sub;
                char dh = str.charAt(left);
                if(mp.containsKey(dh)){
                    mp.put(dh, mp.get(dh) + 1);
                    if(mp.get(dh) > 0) count++;
                }
                left++;
            }
            right++;
        }
        return ans;
    }
}