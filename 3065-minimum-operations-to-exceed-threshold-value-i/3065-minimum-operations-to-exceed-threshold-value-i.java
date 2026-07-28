class Solution {
    public int minOperations(int[] nums, int k) {
        int c=0;
        for(int el:nums){
            if(el<k) c++;
        }
        return c;
    }
}