class Solution {
    // TC-> O(n) SC-> O(1).
    int search(String pat, String txt) {
        int np = pat.length(), nt = txt.length();
        if(np > nt) return 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        for(int i=0; i<np; i++){
            char ch = pat.charAt(i);
            if(mp.containsKey(ch)) mp.put(ch, mp.get(ch) + 1);
            else mp.put(ch, 1);
        }
        int left = 0, right = 0, count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(right < nt){
            char ch = txt.charAt(right);
            if(map.containsKey(ch)) map.put(ch, map.get(ch) + 1);
            else map.put(ch, 1);
            if(right - left + 1 > np){
                char dh = txt.charAt(left);
                map.put(dh, map.get(dh) - 1);
                if(map.get(dh) == 0) map.remove(dh);
                left++;
            }
            if(map.equals(mp)) count++;
            right++;
        }
        return count;
    }
}
