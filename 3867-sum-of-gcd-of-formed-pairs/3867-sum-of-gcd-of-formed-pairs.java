class Solution {
    public int gcd(int a,int b){
        while(b!=0){
            int tem=b;
            b=a%b;
            a=tem;
        }
        return a;
    }
    public long gcdSum(int[] nums) {
        int n=nums.length;
        int arr[]=new int[n];
        int max=nums[0];
        for(int i=0;i<n;i++){
            max=Math.max(nums[i],max);
            arr[i]=gcd(max,nums[i]);
        }
        Arrays.sort(arr);
        int l=0;
        int h=n-1;
        long sum=0;
        while(l<h){
            sum+=(long)gcd(arr[l],arr[h]);
            l++;
            h--;
        }
        return sum;
    }
}