class Solution {
    public Boolean fun(String s,String str){
        int n=s.length();
        int n2=str.length();
        int i=0;
        int j=0;
        while(j<n2){
            if(i<n && s.charAt(i)==str.charAt(j)){
                i++;
                j++;
            }
            else{
                if(str.charAt(j)>='A' && str.charAt(j)<='Z'){
                    return false;
                }
                j++;
            }
        }
        if(i!=n){
            return false;
        }
        return true;
    }
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean>l=new ArrayList<>();
        for(String s:queries){
            boolean a=fun(pattern,s);
            l.add(a);
        }
        return l;
    }
}