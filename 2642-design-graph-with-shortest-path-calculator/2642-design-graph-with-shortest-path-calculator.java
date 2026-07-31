class Graph {
    int mat[][];
    int len;
    public Graph(int n, int[][] edges) {
        mat=new int[n][n];
        len=n;
        for(int i=0;i<n;i+=1){
            for(int j=0;j<n;j+=1){
                if(i!=j){
                    mat[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        for(int ar[]:edges){
            mat[ar[0]][ar[1]]=ar[2];
        }
        for(int k=0;k<n;k+=1){
            for(int i=0;i<n;i+=1){
                for(int j=0;j<n;j+=1){
                    if(mat[i][k]==Integer.MAX_VALUE || mat[k][j]==Integer.MAX_VALUE){
                        continue;
                    }
                    mat[i][j]=Math.min(mat[i][j],mat[i][k]+mat[k][j]);
                }
            }
        }
    }
    public void addEdge(int[] edge) {
        int u=edge[0];
        int v=edge[1];
        int w=edge[2];
        if(w>=mat[u][v]) return;
        mat[u][v]=w;
        for(int i=0;i<len;i+=1){
            for(int j=0;j<len;j+=1){
                if(mat[i][u]==Integer.MAX_VALUE || mat[v][j]==Integer.MAX_VALUE){
                    continue;
                }
                mat[i][j]=Math.min(mat[i][j],mat[i][u]+w+mat[v][j]);
            }
        }
    }
    
    public int shortestPath(int node1, int node2) {
        if(mat[node1][node2]!=Integer.MAX_VALUE){
            return mat[node1][node2];
        }
        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */