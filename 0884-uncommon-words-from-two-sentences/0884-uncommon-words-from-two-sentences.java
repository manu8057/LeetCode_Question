class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String,Integer>map1=new HashMap<>();
        HashMap<String,Integer>map2=new HashMap<>();
        String arr1[]=s1.split(" ");
        String arr2[]=s2.split(" ");
        for(String str1:arr1){
            map1.put(str1,map1.getOrDefault(str1,0)+1);
        }
        for(String str2:arr2){
            map2.put(str2,map2.getOrDefault(str2,0)+1);
        }
        ArrayList<String>l=new ArrayList<>();
        for(String k:map1.keySet()){
            if(map1.get(k)==1 && !map2.containsKey(k)){
                l.add(k);
            }
        }
        for(String k1:map2.keySet()){
            if(map2.get(k1)==1 && !map1.containsKey(k1)){
                l.add(k1);
            }
        }
        String ans[]=new String[l.size()];
        for(int i=0;i<l.size();i++){
            ans[i]=l.get(i);
        }
        return ans;
    }
}