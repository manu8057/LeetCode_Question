class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int ans=0;
        int arr[]=new int[flowerbed.length+2];
        arr[0]=0;
        arr[arr.length-1]=0;
        for(int i=0;i<flowerbed.length;i++){
            arr[i+1]=flowerbed[i];
        }
        for(int i=1;i<arr.length-1;i++){
            if(arr[i]==0 && arr[i-1]==0 && arr[i+1]==0){
                arr[i]=1;
                ans++;
            }
            if(ans>=n) return true;
        }
        return ans>=n;
    }
}