package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private LinkedList<Node> nodes;
    private ArrayList<String> edgesData;
    public Graph(){
        nodes = new LinkedList<>();
        edgesData = new ArrayList<>();
    }
    public void addNode(String data){
        nodes.add(new Node(data));
    }
    public void addEdge(String src, String dest){
        Node srcNode = findNode(src);
        Node destNode = findNode(dest);

        if(srcNode != null && destNode != null){
            edgesData.add(src+dest);
            srcNode.AddAdjacentNode(destNode);
            //destNode.AddAdjacentNode(srcNode);
        }
    }
    public void showNodes(){
        for(Node node : nodes){
            System.out.print(node.key + " ");
            for(Node adj : node.getAdjacentNode()){
                System.out.print(adj.key + " ");
            }
            System.out.println();
        }
    }
    public void DFS(Node node, StringBuilder st){
        for(Node adj : node.getAdjacentNode()){
            if(adj.isVisited() == false){
                st.append(adj.key + "-");
                adj.setVisit(true);
                DFS(adj,st);
            }
        }
    }
    public void depthFirstSearch(){
        StringBuilder st = new StringBuilder();
        resetVisitVal();
        for(Node node : nodes){
            if(node.isVisited() == false){
                st.append(node.key + "-");
                node.setVisit(true);
            }
            DFS(node, st);
        }
        st.deleteCharAt(st.length()-1);
        System.out.println(st.toString());
    }
    public void breadthFirstSearch(){
        StringBuilder st = new StringBuilder();
        Queue<Node> q = new LinkedList<>();
        Node v;
        resetVisitVal();
        for(Node node: nodes){
            if(node.isVisited() == false)
            {
                node.visit = true;
                q.add(node);
                while(!q.isEmpty()){
                    v = q.remove();
                    st.append(v.key + "-");
                    for(Node adj: v.getAdjacentNode()){
                        if(adj.isVisited() == false){
                            adj.setVisit(true);
                            q.add(adj);
                        }
                    }
                }
            }
        }
        st.deleteCharAt(st.length()-1);
        System.out.println(st.toString());
    }
    private void resetVisitVal(){
        for(Node node : nodes){
            node.setVisit(false);
        }
    }

    private Node findNode(String data){
        for(Node node : nodes){
            if (node.key.equals(data)){
                return node;
            }
        }
        return null;
    }

    public void printGraph() {
        System.out.println("Vertix Nodes");
        System.out.print("   ");
        for(Node node : nodes){
            System.out.print(node.key + "  ");
        }
        System.out.println();
        for(Node node: nodes){
            System.out.print(node.key+"  ");
            LinkedList<Node> adj = node.getAdjacentNode(); 
            for(Node node2 : nodes){
                if(adj.contains(node2)){
                    System.out.print("1  ");
                }
                else{
                    System.out.print("0  ");
                }
            }
            System.out.println();
        }
        System.out.println("==============================================");
        System.out.println("Edges");
        System.out.print("   ");
        for(String edges : edgesData){
            System.out.print(edges + "  ");
        }
        System.out.println();
        for(Node node: nodes){
            System.out.print(node.key+"  ");
            
            for (String edge : edgesData) {
                if(edge.contains(node.key)){
                    System.out.print("1   ");
                }
                else{
                    System.out.print("0   ");
                }
            }
            System.out.println();
        }
    }
}
