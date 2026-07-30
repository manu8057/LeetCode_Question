class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        int arr[]=new int[2*n];
        int one=0;
        for(int i=0;i<2*n;i+=1){
            arr[i]=nums[i%n];
            if(i<n && nums[i]==1) one++;
        }
        int ans=Integer.MAX_VALUE;
        int c=0;
        int len=one;
        for(int i=0;i<len;i+=1){
            if(arr[i]==0) c++;
        }
        ans=Math.min(c,ans);
        for(int i=len;i<2*n;i++){
            if(arr[i-len]==0){
                c-=1;
            }
            if(arr[i]==0){
                c+=1;
            }
            ans=Math.min(c,ans);
        }
        return ans;
    }
}