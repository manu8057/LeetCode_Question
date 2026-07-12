class Solution {
    public int find(int i,int pr[]){
        if(pr[i]==i){
            return i;
        }
        return pr[i]=find(pr[i],pr);
    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n=s.length();
        int pr[]=new int[n];
        int fr[]=new int[n];
        for(int i=0;i<n;i++){
            pr[i]=i;
            fr[i]=1;
        }
        for(List<Integer> l:pairs){
            int a=l.get(0);
            int b=l.get(1);
            int ab=find(a,pr);
            int bb=find(b,pr);
            if(ab!=bb){
                if(fr[ab]>fr[bb]){
                    pr[bb]=ab;
                    fr[ab]+=fr[bb];
                }
                else{
                    pr[ab]=bb;
                    fr[bb]+=fr[ab];
                }
            }
        }
        HashMap<Integer,PriorityQueue<Character>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int p=find(i,pr);
            map.putIfAbsent(p,new PriorityQueue<>());
            map.get(p).offer(s.charAt(i));
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            int p=find(i,pr);
            sb.append(map.get(p).poll());
        }
        return sb.toString();
    }
}