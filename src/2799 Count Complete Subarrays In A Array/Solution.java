class Solution {
    // TC-> O(n) SC-> O(n)
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++) set.add(nums[i]);
        int k = set.size();
        int count = 0, l = 0, r = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        while(r < n){
            int val = nums[r];
            if(!mp.containsKey(val)) mp.put(val, 1);
            else mp.put(val, mp.get(val) + 1);
            while(mp.size() == k){
                count += n - r;
                mp.put(nums[l], mp.get(nums[l]) - 1);
                if(mp.get(nums[l]) == 0) mp.remove(nums[l]);
                l++;
            }
            r++;
        }
        return count;
    }
}