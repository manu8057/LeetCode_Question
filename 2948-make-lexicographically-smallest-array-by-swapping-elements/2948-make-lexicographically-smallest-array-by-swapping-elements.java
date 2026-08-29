class Solution {
    public void fun(int nums[],int r,int c){
        int tem=nums[r];
        nums[r]=nums[c];
        nums[c]=tem;
    }
    public int[] lexicographicallySmallestArray(int[] nums,int limit) {
        int n=nums.length;
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i+=1){
            arr[i][0]=nums[i];
            arr[i][1]=i;
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        int i=0;
        while(i<n){
            int j=i+1;
            while(j<n && arr[j][0]-arr[j-1][0]<=limit){
                j+=1;
            }
            int temp[]=new int[j-i];
            int k=0;
            for(int x=i;x<j;x+=1){
                temp[k]=arr[x][1];
                k+=1;
            }
            Arrays.sort(temp);
            for(int x=0;x<temp.length;x+=1){
                nums[temp[x]]=arr[i+x][0];
            }
            i=j;
        }
        return nums;
    }
}