package src;

import java.util.LinkedList;

public class Graph {
    LinkedList<Node> nodes;

    public Graph(){
        nodes = new LinkedList<>();
    }
    public void addNode(String data){
        nodes.add(new Node(data));
    }
    public void addEdge(String src, String dest){
        Node srcNode = findNode(src);
        Node destNode = findNode(dest);

        if(srcNode != null && destNode != null){
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
        for (Node node : nodes) {
            System.out.print("Node " + node.key + " is connected to: ");
            for (Node neighbor : node.getAdjacentNode()) {
                System.out.print(neighbor.key + " ");
            }
            System.out.println();
        }
    }
}
