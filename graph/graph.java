package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;





/**
 * graph
 */
public class graph {

    static class edge{
        int v1;
        int v2;
        int wt;

        edge(int a,int b,int w){
            this.v1=a;
            this.v2=b;
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
                System.out.print("("+cedge.v2+","+cedge.wt+") - ");
            } 
        System.out.println();
        }
 }

 public static boolean hasPath(int s,int d,boolean[] visited,ArrayList<ArrayList<edge>> graph,String path){

  if(s==d){    
    System.out.println(path+" "+d);
    return true;
  }  
  visited[s]=true; 
    for(int i=0;i<graph.get(s).size();i++){
        edge ce= graph.get(s).get(i);
        if(!visited[ce.v2]){
            boolean ans = hasPath(ce.v2,d , visited, graph,path+" "+s);
            if(ans){return true;}
        }
    }
    
    return false;

 }
 public static void allPaths(int s,int d,boolean[] visited,ArrayList<ArrayList<edge>> graph,String path){

    if(s==d){    
      System.out.println(path+" "+d);
      return ;
    }  
    visited[s]=true; 
      for(int i=0;i<graph.get(s).size();i++){
          edge ce= graph.get(s).get(i);
          if(!visited[ce.v2]){
              allPaths(ce.v2,d , visited, graph,path+" "+s);
              
          }
      }
      visited[s]=false;
      
  
   } 

   public static void minCostPath(int s,int d,boolean[] visited,ArrayList<ArrayList<edge>> graph,String path){

   }
   static int max = Integer.MIN_VALUE;

   static void maxCostPath(ArrayList<ArrayList<edge>> graph, int s, int d, boolean[] visited, int cost) {
    if (s == d) {
        if (max < cost) {			
            max = cost;
        }
        return;
    }

    visited[s] = true;
    
    for (int ce = 0; ce < graph.get(s).size(); ce++) {
        edge e = graph.get(s).get(ce);
        if ( ! visited[e.v2] )
            maxCostPath(graph, e.v2, d, visited, cost + e.wt);
    }
    visited[s] = false;

}
static class helper implements Comparable<helper> {
    int vtx;
    String path;
    int cost;
    
    helper(int v,String p,int c){
        this.vtx = v;
        this.path = p;
        this.cost = c;
    }
    
    @Override
    public int compareTo(helper other) {
        // TODO Auto-generated method stub
        return this.cost - other.cost;
        
    }
}
static void Dijkstra(ArrayList<ArrayList<edge>> graph, int src) {
    // write your code here	
    
    PriorityQueue<helper> pq = new PriorityQueue<helper>();
    
    helper root = new helper(src,""+src,0);
    pq.add(root);
    boolean[] visited = new boolean[graph.size()];
    
    while(pq.size()>0){
        helper cp = pq.remove();
        if(visited[cp.vtx]){
            continue;
        }
        else{
            visited[cp.vtx]=true;
        }
        System.out.println(cp.vtx + " via "+cp.path + " @ " + cp.cost);
        
        for(int e=0;e<graph.get(cp.vtx).size();e++){
            edge ce=graph.get(cp.vtx).get(e);
            
            if(visited[ce.v2]==false){
                helper cvtx = new helper(ce.v2,cp.path+ce.v2,cp.cost+ce.wt);
                pq.add(cvtx);
            }
        }
    }
}



    public static void main(String[] args) {
        ArrayList<ArrayList<edge>> graph= new ArrayList<>();
        for(int i=0;i<=7;i++){
            graph.add(new ArrayList<edge>());
        }

        addEdge(graph, 1, 2, 10);
        addEdge(graph, 1, 4, 40);
        addEdge(graph, 2, 3, 10);
        addEdge(graph, 3, 4, 10);
        addEdge(graph, 4, 5, 2);
        addEdge(graph, 5, 6, 3);
        addEdge(graph, 5, 7, 8);
        addEdge(graph, 6, 7, 3);
        
        display(graph);
        boolean[] visited=new boolean[graph.size()];
        System.out.println(hasPath(1, 7, visited, graph," "));
       // allPaths(1, 7, visited, graph," ");
       // maxCostPath(graph, 1, 7, visited, 0);
        //System.out.println(max);
        //Scanner scn = new Scanner(System.in);
		//int a = scn.nextInt();
		//Dijkstra(graph, a);

    }
}