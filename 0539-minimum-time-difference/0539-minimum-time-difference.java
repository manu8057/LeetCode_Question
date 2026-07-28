class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n=timePoints.size();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            String s[]=timePoints.get(i).split(":");
            int min=Integer.parseInt(s[0])*60+Integer.parseInt(s[1]);
            arr[i]=min;
        }
        Arrays.sort(arr);
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(i==0){
                int a=arr[n-1]-arr[i];
                int b=1440-arr[n-1]+arr[i];
                ans=Math.min(ans,Math.min(a,b));
            }
            else{
                int a=arr[i]-arr[i-1];
                int b=1440-arr[i]+arr[i-1];
                ans=Math.min(ans,Math.min(a,b));
            }
        }
        return ans;
    }
}