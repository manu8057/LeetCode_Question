class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        int arr1[]=new int[n];
        int arr2[]=new int[n];
        arr1[0]=nums[0];
        arr2[0]=nums[1];
        int id1=1;
        int id2=1;
        for(int i=2;i<n;i+=1){
            if(arr1[id1-1]>arr2[id2-1]){
                arr1[id1]=nums[i];
                id1+=1;
            }
            else{
                arr2[id2]=nums[i];
                id2+=1;
            }
        }
        int k=0;
        int ans[]=new int[n];
        while(k<n && arr1[k]!=0){
            ans[k]=arr1[k];
            k+=1;
        }
        for(int i=0;i<n;i+=1){
            if(arr2[i]==0) break;
            ans[k]=arr2[i];
            k+=1;
        }
        return ans;
    }
}