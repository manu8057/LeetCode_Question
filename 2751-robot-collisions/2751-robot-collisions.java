class Solution {
    public List<Integer> survivedRobotsHealths(int[] pos, int[] h, String dir){
        int n=pos.length;
        int arr[][]=new int[n][4];
        for(int i=0;i<n;i++){
            arr[i][0]=i;
            arr[i][1]=pos[i];
            arr[i][2]=h[i];
            if(dir.charAt(i)=='R'){
                arr[i][3]=1;
            }
        }
        Arrays.sort(arr,(x,y)->x[1]-y[1]);
        Stack<int[]>st=new Stack<>();
        for(int i=0;i<n;i++){
            int ar[]=arr[i];
            if(ar[3]==1){
                st.push(ar);
            }
            else{
                while(!st.isEmpty() && st.peek()[3]==1){
                    if(h[st.peek()[0]]>h[ar[0]]){
                        h[ar[0]]=0;
                        h[st.peek()[0]]-=1;
                        break;
                    }
                    else if(h[st.peek()[0]] < h[ar[0]]){
                        h[st.peek()[0]]=0;
                        h[ar[0]]-=1;
                        st.pop();
                    }
                    else{
                        h[st.peek()[0]]=0;
                        h[ar[0]]=0;
                        st.pop();
                        break;
                    }
                }
                if(h[ar[0]]>0){
                    st.push(ar);
                }
            }
        }
        int res[]=new int[n];
        Arrays.fill(res,-1);
        while(!st.isEmpty()){
            int aap[]=st.pop();
            res[aap[0]] = h[aap[0]];
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(res[i]!=-1){
                ans.add(res[i]);
            }
        }
        return ans;
    }
}