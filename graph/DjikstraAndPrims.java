package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class DjikstraAndPrims {

    static class edge{
        int u;
        int v;
        int wt;

        edge(int a,int b,int w){
            this.u=a;
            this.v=b;
            this.wt=w;
        }
    }

    public static void addEdge(ArrayList<ArrayList<edge>> graph,int v1,int v2,int wt){
        graph.get(v1).add(new edge(v1, v2, wt));
        graph.get(v2).add(new edge(v2, v1, wt));
    }

    public static void display(ArrayList<ArrayList<edge>> graph){
        for(int i=0;i<graph.size();i++){
            System.out.print(i+" -> ");
            for(int j=0;j<graph.get(i).size();j++){
                edge cedge = graph.get(i).get(j);
                System.out.print("("+cedge.v+","+cedge.wt+") - ");
            } 
        System.out.println();
        }
 }


static class dpair{
    int u =0;
    int par = 0;
    int wt = 0;
    int wsf = 0;

    dpair(int a,int b,int wt,int wsf){
        this.u = a;
        this.par = b;
        this.wt = wt;
        this.wsf = wsf;
    }
}

public static void djikstraAlgo(ArrayList<ArrayList<edge>> graph,int src){
    ArrayList<ArrayList<edge>> myGraph = new ArrayList<>();
    for(int i=0;i<graph.size();i++){
        myGraph.add(new ArrayList<>());

    }

    PriorityQueue<dpair> que = new PriorityQueue<>((dpair a,dpair b)->{   // lambda function is used instead of implementing comaparable in the dpair class
        return a.wsf-b.wsf; //min PQ on behalf of wsf
        //return b.wsf-a.wsf; //max PQ on behalf of wsf
    });

    boolean[] vis = new boolean[graph.size()];
    que.add(new dpair(src,-1, 0, 0));

    while(que.size()!=0){
        dpair pair = que.remove();

        if(vis[pair.u]) continue;
        vis[pair.u]=true;

        if(pair.par!=-1){
            addEdge(myGraph, pair.u, pair.par, pair.wt);
        }

        for(edge e: graph.get(pair.u)){ // hrr ek arraylist ke elemnents ko ek ek krke traverse krega
            if(!vis[e.v]){
                que.add(new dpair(e.v,pair.u, e.wt, pair.wsf+e.wt));
            }
        }
    }
    display(myGraph);
}

public static void primsAlgo(ArrayList<ArrayList<edge>> graph,int src){
    ArrayList<ArrayList<edge>> myGraph = new ArrayList<>();
    for(int i=0;i<graph.size();i++){
        myGraph.add(new ArrayList<>());

    }

    PriorityQueue<dpair> que = new PriorityQueue<>((dpair a,dpair b)->{   // lambda function is used instead of implementing comaparable in the dpair class
        return a.wt-b.wt; //min PQ on behalf of wsf
        
    });

    boolean[] vis = new boolean[graph.size()];
    que.add(new dpair(src,-1, 0, 0));

    while(que.size()!=0){
        dpair pair = que.remove();

        if(vis[pair.u]) continue;
        vis[pair.u]=true;

        if(pair.par!=-1){
            addEdge(myGraph, pair.u, pair.par, pair.wt);
        }

        for(edge e: graph.get(pair.u)){
            if(!vis[e.v]){
                que.add(new dpair(e.v,pair.u, e.wt, pair.wsf+e.wt));
            }
        }
    }
    display(myGraph);
}

public static void solve(){
    ArrayList<ArrayList<edge>> graph = new ArrayList<>();
    for(int i = 0;i<7;i++){
        graph.add(new ArrayList<edge>());
    }

    addEdge(graph, 0, 1, 10);
    addEdge(graph, 0, 3, 10);
    addEdge(graph, 1, 2, 10);
    addEdge(graph, 3, 2, 40);
    addEdge(graph, 3, 4, 2);
    addEdge(graph, 4, 5, 2);
    addEdge(graph, 4, 6, 3);
    addEdge(graph, 5, 6, 8);

    display(graph);
    System.out.println();
    djikstraAlgo(graph, 0);
    System.out.println();
    primsAlgo(graph, 0); // answer of prims and djikstra may be same : 
                        // The main difference is that prims gives the MST and is independent of source while Djisktra gives the MST i.e. dependent on the source
}


public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
    ArrayList< ArrayList< edge > > graph = new ArrayList<>();
    for(int i = 0 ; i <= n ; i++ ){
        graph.add(new ArrayList<edge>());
    }

    for(int i=0;i<pipes.length;i++){
        int u=pipes[i][0];
        int v=pipes[i][1];
        int w=pipes[i][2];
        addEdge(graph,u,v,w);
    }

    for(int i=0;i<wells.length;i++){
        int u=0;
        int v=i;
        int w=wells[i];
        addEdge(graph,u,v,w);
    }

    int ans=0;

    PriorityQueue<dpair> que=new PriorityQueue<>((dpair a,dpair b)-> {
        return a.wt-b.wt; // min PQ on behalf of wt
    });

    boolean[] vis=new boolean[graph.size()];
    que.add(new dpair(0,-1,0,0));

    while(que.size()!=0){
        dpair pair=que.remove();
        
        if(vis[pair.u]) continue;   //case of cycle.
        vis[pair.u]=true;    //mark

        ans+=pair.wt;
        
        for(edge e: graph.get(pair.u)){
            if(!vis[e.v]){
                que.add(new dpair(e.v,pair.u,e.wt,pair.wsf+e.wt));
            }
        }
    }

    return ans;
}


public static void dfs(ArrayList<ArrayList<edge>> graph,int src,boolean[] vis){
    vis[src]=true;
    for(edge e: graph.get(src))
      if(!vis[e.v])
        dfs(graph,e.v,vis);
}

public static void bfs(ArrayList<ArrayList<edge>> graph,int src,boolean[] vis){
    LinkedList<Integer> que=new LinkedList<>();
    que.addLast(src);

    while(que.size()!=0){
        int vtx=que.removeFirst();
        vis[vtx]=true;
        for(edge e: graph.get(src))
           if(!vis[e.v])
            que.addLast(e.v);

    }
}


public static void main(String[] args) {
    solve();
}
}