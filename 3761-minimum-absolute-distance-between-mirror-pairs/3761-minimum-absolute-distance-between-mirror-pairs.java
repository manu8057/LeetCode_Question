class Solution {
    public int rev(int el){
        int ans=0;
        while(el>0){
            int mod=el%10;
            ans=ans*10+mod;
            el/=10;
        }
        return ans;
    }
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer,Integer>map1=new HashMap<>();
        HashMap<Integer,Integer>map2=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            map1.put(nums[i],i);
        }
        for(int i=n-1;i>=0;i--){
            map2.put(nums[i],i);
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int el=nums[i];
            int f=rev(el);
            if(map1.containsKey(f) && map1.get(f)>i){
                ans=Math.min(ans,Math.abs(i-map1.get(f)));
            }
             if(map2.containsKey(f) && map2.get(f)>i){
                ans=Math.min(ans,Math.abs(i-map2.get(f)));
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}