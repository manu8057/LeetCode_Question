class Solution {
    public int minimumRounds(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int el:nums){
            map.put(el,map.getOrDefault(el,0)+1);
        }
        int ans=0;
        for(Integer k:map.keySet()){
            int ml=map.get(k);
            if(ml%3==0){
                ans+=ml/3;
            }
            else{
                while(ml%3!=0 && ml>0){
                    ans+=1;
                    ml-=2;
                }
                if(ml%3!=0) return -1;
                ans+=ml/3;
            }
        }
        return ans;
    }
}