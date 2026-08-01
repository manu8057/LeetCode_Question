class Solution {
    public boolean fun(int i,int j,int n,int nums[],int d,int turn){
        if(i>j){
            return d>=0;
        }
        if(turn==0){
            return fun(i+1,j,n,nums,d+nums[i],1) || fun(i,j-1,n,nums,d+nums[j],1);
        }
        else{
            return fun(i+1,j,n,nums,d-nums[i],0) && fun(i,j-1,n,nums,d-nums[j],0);
        }
    }
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        return fun(0,n-1,n,nums,0,0);
    }
}