class Solution {
    public int missingMultiple(int[] nums, int k) {
        int fr[]=new int[101];
        for(int el:nums){
            fr[el]++;
        }
        int c=1;
        while(c*k<101 && fr[c*k]!=0){
            c++;
        }
        return c*k;
    }
}