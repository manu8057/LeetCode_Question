class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n=arr.length;
        int pre[]=new int[n];
        pre[0]=arr[0];
        for(int i=1;i<n;i+=1){
            pre[i]=pre[i-1]^arr[i];
        }
        int m=queries.length;
        int ans[]=new int[m];
        int id=0;
        for(int q[]:queries){
            if(q[0]==0){
                ans[id++]=pre[q[1]];
            }else{
                ans[id++]=pre[q[1]]^pre[q[0]-1];
            }
        }
        return ans;
    }
}