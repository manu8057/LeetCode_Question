class Solution {
    public String originalDigits(String s) {
        int arr[]=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        int ans[]=new int[10];
        ans[0]=arr['z'-'a'];
        ans[2]=arr['w'-'a'];
        ans[4]=arr['u'-'a'];
        ans[6]=arr['x'-'a'];
        ans[8]=arr['g'-'a'];
        ans[3]=arr['h'-'a']-ans[8];
        ans[5]=arr['f'-'a']-ans[4];
        ans[7]=arr['s'-'a']-ans[6];
        ans[1]=arr['o'-'a']-ans[0]-ans[2]-ans[4];
        ans[9]=arr['i'-'a']-ans[5]-ans[6]-ans[8];
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<=9;i++){
            while(ans[i]>0){
                sb.append(i);
                ans[i]--;
            }
        }
        return sb.toString();
    }
}