class Solution {
    public boolean rotateString(String s, String goal) {
        return ((s+s).contains(goal)==true)?true:false;
    }
}