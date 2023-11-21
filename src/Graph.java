package src;

import java.util.ArrayList;
import java.util.LinkedList;

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
            destNode.AddAdjacentNode(srcNode);
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
