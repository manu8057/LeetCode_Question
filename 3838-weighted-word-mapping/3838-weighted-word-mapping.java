class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb=new StringBuilder();
        HashMap<Integer,Character>map=new HashMap<>();
        int el=25;
        for(char i='a';i<='z';i++){
            map.put(el,i);
            el--;
        }
        for(String st:words){
            int wt=0;
            for(int i=0;i<st.length();i++){
                wt=(wt+(weights[st.charAt(i)-'a'])%26)%26;
            }
            sb.append(map.get(wt));
        }
        return sb.toString();
    }
}