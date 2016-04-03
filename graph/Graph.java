package graph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;


public class Graph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;
    public Graph(int V){
        this.V=V;this.E=0;
        adj=(Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v]=new Bag<Integer>();
        }
    }
    public void addEdge(int v,int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }
    public int V(){return this.V;}
    public int E(){return this.E;}

    public Graph(In in){
        this(in.readInt());
        int E=in.readInt();
        for (int i = 0; i < E; i++) {
            int v=in.readInt();
            int w=in.readInt();
            addEdge(v,w);

        }
    }
}
