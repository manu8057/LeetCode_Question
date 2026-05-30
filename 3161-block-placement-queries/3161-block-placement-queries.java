class Solution{
    int mx=50000;
    int[] seg;
    void up(int n,int l,int r,int i,int v){
        if(l==r){
            seg[n]=v;
            return;
        }
        int m=(l+r)/2;
        if(i<=m)
            up(n*2,l,m,i,v);
        else
            up(n*2+1,m+1,r,i,v);
        seg[n]=Math.max(seg[n*2],seg[n*2+1]);
    }

    int get(int n,int l,int r,int ql,int qr){
        if(ql>r||qr<l)
            return 0;
        if(ql<=l&&r<=qr)
            return seg[n];
        int m=(l+r)/2;
        return Math.max(
            get(n*2,l,m,ql,qr),
            get(n*2+1,m+1,r,ql,qr)
        );
    }

    public List<Boolean> getResults(int[][] q){
        seg=new int[4*(mx+1)];
        TreeSet<Integer> st=new TreeSet<>();
        st.add(0);
        for(int[] x:q){
            if(x[0]==1)
                st.add(x[1]);
        }
        List<Integer> p=new ArrayList<>(st);
        for(int i=1;i<p.size();i++)
            up(1,0,mx,p.get(i),p.get(i)-p.get(i-1));
        List<Boolean> ans=new ArrayList<>();
        for(int i=q.length-1;i>=0;i--){
            if(q[i][0]==2){
                int x=q[i][1];
                int s=q[i][2];
                int pre=st.floor(x);
                int b=get(1,0,mx,0,pre);
                b=Math.max(b,x-pre);
                ans.add(b>=s);
            }else{
                int x=q[i][1];
                Integer l=st.lower(x);
                Integer r=st.higher(x);
                up(1,0,mx,x,0);
                if(r!=null)
                    up(1,0,mx,r,r-l);
                st.remove(x);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}