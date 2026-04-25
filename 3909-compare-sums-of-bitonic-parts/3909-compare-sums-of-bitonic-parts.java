class Solution {
    public int compareBitonicSums(int[] nums) {
        int n=nums.length;
        long sum1=nums[0];
        long sum2=nums[0];
        boolean f=true;
        boolean fl=false;
        for(int i=1;i<n;i++){
            if(nums[i]<=nums[i-1]  && !fl){
                sum2+=(long)nums[i];
                fl=true;
                f=false;
                continue;
            }
            if(f){
               sum1+=(long)nums[i];
               sum2=(long)nums[i];
            }
            else{
                sum2+=(long)nums[i];
            }
        }
        if(sum1==sum2) return -1;
        else if(sum2>sum1) return 1;
        else return 0;
    }
}