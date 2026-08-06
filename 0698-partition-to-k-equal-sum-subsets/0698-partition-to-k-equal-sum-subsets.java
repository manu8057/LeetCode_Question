class Solution {
    int arr[];
    int target;
    public boolean fun(int id,int nums[],int k){
        if(id<0) return true;
        int val=nums[id];
        for(int i=0;i<k;i+=1){
            if(arr[i]+val>target) continue;
            arr[i]+=val;
            if(fun(id-1,nums,k)) return true;
            arr[i]-=val;
            if(arr[i]==0) break;
        }
        return false;
    }
    public boolean canPartitionKSubsets(int[] nums,int k){
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i+=1){
            sum+=nums[i];
        }
        if(sum%k!=0) return false;
        target=sum/k;
        Arrays.sort(nums);
        if(nums[n-1]>target) return false;
        arr=new int[k];
        return fun(n-1,nums,k);
    }
}