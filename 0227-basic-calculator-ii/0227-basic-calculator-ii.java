class Solution {
    public int calculate(String s) {
        Stack<Integer>st=new Stack<>();
        int num=0;
        char sg='+';
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                num=num*10+(ch-'0');
            }
            if((!Character.isDigit(ch) && ch!=' ') || i==s.length()-1){
                if(sg=='+'){
                    st.push(num);
                }
                else if(sg=='-'){
                    st.push(-num);
                }
                else if(sg == '*'){
                    st.push(st.pop()*num);
                }
                else if(sg == '/'){
                    st.push(st.pop()/num);
                }
                sg=ch;
                num=0;
            }
        }
        int ans=0;
        for(int x:st){
            ans+=x;
        }
        return ans;
    }
}