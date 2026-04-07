class Solution {
    public int robotSim(int[] commands, int[][] xt) {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<xt.length;i++){
            set.add(xt[i][0]+"#"+xt[i][1]);
        }
        int x=0;
        int y=0;
        int d=0; 
        int[][] arr={{0,1},{1,0},{0,-1},{-1,0}};
        int max=0;
        for(int i=0;i<commands.length;i++){
            int el=commands[i];
            if(el==-1){
                d=(d+1)%4;
            }
            else if(el==-2){
                d=(d+3)%4;
            }
            else{
                while(el-->0){
                    int nx=x+arr[d][0];
                    int ny=y+arr[d][1];
                    if(set.contains(nx+"#"+ny)){
                        break;
                    }
                    x=nx;
                    y=ny;
                    max=Math.max(max,x*x+y*y);
                }
            }
        }
        return max;
    }
}