class Solution {
    public void fun(int id,int n,int sum,int nums[],ArrayList<Integer>l){
        if(id==n){
            l.add(sum);
            return;
        }
        fun(id+1,n,sum+nums[id],nums,l);
        fun(id+1,n,sum,nums,l);
    }
    public int minAbsDifference(int[] nums, int goal) {
        int n=nums.length;
        ArrayList<Integer>l=new ArrayList<>();
        ArrayList<Integer>r=new ArrayList<>();
        fun(0,n/2,0,nums,l);
        fun(n/2,n,0,nums,r);
        Collections.sort(r);
        int ans=Integer.MAX_VALUE;
        for(int x:l){
            int tr=goal-x;
            int low=0;
            int high=r.size()-1;
            while(low<=high){
                int mid=(low+high)/2;
                ans=Math.min(ans,Math.abs(x+r.get(mid)-goal));
                if(r.get(mid)<=tr){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return ans;
    }
}