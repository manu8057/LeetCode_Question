class Solution {
    int arr[]=new int[]{2,3,5,7};
    int mx=7;
    public String smallestNumber(String num,long t){
        int cnt[]=new int[mx+1];
        int n=num.length();
        int len;
        int st=0;
        for(int el:arr){
            while(t%el==0){
                t/=el;
                cnt[el]+=1;
            }
        }
        if(t!=1) return "-1";
        len=find(cnt);
        if(n<len) return build(cnt,len,new char[len]);
        char ans[]=new char[n+1];
        for(int i=0;st<n && (ans[++i]=num.charAt(st))!='0';st+=1){
            add(cnt,ans[i],-1);
        }
        if(find(cnt)==0){
            if(st==n) return num;
            Arrays.fill(ans,++st,ans.length,'1');
            return new String(ans,1,n);
        }
        for(int last=n-1,end=Math.min(st,last);end>=0;end-=1){
            add(cnt,ans[end+1],1);
            while(++ans[end+1]<='9'){
                add(cnt,ans[end+1],-1);
                if(find(cnt)<=last-end) return build(cnt,last-end,ans);
                add(cnt,ans[end+1],1);
            }
        }
        return build(cnt,ans.length,ans);
    }
    void add(int cnt[],int ch,int val){
        if(ch<'2') return;
        if(ch=='9'){
            cnt[3]+=val*2;
        }
        else if(ch=='8'){
            cnt[2]+=val*3;
        }
        else if(ch=='6'){
            cnt[2]+=val;
            cnt[3]+=val;
        }
        else if(ch=='4'){
            cnt[2]+=val*2;
        }
        else{
            cnt[ch-'0']+=val;
        }
    }
    String build(int cnt[],int len,char ans[]){
        int id=ans.length;
        while(cnt[3]>1){
            cnt[3]-=2;
            ans[--id]='9';
        }
        while(cnt[2]>2){
            cnt[2]-=3;
            ans[--id]='8';
        }
        while(cnt[7]>0){
            cnt[7]-=1;
            ans[--id]='7';
        }
        if(cnt[2]>0 && cnt[3]>0){
            cnt[2]-=1;
            cnt[3]-=1;
            ans[--id]='6';
        }
        while(cnt[5]>0){
            cnt[5]-=1;
            ans[--id]='5';
        }
        while(cnt[2]>1){
            cnt[2]-=2;
            ans[--id]='4';
        }
        while(cnt[3]>0){
            cnt[3]-=1;
            ans[--id]='3';
        }
        while(cnt[2]>0){
            cnt[2]-=1;
            ans[--id]='2';
        }
        while(id+len!=ans.length){
            ans[--id]='1';
        }
        if(len==ans.length) return new String(ans);
        return new String(ans,1,ans.length-1);
    }
    int find(int cnt[]){
        int a=cnt[2];
        int b=cnt[3];
        if(a<0) a=0;
        if(b<0) b=0;
        int rem=(b&1)+(a%3);
        int ans=(b>>1)+(a/3);
        if(cnt[5]>0) ans+=cnt[5];
        if(cnt[7]>0) ans+=cnt[7];
        if(rem==3) ans+=2;
        else if(rem>0) ans+=1;
        return ans;
    }
}