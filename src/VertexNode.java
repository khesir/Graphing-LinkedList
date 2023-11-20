package src;

public class VertexNode {
    protected String key;
    protected AdjacentNode next;
    
    public VertexNode(){
        key = null;
        next = null;
    }
    public VertexNode(String key){
        this(key, null);
    }
    public VertexNode(String key, AdjacentNode next){
        this.key = key;
        this.next = next;
    }
}
