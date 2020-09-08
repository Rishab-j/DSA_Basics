package GraphPractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Graph {

    static class edge {
        int v1;
        int v2;
        int wt;

        edge(int v1, int v2, int wt) {
            this.v1 = v1;
            this.v2 = v2;
            this.wt = wt;
        }
    }

    public static void addEdge(ArrayList<ArrayList<edge>> graph, int a, int b, int wt) {
        graph.get(a).add(new edge(a, b, wt));
        graph.get(b).add(new edge(b, a, wt));
    }

    public static void display(ArrayList<ArrayList<edge>> graph) {
        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < graph.get(i).size(); j++) {
                edge cedge = graph.get(i).get(j);
                System.out.print("(" + cedge.v2 + "," + cedge.wt + ")");
            }
            System.out.println();
        }
    }

    public static boolean hasPath(ArrayList<ArrayList<edge>> graph, int s, int d, boolean[] visited, String path) {

        if (s == d) { // agr source hi det. ke equal h mtlb hume path mil gya
            System.out.println(path + d);
            return true;
        }
        visited[s] = true; // aate hi source ko visited mark krr dia
        for (int i = 0; i < graph.get(s).size(); i++) {
            edge cedge = graph.get(s).get(i); // checking neighbours
            if (visited[cedge.v2] != true) {
                boolean reached = hasPath(graph, cedge.v2, d, visited, path + s);
                if (reached == true) {

                    return true;
                }

            }
        }

        return false;
    }

    public static void allPaths(ArrayList<ArrayList<edge>> graph, int s, int d, boolean[] visited, String path) {

        if (s == d) {
            System.out.println(path + "->" + d);
            return;
        }

        visited[s] = true;

        // visit every neighbours of current source
        // if that neighbour is not visited then call allPath on that vertex as source
        // when source is same as dest. then print path and return
        // if all neighbours are visited then make the current source unvisited

        for (int i = 0; i < graph.get(s).size(); i++) {
            edge cedge = graph.get(s).get(i);
            if (visited[cedge.v2] == false) {
                allPaths(graph, cedge.v2, d, visited, path + "->" + s);
            }
        }
        visited[s] = false;
    }

    static int max = Integer.MIN_VALUE;
    static String maxPath = "";

    public static void maxCostPath(ArrayList<ArrayList<edge>> graph, int s, int d, boolean[] visited, int cost,
            String path) {
        if (s == d) {
            if (max < cost) {
                max = cost;
                path = path + d;
                maxPath = path;
            }
            return;
        }

        visited[s] = true;

        for (int i = 0; i < graph.get(s).size(); i++) {
            edge cedge = graph.get(s).get(i);
            if (visited[cedge.v2] == false) {
                maxCostPath(graph, cedge.v2, d, visited, cost + cedge.wt, path + s);
            }
        }
        visited[s] = false;
    }

    public static int maxCostPathReturnType(ArrayList<ArrayList<edge>> graph, int s, int d, boolean[] visited) {

        if (s == d) {
            return 0;
        }

        int myCost = Integer.MIN_VALUE; // iss level ka cost
        visited[s] = true;

        for (int i = 0; i < graph.get(s).size(); i++) {
            edge cedge = graph.get(s).get(i);
            if (visited[cedge.v2] == false) {
                int cost = maxCostPathReturnType(graph, cedge.v2, d, visited);// apne neighbour ko bola tu apne se dest.
                                                                              // tkk ka cost nikal la
                if (cost + cedge.wt > myCost) {
                    myCost = cost + cedge.wt;
                }
            }
        }
        visited[s] = false;
        return myCost;
    }

    static int ceil = Integer.MAX_VALUE;
    static int floor = Integer.MIN_VALUE;
    static String cp = "";
    static String fp = "";

    public static void CeilFloor(ArrayList<ArrayList<edge>> graph, int s, int d, int factor, boolean[] visited,
            int costSoFar, String pathSofar) {
        if (s == d) {
            if (costSoFar > factor && costSoFar < ceil) {
                ceil = costSoFar;
                cp = pathSofar + d;
            }
            if (costSoFar < factor && costSoFar > floor) {
                floor = costSoFar;
                fp = pathSofar + d;
            }
            return;
        }
        visited[s] = true;
        for (int i = 0; i < graph.get(s).size(); i++) {
            edge cedge = graph.get(s).get(i);
            if (visited[cedge.v2] == false) {
                CeilFloor(graph, cedge.v2, d, factor, visited, costSoFar + cedge.wt, pathSofar + s);
            }
        }
        visited[s] = false;
    }

    static int klargest = Integer.MAX_VALUE;
    static String kPath = "";

    public static void KthLargestPath(ArrayList<ArrayList<edge>> graph, int s, int d, int k, boolean[] visited,
            int costSoFar, String pathSofar) {
        if (s == d) {
            if (costSoFar < klargest) {
                kPath = pathSofar + d;
                klargest = costSoFar;
            }
            return;
        }
        visited[s] = true;

        for (int i = 0; i < graph.get(s).size(); i++) {
            edge cedge = graph.get(s).get(i);
            if (visited[cedge.v2] == false) {
                KthLargestPath(graph, cedge.v2, d, k, visited, costSoFar + cedge.wt, pathSofar + s);
            }

        }
        visited[s] = false;
    }

    // static boolean cycleDetected = false;

    public static void hamiltonianPathAndCycle(ArrayList<ArrayList<edge>> graph, int s, int count, boolean[] visited,
            String path, int os) {
        if (count == graph.size() - 1) {
            path = path + s;
            System.out.println(path);
            boolean cycleDetected = false;
            if (cycleDetected == false) {
                for (int i = 0; i < graph.get(s).size(); i++) {
                    int nbr = graph.get(s).get(i).v2;
                    if (os == nbr) {
                        cycleDetected = true;
                        break;
                    }
                }
            }
            System.out.println(cycleDetected);
            return;
        }

        visited[s] = true;
        for (int i = 0; i < graph.get(s).size(); i++) {
            edge cedge = graph.get(s).get(i);
            if (visited[cedge.v2] == false) {
                hamiltonianPathAndCycle(graph, cedge.v2, count + 1, visited, path + s + "-> ", os);
            }
        }
        visited[s] = false;
    }

    // it is not compulsory to make a helper class
    // we made a helper clas because we want to print the breadth first traversal of
    // every vertex from source 0

    static class helper implements Comparable<helper> {
        int v;
        String path;
        int cost;

        helper(int vtx, String p, int c) {
            this.v = vtx;
            this.path = p;
            this.cost = c;
        }

        @Override
        public int compareTo(helper o) {
            return this.cost - o.cost;
            
        }
    }

    //Steps: They are same as they were in Level-order Traversal 
    // 1. Make a queue of helper type and add the source of the traversal
    // 2. Do this while the queue is not empty
    //    2.1 make a helper object and store the removed element from the queue
    //        i.e. remove from queue and add it in currVer
    //    2.2 if the currVer is already visited then continue without doing something(in this case without printing)
    //        if not then mark the it as true
    //    2.3 Print the path
    //    2.4 add only those neighbour in the queue that are not visited before
    // 3. keep doing all this until the queue is empty

    public static void Bfs(ArrayList<ArrayList<edge>> graph, int src) {
        Queue<helper> queue = new LinkedList<>();

        helper root = new helper(src, "" + src, 0); // helper class mei path khali pda h islie hum src add krenge

        queue.add(root);
        boolean[] visited = new boolean[graph.size()];

        while (queue.size() > 0) {
            helper currVer = queue.remove();
            // remove krte hi dekho kya wo vertex already process ho chuka h 
            if (visited[currVer.v] == true) {
                continue;
            } else {
                visited[currVer.v] = true;
            }

            System.out.println(currVer.v + " via " + currVer.path + " @ " + currVer.cost);

            for (int ce = 0; ce < graph.get(currVer.v).size(); ce++) {
                // currVer ka neighbour store krr lia
                edge nbr = graph.get(currVer.v).get(ce);

                // ab check kia ki kya ye nbr already visited h agr nhi to issey queue mei add kro
                if (visited[nbr.v2] == false) {
                // abhi tkk ke path mei jaha jaa rhe h (jo ki apna neighbr h) wo add krdo and cost mei uss edge ka cost     
                    helper neighbour = new helper(nbr.v2, currVer.path + nbr.v2, currVer.cost + nbr.wt);
                    queue.add(neighbour);
                }
            }
        }

    }


    public static void Dijkstra(ArrayList<ArrayList<edge>> graph ,int src){
        PriorityQueue<helper> queue = new PriorityQueue<>();

        helper source = new helper(src, ""+src, 0 );

        queue.add(source);
        boolean[] visited = new boolean[graph.size()];

        while(queue.size()>0){
            helper currV = queue.remove();

            if(visited[currV.v]==true){
                continue;
            }else{
                visited[currV.v] = true;
            }

            System.out.println(currV.v + " via " + currV.path +" @ " + currV.cost);

            for(int ce = 0;ce<graph.get(currV.v).size();ce++){
                edge cedge = graph.get(currV.v).get(ce);
                if(visited[cedge.v2]==false){
                    helper nbr = new helper(cedge.v2, currV.path + cedge.v2, currV.cost+ cedge.wt);
                    queue.add(nbr);
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<edge>> graph = new ArrayList<>();
        // Scanner scn = new Scanner(System.in);
        // int v = scn.nextInt();
        for (int i = 0; i < 7; i++) {
            graph.add(new ArrayList<>());
        }
        // int e = scn.nextInt();
        // for(int i=0;i<e;i++ ){
        // int v1=scn.nextInt();
        // int v2=scn.nextInt();
        // int wt=scn.nextInt();
        // addEdge(graph,v1,v2,wt);
        // }
        addEdge(graph, 0, 3, 40);
        addEdge(graph, 1, 0, 10);
        addEdge(graph, 2, 1, 10);
        addEdge(graph, 3, 2, 10);
        addEdge(graph, 4, 3, 2);
        addEdge(graph, 5, 4, 3);
        addEdge(graph, 6, 5, 3);
        addEdge(graph, 6, 4, 8);
        // addEdge(graph, 5, 2, 9);
        display(graph);
        // System.out.println(hasPath(graph, 0, 6, new boolean[7],""));
        // allPaths(graph, 0, 6, new boolean[7],"");
        // maxCostPath(graph,0, 6, new boolean[7],0,"");
        // System.out.println(max);
        // System.out.println(maxPath);
        // System.out.println(maxCostPathReturnType(graph, 0, 6, new boolean[7]));
        // CeilFloor(graph, 0, 6, 45, new boolean[7], 0, "");
        // System.out.println(cp + " @ " + ceil + " " + fp + " @ "+ floor);
        // KthLargestPath(graph, 0, 6, 1, new boolean[7],0,"");
        // System.out.println(kPath + " @ "+ klargest);
        // for(int i = 0;i<7;i++){
        // hamiltonianPathAndCycle(graph, i, 0, new boolean[8], "",i);
        // }
        //Bfs(graph, 0);
        Dijkstra(graph, 0);
    }
}