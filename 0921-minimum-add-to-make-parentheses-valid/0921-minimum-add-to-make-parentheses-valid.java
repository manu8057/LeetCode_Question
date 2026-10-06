class Solution {
    public int minAddToMakeValid(String str) {
    //    if(str.length()%2!=0) return false;
        Stack<Character> st = new Stack<>();
        for(char ch : str.toCharArray()) {       
                if(!st.isEmpty() && ((st.peek() == '(' && ch==')') ||
                    (st.peek() == '[' && ch == ']') ||
                    (st.peek() == '{' && ch == '}'))) {
                        st.pop();
                    } else {
                        st.push(ch);
                    }
         }
        return st.size();
    }
}