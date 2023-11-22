package src;

import java.util.LinkedList;

public class Node {
    protected String key;
    protected boolean visit;
    protected LinkedList<Node> adj;
    
    public Node(String key){
        this.key = key;
        adj = new LinkedList<>();
    }
    public void AddAdjacentNode(Node adj){
        this.adj.add(adj);
    }
    public void setVisit(boolean condition){
        visit = condition;
    }
    
    public boolean isVisited(){
        return visit;
    }
    public LinkedList<Node> getAdjacentNode(){
        return adj;
    }
}
