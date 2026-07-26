class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer>l=new ArrayList<>();
        HashMap<Character,Integer>map=new HashMap<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            map.put(ch,i);
        }
        int max=0;
        int pre=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            max=Math.max(max,map.get(ch));
            if(i==max){
                l.add(i-pre+1);
                pre=i+1;
            }
        }
        return l;
    }
}