class Solution {
    public int scoreOfParentheses(String s) {
        int ans=0;
        int n=s.length();
        Stack<Character>st=new Stack<>();
        boolean f=true;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(!st.isEmpty() && st.peek()=='(' && ch==')'){
                st.pop();
                if(!f){
                    ans+=Math.pow(2,st.size());
                    f=true;
                }
            }
            else{
                f=false;
                st.push(ch);
            }
        }
        return ans;
    }
}