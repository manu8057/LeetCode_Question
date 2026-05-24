class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        int fr[]=new int[101];
        int n=nums.length;
        int c=0;
        for(int el:nums){
            fr[el]++;
            if(fr[el]>k){
                c++;
                fr[el]=k;
            }
        }
        int arr[]=new int[n-c];
        int id=0;
        for(int i=0;i<nums.length;i++){
            int y=nums[i];
            if(fr[y]>0){
                arr[id]=y;
                id++;
                fr[y]--;
            }
        }
        return arr;
    }
}