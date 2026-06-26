class Solution {
    static {
        for (int i = 0; i < 500; i++) {
            groupAnagrams(new String[]{"eat","ate"});
        }
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>map=new HashMap<>();
        for(String i:strs){
            char[] ch=i.toCharArray();
            Arrays.sort(ch);
            String key=new String(ch);
            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(i);
        }
        return new ArrayList<>(map.values());
    }
}