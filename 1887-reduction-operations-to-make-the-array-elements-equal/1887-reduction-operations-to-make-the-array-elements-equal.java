class Solution {
    public int reductionOperations(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int min=nums[0];
        int i=n-1;
        int ans=0;
        int z=0;
        int pre=-1;
        while(i>=0){
            int c=0;
            pre=nums[i];
            boolean f=false;
            while(i>=0 && nums[i]==pre){
                c+=1;
                f=true;
                i-=1;
            }
            if(i>=0){
                 z+=c;
                ans=ans+z;
            }
            if(!f) i--;
        }
        return ans;
    }
}