class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n=arr.length;
        PriorityQueue<double[]>pq=new PriorityQueue<>((a,b)->Double.compare(a[2],b[2]));
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                double x=(double)arr[i];
                double y=(double)arr[j];
                double z=(double)arr[i]/arr[j];
                pq.add(new double[]{x,y,z});
            }
        }
        k-=1;
        while(k>0){
            pq.poll();
            k--;
        }
        int ans[]=new int[2];
        double aap[]=pq.poll();
        ans[0]=(int)aap[0];
        ans[1]=(int)aap[1];
        return ans;
    }
}