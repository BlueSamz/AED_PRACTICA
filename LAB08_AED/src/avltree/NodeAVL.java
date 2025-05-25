package avltree;

import bstree.Node;

public class NodeAVL<E> extends Node<E> {
    int bf; // balance factor

    public NodeAVL(E data) {
        super(data);
        this.bf = 0;
    }

    @Override
    public String toString() {
    return "[Dato:" + this.data + ",FE:" + this.bf + "]";
    }
}
