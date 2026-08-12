class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        ArrayDeque<Integer>q=new ArrayDeque<>();
        int ans[]=new int[n-k+1];
        int id=0;
        for(int i=0;i<n;i+=1){
            while(!q.isEmpty() && q.peekFirst()<=(i-k)){
                q.pollFirst();
            }
            while(!q.isEmpty() && nums[q.peekLast()]<nums[i]){
                q.pollLast();
            }
            q.addLast(i);
            if(i>=k-1) ans[id++]=nums[q.peekFirst()];
        }
        return ans;
    }
}