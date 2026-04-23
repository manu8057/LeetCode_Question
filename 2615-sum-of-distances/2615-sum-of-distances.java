class Solution {
    public long[] distance(int[] arr) {
        HashMap<Integer,Long>map2=new HashMap<>();
        HashMap<Integer,Integer>map1=new HashMap<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            map1.put(arr[i],map1.getOrDefault(arr[i],0)+1);
            map2.put(arr[i],map2.getOrDefault(arr[i],0L)+i);
        }
        HashMap<Integer,Long>ls=new HashMap<>();
        HashMap<Integer,Integer>lc=new HashMap<>();
        long r[]=new long[n];
        for(int i=0;i<n;i++){
            int v=arr[i];
            long s=ls.getOrDefault(v,0L);
            int c=lc.getOrDefault(v,0);
            long rs=map2.get(v)-s-i;
            int rc=map1.get(v)-c-1;
            long l=i*(long)c-s;
            long rr=rs-i*(long)rc;
            r[i]=l+rr;
            ls.put(v,s+i);
            lc.put(v,c+1);
        }
        return r;
    }
}