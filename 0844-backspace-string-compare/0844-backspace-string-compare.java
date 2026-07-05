class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character>st=new Stack<>();
        int n1=s.length();
        int n2=t.length();
        for(int i=0;i<n1;i++){
            if(!st.isEmpty() && s.charAt(i)=='#'){
                st.pop();
            }
            else if(s.charAt(i)!='#'){
                st.push(s.charAt(i));
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        for(int i=0;i<n2;i++){
            if(!st.isEmpty() && t.charAt(i)=='#'){
                st.pop();
            }
             else if(t.charAt(i)!='#'){
                st.push(t.charAt(i));
            }
        }
        StringBuilder sb1=new StringBuilder();
       
        // System.out.println(sb.toString());
        while(!st.isEmpty()){
            sb1.append(st.pop());
        }
        // System.out.println(sb1.toString());
        return sb1.toString().equals(sb.toString());
    }
}