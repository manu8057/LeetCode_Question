class Solution {
    public int minCost(String colors, int[] arr) {
        ArrayDeque<Integer>q=new ArrayDeque<>();
        int n=colors.length();
        int ans=0;
        for(int i=0;i<n;i+=1){
            char ch=colors.charAt(i);
            if(!q.isEmpty() && colors.charAt(q.peekLast())==ch){
                if(arr[q.peekLast()]<=arr[i]){
                    ans+=arr[q.peekLast()];
                    q.pollLast();
                    q.addLast(i);
                }
                else{
                    ans+=arr[i];
                }
            }
            else q.addLast(i);
        }
        return ans;
    }
}