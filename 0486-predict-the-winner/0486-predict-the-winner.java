class Solution {
    HashMap<String,Boolean>map=new HashMap<>();
    public boolean fun(int i,int n,int nums[],int d,int r,int t){
        if(i>r){
            return d>=0;
        }
        if(map.containsKey(i+"^"+d+"/"+r+"{"+t)){
            return map.get(i+"^"+d+"/"+r+"{"+t);
        }
        if(t==0){
            boolean ans=fun(i+1,n,nums,d+nums[i],r,1) || fun(i,n,nums,d+nums[r],r-1,1);
            map.put(i+"^"+d+"/"+r+"{"+t,ans);
            return ans;
        }
        else{
            boolean ans=fun(i+1,n,nums,d-nums[i],r,0) && fun(i,n,nums,d-nums[r],r-1,0);
            map.put(i+"^"+d+"/"+r+"{"+t,ans);
            return ans;
        }
    }
    public boolean predictTheWinner(int[] nums){
        int n=nums.length;
        return fun(0,nums.length,nums,0,nums.length-1,0);
    }
}