class Solution {
    public int minOperations(int n) {
        int arr[]=new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            arr[i]=2*i+1;
            sum+=arr[i];
        }
        int tr=sum/n;
        int l=0;
        int h=n-1;
        int ans=0;
        while(l<h){
            ans=ans+(arr[h]-arr[l])/2;
            l++;
            h--;
        }
        return ans;
    }
}