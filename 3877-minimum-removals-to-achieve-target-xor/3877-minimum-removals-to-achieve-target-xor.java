class Solution {
    HashMap<String,Integer>map=new HashMap<>();
    public int fun(int id,int n,int nums[],int tr,int sum){
        if(id==n){
            if(sum==tr){
                return 0;
            }
            else{
                return Integer.MAX_VALUE-100;
            }
        }
        if(map.containsKey(id+"#"+sum)){
            return map.get(id+"#"+sum);
        }
        int a=1+fun(id+1,n,nums,tr,sum);
        int b=fun(id+1,n,nums,tr,sum^nums[id]);
        int ans=Math.min(a,b);
        map.put(id+"#"+sum,ans);
        return ans;
    }
    public int minRemovals(int[] nums, int target) {
        int n=nums.length;
        int res=fun(0,n,nums,target,0);
        return (res>n)?-1:res;
    }
}