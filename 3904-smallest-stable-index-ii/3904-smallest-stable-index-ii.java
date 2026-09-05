class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        int min=Integer.MAX_VALUE;
        for(int el:nums){
            map.put(el,map.getOrDefault(el,0)+1);
            min=Math.min(el,min);
        }
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max=Math.max(nums[i],max);
            if(max - min <= k) return i;
            map.put(nums[i],map.get(nums[i]) - 1);
            if (map.get(min)<= 0) {
                min=Integer.MAX_VALUE;
                for(int key:map.keySet()) {
                    if(map.get(key)>0){
                        min=Math.min(min,key);
                    }
                }
            }
        }
        return -1;
    }
}