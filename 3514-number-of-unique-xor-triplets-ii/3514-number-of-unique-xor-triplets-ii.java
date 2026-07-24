class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int m=2048;
        boolean p[]=new boolean[m];
        boolean t[]=new boolean[m];
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                p[nums[i]^nums[j]]=true;
            }
        }
        for(int i=0;i<m;i++){
            if(p[i]){
                for(int j=0;j<n;j++){
                    t[i^nums[j]]=true;
                }
            }
        }
        int c=0;
        for(int i=0;i<m;i++){
            if(t[i]){
                c++;
            }
        }
        return c;
    }
}