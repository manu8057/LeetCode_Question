class Solution {
    class pair{
        char ch;
        int el;
        pair(char ch,int el){
            this.ch=ch;
            this.el=el;
        }
    }
    public int minimumPushes(String word) {
        int n=word.length();
        int fr[]=new int[26];
        for(int i=0;i<n;i+=1){
            fr[word.charAt(i)-'a']++;
        }
        PriorityQueue<pair>pq=new PriorityQueue<>((a,b)->b.el-a.el);
        for(int i=0;i<26;i+=1){
            pq.add(new pair((char)(i+'a'),fr[i]));
        }
        HashSet<Character>set=new HashSet<>();
        int c=0;
        int  y=1;
        HashMap<Character,Integer>m=new HashMap<>();
        while(!pq.isEmpty()){
            pair a=pq.poll();
            set.add(a.ch);
            if(set.size()>24){
                 y=4;
            }
            else if(set.size()>16){
                y=3;
            }
            else if(set.size()>8){
                y=2;
            }
            else{
                y=1;
            }
            m.put(a.ch,y);
        }
        int ans=0;
        for(int i=0;i<26;i+=1){
            char jk=(char)(i+'a');
            ans+=fr[i]*m.get(jk);
        }
        return ans;
    }
}