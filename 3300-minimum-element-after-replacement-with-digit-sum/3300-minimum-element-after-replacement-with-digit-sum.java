class Solution {
    public int minElement(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int el:nums){
            int s=0;
            while(el>0){
                s+=el%10;
                el/=10;
            }
            min=Math.min(s,min);
        }
        return min;
    }
}