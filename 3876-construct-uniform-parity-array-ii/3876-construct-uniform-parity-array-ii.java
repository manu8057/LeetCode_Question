class Solution {
    public boolean uniformArray(int[] nums1) {
        int n=nums1.length;
        Arrays.sort(nums1);
        HashSet<Integer>od=new HashSet<>();
        HashSet<Integer>ev=new HashSet<>();
        boolean f=true;
        for(int i=0;i<n;i++){
            if(nums1[i]%2==0){
                if(od.size()==0){
                    f=false;
                    break;
                }
            }
            else{
                od.add(nums1[i]);
            }
        }
        if(f || od.size()==n){
            return true;
        }
        for(int i=0;i<n;i++){
            if(nums1[i]%2!=0){
                if(ev.size()==0){
                    f=false;
                    break;
                }
            }
            else{
                ev.add(nums1[i]);
            }
        }
        if(f || ev.size()==n) return true;
        return false;
    }
}