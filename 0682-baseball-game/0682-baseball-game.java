class Solution {
    public int calPoints(String[] operations) {
        int n=operations.length;
        int ans=0;
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            if(operations[i].equals("+")){
                int a1=st.pop();
                int b1=st.pop();
                st.push(b1);
                st.push(a1);
                st.push(a1+b1);
            }
            else if(operations[i].equals("C")){
                st.pop();
            }
            else if(operations[i].equals("D")){
                st.push(st.peek()*2);
            }
            else{
                st.push(Integer.parseInt(operations[i]));
            }
        }
        int sum=0;
        while(!st.isEmpty()){
            sum+=st.pop();
        }
        return sum;
    }
}