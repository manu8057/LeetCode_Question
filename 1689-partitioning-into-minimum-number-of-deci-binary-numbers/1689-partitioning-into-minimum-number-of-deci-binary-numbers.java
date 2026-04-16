class Solution {
    public int minPartitions(String n) {
        char cnt='0';
        for(int i=0;i<n.length();i++){
            char ch=n.charAt(i);
            if(ch>cnt){
                cnt=ch;
            }
        }
        return cnt-'0';
    }
}