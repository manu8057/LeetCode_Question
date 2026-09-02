class Solution {
    public boolean uniformArray(int[] nums1) {
        int n=nums1.length;
        boolean f1=true;
        for(int i=0;i<n;i++){
            boolean p=false;
            if(nums1[i]%2==0){
                continue;
            }
            for(int j=0;j<n;j++){
                if(i!=j){
                    if(Math.abs(nums1[i]-nums1[j])%2==0){
                        p=true;
                        break;
                    }
                }
            }
            if(!p){
                f1=false;
                break;
            }
        }
        if(f1){
            return true;
        }
        f1=true;
        for(int i=0;i<n;i++){
            boolean p=false;
            if(nums1[i]%2!=0){
                continue;
            }
            for(int j=0;j<n;j++){
                if(i!=j){
                    if(Math.abs(nums1[i]-nums1[j])%2!=0){
                        p=true;
                        break;
                    }
                }
            }
            if(!p){
                f1=false;
                break;
            }
        }
        if(f1){
            return true;
        }
        return false;
    }
}