class Solution {
    public boolean fun(int arr[],int fr[]){
        for(int i=0;i<26;i+=1){
            if(arr[i]>fr[i]) return false;
        }
        return true;
    }
    public int fun(int idx,String words[],int fr[],int score[]){
        if(idx==words.length) return 0;
        int a=fun(idx+1,words,fr,score);
        String s=words[idx];
        int arr[]=new int[26];
        int c=0;
        for(int i=0;i<s.length();i+=1){
            char ch=s.charAt(i);
            arr[ch-'a']++;
            c+=score[ch-'a'];
        }
        int b=0;
        if(fun(arr,fr)){
            for(int i=0;i<26;i+=1){
                fr[i]-=arr[i];
            }
            b=c+fun(idx+1,words,fr,score);
            for(int i=0;i<26;i+=1){
                fr[i]+=arr[i];
            }
        }
        return Math.max(a,b);
    }
    public int maxScoreWords(String[] words,char[] letters,int[] score){
        int fr[]=new int[26];
        for(char ch:letters){
            fr[ch-'a']++;
        }
        return fun(0,words,fr,score);
    }
}