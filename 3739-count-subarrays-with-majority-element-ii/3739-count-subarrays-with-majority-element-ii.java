class Solution {
    public long countMajoritySubarrays(int[] nums,int target){
        int n=nums.length;
        int fr[]=new int[2*n+2];
        long ans=0;
        int currSum=0;
        int countLess=0;
        fr[n]=1;
        for(int i=0;i<n;i++){
            int nextSum=currSum+(nums[i]==target?1:-1);
            if(nextSum>currSum){
                countLess+=fr[currSum+n];
            }else{
                countLess-=fr[nextSum+n];
            }
            ans+=countLess;
            currSum=nextSum;
            fr[currSum+n]++;
        }
        return ans;
    }
}