class Solution { 
    public String shortestBeautifulSubstring(String s, int k) { 
        PriorityQueue<String>pq=new PriorityQueue<>(); 
        int j=0; 
        int n=s.length(); 
        int c=0; 
        int min=n+1; 
        for(int i=0;i<n;i+=1){ 
            char ch=s.charAt(i); 
            if(ch=='1'){ 
                c++; 
            } 
            while(j<i && c>k){ 
                if(s.charAt(j)=='1'){ 
                    c--; 
                } 
                j++; 
            } 
            if(c==k){ 
                while(j<i && s.charAt(j)=='0'){ 
                    j++; 
                } 
                String str=s.substring(j,i+1); 
                if(str.length()<min){ 
                    min=str.length(); 
                    pq.clear(); 
                    pq.add(str); 
                } 
                else if(str.length()==min){ 
                    pq.add(str); 
                } 
            } 
        } 
        if(!pq.isEmpty()) return pq.peek(); 
        return ""; 
    } 
}