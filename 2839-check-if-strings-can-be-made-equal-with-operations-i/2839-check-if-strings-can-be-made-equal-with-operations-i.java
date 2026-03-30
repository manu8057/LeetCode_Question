class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if(s1.equals(s2)){
            return true;
        }
        HashSet<Character>ev=new HashSet<>();
        HashSet<Character>od=new HashSet<>();
        for(int i=0;i<4;i++){
            if(i%2==0){
                ev.add(s2.charAt(i));
            }
            else{
                od.add(s2.charAt(i));
            }
        }
        for(int i=0;i<4;i++){
            if(i%2==0){
                if(!ev.contains(s1.charAt(i))){
                    return false;
                }
            }
            else{
                if(!od.contains(s1.charAt(i))){
                    return false;
                }
            }
        }
        return true;
    }
}