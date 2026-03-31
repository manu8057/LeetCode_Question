class Solution {
    public char check(int arr[], int fr[]){
        int max=0;
        int idx=-1;
        for(int i=0;i<26;i++){
            if(arr[i]>0 && fr[i]==0){
                if(arr[i]>max){
                    max=arr[i];
                    idx=i;
                }
            }
        }
        if(idx==-1){
            return '#';
        }
        arr[idx]--;
        return (char)(idx+'a');
    }
    public int leastInterval(char[] tasks, int k) {
        int n=tasks.length;
        int arr[]=new int[26];
        for(char ch:tasks){
            arr[ch+32-'a']++;
        }
        ArrayDeque<Character>q=new ArrayDeque<>();
        int fr[]=new int[26];
        int i=0;
        int ans=0;
        while(i<n){
            if(q.size()>k){
                char p=q.pollFirst();
                if(p!='#'){
                    fr[p-'a']--;
                }
            }
            char a=check(arr,fr);
            System.out.println(a);
            if(a=='#'){
                q.add('#');
                ans++;
                continue;
            }
            q.add(a);
            fr[a-'a']++;
            ans++;
            i++;
        }
        return ans;
    }
}