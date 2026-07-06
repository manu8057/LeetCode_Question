class Solution {
    public int minimumDeletions(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            map.put(nums[i],i);
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
        }
        int a=Math.max(map.get(min),map.get(max))+1;
        int b=n-Math.min(map.get(min),map.get(max));
        int c=0;
        if(map.get(min)<map.get(max)){
            c+=map.get(min)+1;
            c+=n-map.get(max);
        }
        else{
            c+=map.get(max)+1;
            c+=n-map.get(min);
        }
        if(map.get(min)==map.get(max)) c-=1;
        return Math.min(a,Math.min(b,c));
    }
}