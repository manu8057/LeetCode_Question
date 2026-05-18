class Solution {
    public int minJumps(int[] arr) {
        HashMap<Integer, ArrayList<Integer>> hm=new HashMap<>();
        for(int i=0;i<arr.length;i++) {
            hm.putIfAbsent(arr[i], new ArrayList<>());
            hm.get(arr[i]).add(i);
        }
        boolean vis[]=new boolean[arr.length];
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        vis[0]=true;
        int jump=0;
        while(!q.isEmpty()) {
            int size=q.size();
            while(size-->0) {
                int idx=q.poll();
                if(idx==arr.length-1) {
                    return jump;
                }
                if(idx-1>=0 && !vis[idx-1]) {
                    q.add(idx-1);
                    vis[idx-1]=true;
                }
                if(idx+1<arr.length && !vis[idx+1]) {
                    q.add(idx+1);
                    vis[idx+1]=true;
                }
                if(hm.containsKey(arr[idx])) {
                    for(int x:hm.get(arr[idx])) {
                        if(!vis[x]) {
                            q.add(x);
                            vis[x]=true;
                        }
                    }
                    hm.remove(arr[idx]);
                }
            }
            jump++;
        }
        return -1;
    }
}