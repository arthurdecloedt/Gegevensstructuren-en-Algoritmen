package graph;




import edu.princeton.cs.algs4.Graph;

public class DFS{

    private boolean[] marked;
    private int count;

    public DFS(Graph G,int source){
        marked=new boolean[G.V()];
        dfs(G,source);
    }
    private void dfs(Graph g,int v){
        marked[v]=true;
        count++;
        for (int w:g.adj(v)) {
            if (!marked[w]) dfs(g,w);

        }
    }
    public boolean marked(int v){return marked[v];}
    public int count(){return count;}
}