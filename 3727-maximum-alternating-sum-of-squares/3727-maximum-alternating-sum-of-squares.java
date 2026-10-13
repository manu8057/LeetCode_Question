class Solution {
    public long maxAlternatingSum(int[] nums) {
        long ans=0;
        int n=nums.length;
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Math.abs(nums[i]);
        }
        Arrays.sort(arr);
        int l=0;
        int r=arr.length-1;
        while(l<=r){
            if(l==r){
                ans+=arr[l]*arr[l];
            }
            else{
                ans+=arr[r]*arr[r]-arr[l]*arr[l];
            }
            l++;
            r--;
        }
        return ans;
    }
}