class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n=costs.length;
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i+=1){
            arr[i][0]=costs[i][0]-costs[i][1];
            arr[i][1]=i;
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        int sum=0;
        for(int i=0;i<n/2;i+=1){
            sum+=costs[arr[i][1]][0];
        }
        for(int i=n/2;i<n;i+=1){
            sum+=costs[arr[i][1]][1];
        }
        return sum;
    }
}