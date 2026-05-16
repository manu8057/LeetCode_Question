class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        ArrayList<Integer>l=new ArrayList<>();
        l.add(nums[0]);
        for(int i=1;i<n;i++){
            if(nums[i]!=nums[i-1]){
                l.add(nums[i]);
            }
        }
        int lm=0;
        int r=l.size()-1;
        int ans=5001;
        while(lm<=r){
           int mid=lm+(r-lm)/2;
           if(l.get(mid)<=ans && l.get(mid)<=l.get(l.size()-1)){
             ans=l.get(mid);
             r=mid-1;
           } 
           else if(l.get(mid)<=ans && l.get(mid)>l.get(l.size()-1)){
               ans=l.get(mid);
               lm=mid+1;
           }
           else{
            lm=mid+1;
           }
        }
        return ans;
    }
}