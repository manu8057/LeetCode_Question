class Solution {
    public boolean rotateString(String s, String goal) {
        if(goal.length()!=s.length()) return false;
        for(int i=0;i<s.length();i++){
            if((goal.substring(i+1)+goal.substring(0,i+1)).equals(s)){
                return true;
            }
        }
        return false;
    }
}