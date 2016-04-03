package graph;

import java.util.*;

public class Dijkstra {

    private Set<Integer> closed;
    private HashMap<Integer,Integer> precursor;
    private HashMap<Integer,Integer> costToReach;
    private int vertcount;

    public Dijkstra(Graph graph,int start,int dest){
        closed=Collections.emptySet();
        vertcount=graph.adj.length;
        for (int i = 0; i < vertcount; i++) {
            costToReach.put(i,Integer.MAX_VALUE);
        }
        costToReach.replace(start,0);
        int current=start;
        closed.add(start);
        while(!closed.contains(dest)){

            for (int next:graph.adj(current)) {
                if(closed.contains(next)) continue;
                int cost =getCost(graph,current,next)+costToReach.get(current);
                if (cost<costToReach.get(next)){
                    costToReach.replace(next,cost);
                    precursor.put(next,current);
                }

            }
            current=getNext();
            closed.add(current);

        }

    }
    private int getCost(Graph graph,int from,int to){
        return 1;
    }

    private int getNext(){
        int value=-1;
        int cost=Integer.MAX_VALUE;
        for (int i = 0; i <vertcount+1 ; i++) {
            if(closed.contains(i)) continue;
            if (costToReach.get(i)<cost){
                value=i;
                cost=costToReach.get(i);
            }
        }

        if (value==-1||cost==Integer.MAX_VALUE){throw new RuntimeException("getNext failed, Destination was unreachable");}
        return value;
    }

    public ArrayList<Integer> getPath(int from,int to){
        if (from==to){
            return(ArrayList<Integer>) Collections.EMPTY_LIST;
        }
        int prec=precursor.get(to);
        ArrayList<Integer> toReturn=getPath(from,prec);
        toReturn.add(-1,to);
        return toReturn;

    }

}
