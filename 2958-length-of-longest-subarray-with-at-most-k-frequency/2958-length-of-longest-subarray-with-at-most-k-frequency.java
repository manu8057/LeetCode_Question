class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        int ans=0;
        // int i=0;
        int j=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i+=1){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            while(j<i && map.get(nums[i])>k){
                map.put(nums[j],map.get(nums[j])-1);
                j+=1;
            }
            ans=Math.max(ans,i-j+1);
        }
        return ans;
    }
}