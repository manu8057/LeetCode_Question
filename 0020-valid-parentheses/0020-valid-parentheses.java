class Solution {
    public boolean isValid(String s) {
        Stack<Character>st=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i+=1){
            if(!st.isEmpty() && ((st.peek()=='(' && s.charAt(i)==')') || (st.peek()=='{' && s.charAt(i)=='}') || (st.peek()=='[' && s.charAt(i)==']'))){
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
        }
        return st.size()==0;
    }
}