class Solution {
    public int minOperations(List<Integer> nums, int k) {
        int c=0;
        int vis[]=new int[nums.size()+1];
        for(int i=nums.size()-1;i>=0;i-=1){
            if(nums.get(i)<=k && vis[nums.get(i)]==0){
                c++;
                vis[nums.get(i)]=1;
            }
            if(c==k){
                return nums.size()-i;
            }
        }
        return -1;
    }
}