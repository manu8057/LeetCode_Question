class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        boolean f=false;
        HashSet<Integer>set=new HashSet<>();
       for(int i:nums){
           map.put(i,map.getOrDefault(i,0)+1);
       }
        for(Integer i:map.keySet()){
            if(map.get(i)>=3){
                set.add(i);
                f=true; 
            }
        }
        if(!f){
            return -1;
        }
        int min=Integer.MAX_VALUE;
        for(int i:set){
            ArrayList<Integer>pq=new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                if(i==nums[j]){
                    pq.add(j);
                }
            }
            int ans=Integer.MAX_VALUE;
            for(int l=0;l<pq.size()-2;l++){
                int a=pq.get(l);
                int b=pq.get(l+1);
                int c=pq.get(l+2);
                ans=Math.min(ans,Math.abs(a-b)+Math.abs(b-c)+Math.abs(c-a));
            }
            min=Math.min(min,ans);
        }
        return min;
    }
}