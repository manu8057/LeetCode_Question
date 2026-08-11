class Solution {
    public int missingInteger(int[] nums) {
        int n=nums.length;
        int fr[]=new int[51];
        for(int el:nums){
            fr[el]+=1;
        }
        int s=nums[0];
        for(int i=1;i<n;i+=1){
            if(nums[i]==(nums[i-1]+1)){
                s+=nums[i];
            }
            else{
                break;
            }
        }
        while(true){
            if(s>=51) return s;
            if(fr[s]==0) return s;
            s+=1;
        }
    }
}