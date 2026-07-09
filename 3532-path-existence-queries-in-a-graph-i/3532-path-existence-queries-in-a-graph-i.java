class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int arr[]=new int[n];
        for(int i=1;i<n;i++){
            arr[i]=arr[i-1];
            if(nums[i]-nums[i-1]>maxDiff){
                arr[i]++;
            }
        }
        boolean ans[]=new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
            int l=queries[i][0];
            int h=queries[i][1];
            ans[i]=arr[l]==arr[h];
        }
        return ans;
    }
}