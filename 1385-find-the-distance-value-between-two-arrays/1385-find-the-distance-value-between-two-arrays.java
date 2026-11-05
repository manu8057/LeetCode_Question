class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans=0;
        for(int i=0;i<arr1.length;i+=1){
            boolean f=false;
            for(int j=0;j<arr2.length;j+=1){
                if(Math.abs(arr1[i]-arr2[j])<=d){
                    f=true;
                    break;
                }
            }
            if(!f) ans+=1;
        }
        return ans;
    }
}