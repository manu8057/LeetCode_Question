class Solution {
    public boolean fun(String str,String s,String sp){
        int j=s.length();
        int n1=sp.length();
        int n=str.length();
        for(int i=0;i<n;i+=j){
            if(!s.equals(str.substring(i,i+j))){
                return false;
            }
        }
        for(int i=0;i<n1;i+=j){
            if(!s.equals(sp.substring(i,i+j))){
                return false;
            }
        }
        return true;
    }
    public String gcdOfStrings(String str1, String str2) {
        int n1=str1.length();
        int n2=str2.length();
        if(n2<n1){
            for(int i=0;i<n2;i++){
                String s=str2.substring(0,n2-i);
                if(str1.length()%s.length()==0 && str2.length()%s.length()==0 && fun(str1,s,str2)){
                    return s;
                }
            }
        }
        else{
            for(int i=0;i<n1;i++){
                String s=str1.substring(0,n1-i);
                if(str2.length()%s.length()==0 && str1.length()%s.length()==0 && fun(str2,s,str1)){
                    return s;
                }
            }

        }
        return "";
    }
}