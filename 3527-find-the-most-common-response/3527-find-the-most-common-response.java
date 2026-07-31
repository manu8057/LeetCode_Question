class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        HashMap<String,Integer>map=new HashMap<>();
        int max=0;
        for(List<String>l:responses){
            HashSet<String>set=new HashSet<>();
            for(String a:l){
                if(!set.contains(a)){
                    map.put(a,map.getOrDefault(a,0)+1);
                    max=Math.max(max,map.get(a));
                    set.add(a);
                }
            }
        }
        String ans="zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        for(String str:map.keySet()){
            if(map.get(str)==max){
                if(str.compareTo(ans)<0){
                    ans=str;
                }
            }
        }
        return ans;
    }
}