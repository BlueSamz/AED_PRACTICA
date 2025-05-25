package bstree;

public class NodeAVL<E extends Comparable<E>> extends NodeTree {

    public int bf; 
    public NodeAVL(E data) {
        super(data);
        this.bf = 0;
    }

    public int getFactEquilibrio() {
    	return this.bf;
    }
    public void setFactEquilibrio(int fe) {
    	this.bf = fe;
    }
    @Override
    public String toString() {
        return "[Dato: " + this.data + ", FE: " + this.bf + "]";
    }

}