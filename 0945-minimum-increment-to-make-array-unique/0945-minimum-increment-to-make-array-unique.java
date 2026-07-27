class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int ans=0;
        HashSet<Integer>set=new HashSet<>();
        set.add(nums[0]);
        int max=nums[0];
        for(int i=1;i<n;i+=1){
            if(set.contains(nums[i])){
                ans=ans+max-nums[i]+1;
                nums[i]=max+1;
            }
            max=Math.max(nums[i],max);
            set.add(nums[i]);
        }
        return ans;
    }
}