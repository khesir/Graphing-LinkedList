package src;

public class AdjacentNode {
    protected VertexNode node;
    protected AdjacentNode next;

    public AdjacentNode(){
        node = null;
        next = null;
    }
    public AdjacentNode(VertexNode node){
        this(node, null);
    }
    public AdjacentNode(VertexNode node, AdjacentNode next){
        this.node = node;
        this.next = next;
    }
}
