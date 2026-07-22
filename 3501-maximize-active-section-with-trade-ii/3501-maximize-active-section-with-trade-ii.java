class SparseTable{
    int sp[][];
    SparseTable(int[] a){
        int n=a.length;
        sp=new int[21][n];
        for(int i=0;i<n;i++){
            sp[0][i]=a[i];
        }
        for(int b=1;b<=20;b++){
            for(int i=0;i<n;i++){
                int p2=1<<(b-1);
                if(i+p2<n){
                    sp[b][i]=Math.max(sp[b-1][i],sp[b-1][i+p2]);
                }else sp[b][i]=sp[b-1][i];
            }
        }
    }
    int q(int l,int r){
        if(l>r)return 0;
        int b=0;
        for(;b<=20;b++){
            if((1<<b)>r-l+1){
                break;
            }
        }
        b--;
        if(b<0)return 0;
        return Math.max(sp[b][l],sp[b][r-(1<<b)+1]);
    }
}

class SegmentTree{
    private int n;
    private int a[];
    private int s[];
    SegmentTree(int[] nm){
        n=nm.length;
        s=new int[4*n];
        a=nm;
        b(1,0,n-1);
    }
    private void b(int nd,int l,int r){
        if(l==r){
            s[nd]=a[l];
            return;
        }
        int m=(l+r)>>1;
        b(2*nd,l,m);
        b(2*nd+1,m+1,r);
        s[nd]=Math.max(s[2*nd],s[2*nd+1]);
    }
    int iq(int nd,int st,int en,int l,int r){
        if(l<=st&&en<=r){
            return s[nd];
        }
        int m=(st+en)>>1;
        int res=0;
        if(m>=l){
            res=Math.max(res,iq(nd*2,st,m,l,r));
        }
        if(r>m){
            res=Math.max(res,iq(nd*2+1,m+1,en,l,r));
        }
        return res;
    }
    int q(int l,int r){
        if(l>r)return 0;
        return iq(1,0,n-1,l,r);
    }
}

class Solution{
    int sz=0;
    public List<Integer> maxActiveSectionsAfterTrade(String s,int[][] q){
        int n=s.length();
        int c1=0;
        for(char c:s.toCharArray()){
            if(c=='1')c1++;
        }
        List<Integer> zb=new ArrayList<>();
        List<Integer> zl=new ArrayList<>();
        List<Integer> zr=new ArrayList<>();
        int i=0;
        while(i<n){
            int r=i;
            while(r<n&&s.charAt(i)==s.charAt(r)){
                r++;
            }
            int cbl=r-i;
            if(s.charAt(i)=='0'){
                zb.add(cbl);
                zl.add(i);
                zr.add(r-1);
            }
            i=r;
        }
        int m=zb.size();
        sz=m;
        List<Integer> res=new ArrayList<>();
        if(m<=1){
            for(int j=0;j<q.length;j++)res.add(c1);
            return res;
        }
        int nm[]=new int[m-1];
        for(int bl=0;bl<m-1;bl++){
            nm[bl]=zb.get(bl)+zb.get(bl+1);
        }
        SegmentTree sp=new SegmentTree(nm);
        for(int j=0;j<q.length;j++){
            int l=q[j][0],r=q[j][1];
            int li=lb(zr,l);
            int ri=ub(zl,r)-1;
            if(li>m-1||ri<0||li>=ri){
                res.add(c1);
                continue;
            }
            int ll=zr.get(li)-Math.max(zl.get(li),l)+1;
            int rl=Math.min(r,zr.get(ri))-zl.get(ri)+1;
            if(li+1==ri){
                int c=ll+rl;
                res.add(c1+c);
                continue;
            }
            int lc=ll+zb.get(li+1);
            int rc=rl+zb.get(ri-1);
            int mc=sp.q(li+1,ri-2);
            res.add(c1+Math.max(lc,Math.max(rc,mc)));
        }
        return res;
    }
    public int lb(List<Integer> zr,int l){
        int lf=0;
        int rt=sz;
        while(lf<rt){
            int m=(lf+rt)>>1;
            if(zr.get(m)>=l){
                rt=m;
            }else lf=m+1;
        }
        return lf;
    }
    public int ub(List<Integer> zl,int r){
        int lf=0,rt=sz;
        while(lf<rt){
            int m=(lf+rt)>>1;
            if(zl.get(m)<=r){
                lf=m+1;
            }else rt=m;
        }
        return lf;
    }
}