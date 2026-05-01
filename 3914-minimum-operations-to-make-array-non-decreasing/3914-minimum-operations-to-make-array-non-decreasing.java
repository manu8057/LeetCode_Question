class Solution {
    public long minOperations(int[] nums) {
        int n=nums.length;
        long[] arr=new long[n];
        int max=nums[0];
        for(int i=0;i<n;i++){
            if(nums[i]<max){
                arr[i]=(long)max-nums[i];
            }else{
                max=nums[i];
                arr[i]=0;
            }
        }
        long ans=0;
        long prev=0;
        for(int i=0;i<n;i++){
            if(arr[i]>prev){
                ans+=(arr[i]-prev);
            }
            prev=arr[i];
        }
        return ans;
    }
}