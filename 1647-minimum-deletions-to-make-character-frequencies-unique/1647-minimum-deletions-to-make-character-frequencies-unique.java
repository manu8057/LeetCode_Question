class Solution {
    public int minDeletions(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int sz=map.size();
        ArrayList<Integer>l=new ArrayList<>();
        HashSet<Integer>set=new HashSet<>();
        for(Character ch:map.keySet()){
             if(set.contains(map.get(ch))){
                l.add(map.get(ch));
             }
             set.add(map.get(ch));
        }
        int ans=0;
        for(int el:l){
           int c=el;
           while(set.contains(el)){
              el--;
           } 
           if(el==0){
               ans+=c;
           }
           else{
                ans=ans+c-el;
                set.add(el);
           }
        }
        return ans;
    }
}