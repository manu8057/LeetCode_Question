class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n=nums.length;
        int j=0;
        HashSet<Integer>set=new HashSet<>();
        int sum=0;
        int max=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            while(j<n && set.contains(nums[i])){
                sum-=nums[j];
                set.remove(nums[j]);
                j++;
            }
            set.add(nums[i]);
            max=Math.max(max,sum);
        }
        return max;
    }
}