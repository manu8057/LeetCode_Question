class Solution {
    public int maxDistToClosest(int[] seats) {
        int n=seats.length;
        int left[]=new int[n];
        int right[]=new int[n];
        int c=0;
        for(int i=0;i<n;i++){
            if(seats[i]==0){
                c++;
                left[i]=c;
            }
            else{
                c=0;
            }
        }
        c=0;
        for(int i=n-1;i>=0;i--){
            if(seats[i]==0){
                c++;
                right[i]=c;
            }
            else{
                c=0;
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            if(i==n-1 || i==0){
                max=Math.max(max,Math.max(left[i],right[i]));
            }
            else max=Math.max(max,Math.min(left[i],right[i]));
        }
        return max;
    }
}