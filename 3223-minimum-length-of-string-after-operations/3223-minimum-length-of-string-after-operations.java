class Solution {
    public int minimumLength(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        int n=s.length();
        for(int i=0;i<n;i+=1){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int ans=0;
        for(Integer v:map.values()){
            if(v>=3){
                if(v%2==0){
                    ans+=2;
                }
                else ans+=1;
            }
            else{
                ans+=v;
            }
        }
        return ans;
    }
}