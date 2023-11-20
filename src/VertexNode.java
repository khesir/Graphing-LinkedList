package src;

import java.util.LinkedList;

public class VertexNode {
    protected String key;
    protected LinkedList<AdjacentNode> adj;
    
    public VertexNode(){
        key = null;
        adj = new LinkedList<>();
    }
    public VertexNode(String key){
        this.key = key;
        adj = new LinkedList<>();
    }
    // fucntions to get data in LinkedList for AdjacentNode
    // for(tmp = head; tmp.next != tail; tmp = tmp.next);
    
}
