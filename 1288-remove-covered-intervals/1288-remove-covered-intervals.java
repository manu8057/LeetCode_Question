class Solution {
    public int removeCoveredIntervals(int[][] arr) {
        Arrays.sort(arr,(a, b)->a[0]!=b[0]?Integer.compare(a[0], b[0]):Integer.compare(b[1],a[1]));
        int pre[]={arr[0][0],arr[0][1]};
        int ans=1;
        int n=arr.length;
        for(int i=1;i<n;i++){
            int a=arr[i][0];
            int b=arr[i][1];
            if(a>=pre[0] && b<=pre[1]){
                continue;
            }
            else{
                ans++;
                pre[0]=a;
                pre[1]=b;
            }
        }
        return ans;
    }
}