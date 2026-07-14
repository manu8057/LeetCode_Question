class Solution {
    public int fun(int gap){
        if(gap<=1){
            return 0;
        }
        return (gap/2)+(gap%2);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int gap=fun(m+n);
        for(int i=0;i<n;i++){
            nums1[m+i]=nums2[i];
        }
        while(gap>0){
            int i=0;
            int j=i+gap;
            while(j<m+n){
                if(nums1[i]>nums1[j]){
                    int temp=nums1[i];
                    nums1[i]=nums1[j];
                    nums1[j]=temp;
                }
                i++;
                j++;
            }
            gap=fun(gap);
        }
    }
}