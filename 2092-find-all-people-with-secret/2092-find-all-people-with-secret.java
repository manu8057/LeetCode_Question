class Solution {
    public int find(int i,int pr[]){
        if(pr[i]==i) return i;
        return pr[i]=find(pr[i],pr);
    }
    public List<Integer> findAllPeople(int n, int[][] meetings, int z) {
        List<Integer>res=new ArrayList<>();
        int pr[]=new int[n];
        int fr[]=new int[n];
        for(int i=0;i<n;i++){
            pr[i]=i;
            fr[i]=1;
        }
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        HashSet<Integer>set=new HashSet<>();
        for(int ar[]:meetings){
            pq.add(new int[]{ar[0],ar[1],ar[2]});
        }
        set.add(0);
        set.add(z);
        fr[z]+=fr[0];
        pr[0]=pr[z];
        while(!pq.isEmpty()){
            ArrayList<int[]>l=new ArrayList<>();
            int pre=-1;
            while(!pq.isEmpty() && (pre==-1 || pre==pq.peek()[2])){
                int aap[]=pq.poll();
                l.add(new int[]{aap[0],aap[1]});
                pre=aap[2];
            }
            boolean ch=true;
            while(ch){
                ch=false;
                for(int ap[]:l){
                    if(set.contains(ap[0]) || set.contains(ap[1])){
                        if(!set.contains(ap[0]) || !set.contains(ap[1])){
                            ch=true;
                        }
                        set.add(ap[0]);
                        set.add(ap[1]);
                    }
                }
            }
            for(int ap[]:l){
                if((set.contains(ap[0]) && set.contains(ap[1]))){
                    int el1=ap[0];
                    int el2=ap[1];
                    int u=find(el1,pr);
                    int v=find(el2,pr);
                    if(u!=v){
                        if(fr[u]>fr[v]){
                            pr[v]=pr[u];
                            fr[u]+=fr[v];
                        }
                        else{
                            pr[u]=pr[v];
                            fr[v]+=fr[u];
                        }
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            if(find(z,pr)==find(i,pr)){
                res.add(i);
            }
        }
        return res;
    }
}