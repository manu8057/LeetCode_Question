class Solution {
    public int passwordStrength(String password) {
        int n=password.length();
        int ans=0;
        HashSet<Character>set=new HashSet<>();
        for(int i=0;i<n;i++){
            char ch=password.charAt(i);
            if(ch>='a' && ch<='z' && !set.contains(ch)){
                ans+=1;
                set.add(ch);
            }
            else if(ch>='A' && ch<='Z' && !set.contains(ch)){
                ans+=2;
                set.add(ch);
            }
            else if(ch>='0' && ch<='9' && !set.contains(ch)){
                ans+=3;
                set.add(ch);
            }
            else if(!set.contains(ch)){
                ans+=5;
                set.add(ch);
            }
        }
        return ans;
    }
}