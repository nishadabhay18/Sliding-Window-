class Solution {
    // TC-> O(n) SC-> O(1)
    public int numberOfSubstrings(String str) {
        int n = str.length();
        int count = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        mp.put('a', -1);
        mp.put('b', -1);
        mp.put('c', -1);
        for(int i = 0; i < n; i++){
            char ch = str.charAt(i);
            mp.put(ch, i);
            int minIndex = Math.min(mp.get('a'), Math.min(mp.get('b'), mp.get('c')));
            if(minIndex != -1) count += minIndex + 1;
        }
        return count;
    }
}