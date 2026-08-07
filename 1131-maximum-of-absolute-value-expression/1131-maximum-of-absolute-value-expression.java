class Solution {
    public int maxAbsValExpr(int[] arr1,int[] arr2){
        int n=arr1.length;
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        int min3=Integer.MAX_VALUE;
        int min4=Integer.MAX_VALUE;
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int max3=Integer.MIN_VALUE;
        int max4=Integer.MIN_VALUE;
        for(int i=0;i<n;i+=1){
            int a=arr1[i]+arr2[i]+i;
            int b=arr1[i]+arr2[i]-i;
            int c=arr1[i]-arr2[i]+i;
            int d=arr1[i]-arr2[i]-i;
            max1=Math.max(max1,a);
            min1=Math.min(min1,a);
            max2=Math.max(max2,b);
            min2=Math.min(min2,b);
            max3=Math.max(max3,c);
            min3=Math.min(min3,c);
            max4=Math.max(max4,d);
            min4=Math.min(min4,d);
        }
        return Math.max(
            Math.max(max1-min1,max2-min2),
            Math.max(max3-min3,max4-min4)
        );
    }
}