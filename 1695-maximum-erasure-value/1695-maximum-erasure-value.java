class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        int max=0;
        int sum=0;
        int j=0;
        for(int i=0;i<n;i+=1){
            sum+=nums[i];
            while(j<i && map.containsKey(nums[i])){
                sum-=nums[j];
                map.put(nums[j],map.get(nums[j])-1);
                if(map.get(nums[j])==0){
                    map.remove(nums[j]);
                }
                j+=1;
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            max=Math.max(sum,max);
        }
        return max;
    }
}