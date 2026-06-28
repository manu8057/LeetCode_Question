class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        arr[0]=1;
        int max=arr[0];
        for(int i=1;i<n;i++){
            int el=arr[i];
            if(Math.abs(el-arr[i-1])>1){
                el=arr[i-1]+1;
            }
            arr[i]=el;
            max=Math.max(max,arr[i]);
        }
        return max;
    }
}