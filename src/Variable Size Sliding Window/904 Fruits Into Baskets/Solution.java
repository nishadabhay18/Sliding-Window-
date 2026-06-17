class Solution {
    // TC-> O(n) SC-> O(1)
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int maxFruits = 0, k = 2, left = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int right=0; right<n; right++){
            int ele = fruits[right];
            if(!mp.containsKey(ele)) mp.put(ele, 1);
            else mp.put(ele, mp.get(ele) + 1);
            while(mp.size() > k){
                mp.put(fruits[left], mp.get(fruits[left]) - 1);
                if(mp.get(fruits[left]) == 0) mp.remove(fruits[left]);
                left++;
            }
            maxFruits = Math.max(maxFruits, right - left + 1);
        }
        return maxFruits;
    }
}