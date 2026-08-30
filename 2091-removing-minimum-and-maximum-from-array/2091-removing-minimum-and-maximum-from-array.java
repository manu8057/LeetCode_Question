class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int id1=0;
        int id2=0;
        for(int i=0;i<n;i+=1){
            if(nums[i]>max){
                id2=i;
                max=nums[i];
            }
            if(nums[i]<min){
                id1=i;
                min=nums[i];
            }
        }
        int t1=Math.max(id1,id2)+1;
        int t2=n-Math.min(id1,id2);
        int t3=Math.min(id1,id2)+1+n-Math.max(id1,id2);
        return Math.min(t1,Math.min(t2,t3));
    }
}