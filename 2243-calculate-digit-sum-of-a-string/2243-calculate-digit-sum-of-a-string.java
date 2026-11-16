class Solution {
    public String digitSum(String s, int k) {
        int n=s.length();
        StringBuilder sb=new StringBuilder(s);
        while(sb.length()>k){
            StringBuilder s1=new StringBuilder();
            int sum=0;
            boolean f=false;
            for(int i=0;i<sb.length();i+=1){
                int y=sb.charAt(i)-'0';
                sum+=y;
                if((i+1)%k==0){
                    s1.append(sum);
                    sum=0;
                    f=true;
                }
                else{
                    f=false;
                }
            }
            if(!f){
                s1.append(sum);
            }
            sb=s1;
        }
        return sb.toString();
    }
}