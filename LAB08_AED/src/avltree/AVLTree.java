package avltree;

import bstree.LinkedBST;
import bstree.NodeTree;
import clasesAuxiliares.QueueLink;
import bstree.NodeAVL;
import exceptions.ExceptionIsEmpty;
import exceptions.ItemDuplicated;
import exceptions.ItemNoFound;

public class AVLTree<E extends Comparable <E>> extends LinkedBST<E> {
    private boolean height;

    public void insert(E x) throws ItemDuplicated {
        height = false;
        this.root = insert(x, (NodeAVL<E>) this.root);
    }

    protected NodeTree<E> insert(E x, NodeAVL<E> node) throws ItemDuplicated {
        NodeAVL<E> fat = node;

        if (node == null) {
            height = true;
            return new NodeAVL<>(x);
        }

        int resC = x.compareTo((E) node.data);

        if (resC == 0) {
            throw new ItemDuplicated(x + " ya se encuentra en el árbol");
        }

        if (resC < 0) {
            fat.left = insert(x, (NodeAVL<E>) node.left);

            if (height) {
                switch (fat.bf) {
                    case 1:
                        fat.bf = 0;
                        height = false;
                        break;
                    case 0:
                        fat.bf = -1;
                        height = true;
                        break;
                    case -1:
                        fat = balanceToLeft(fat); 
                        height = false;
                        break;
                }
            }
        } else {
            fat.right = insert(x, (NodeAVL<E>) node.right);

            if (height) {
                switch (fat.bf) {
                    case -1:
                        fat.bf = 0;
                        height = false;
                        break;
                    case 0:
                        fat.bf = 1;
                        height = true;
                        break;
                    case 1:
                        fat = balanceToRight(fat); 
                        height = false;
                        break;
                }
            }
        }

        return fat;
    }

    private NodeAVL<E> balanceToLeft(NodeAVL<E> node) {
        NodeAVL<E> hijo = (NodeAVL<E>) node.left;

        if (hijo.bf == -1) {
            node.bf = 0; //derecha
            hijo.bf = 0;
            node = rotateSR(node);
        } else {
            NodeAVL<E> nieto = (NodeAVL<E>) hijo.right; //izquierda derecha

            switch (nieto.bf) {
                case -1:
                    node.bf = 1;
                    hijo.bf = 0;
                    break;
                case 0:
                    node.bf = 0;
                    hijo.bf = 0;
                    break;
                case 1:
                    node.bf = 0;
                    hijo.bf = -1;
                    break;
            }

            if (nieto != null) nieto.bf = 0;

            node.left = rotateSL(hijo);
            node = rotateSR(node);
        }

        return node;
    }

    private NodeAVL<E> balanceToRight(NodeAVL<E> node) {
        NodeAVL<E> hijo = (NodeAVL<E>) node.right;

        if (hijo.bf == 1) {
            node.bf = 0; //izquierda
            hijo.bf = 0;
            node = rotateSL(node);
        } else {
            NodeAVL<E> nieto = (NodeAVL<E>) hijo.left; //derecha izquierda

            switch (nieto.bf) {
                case 1:
                    node.bf = -1;
                    hijo.bf = 0;
                    break;
                case 0:
                    node.bf = 0;
                    hijo.bf = 0;
                    break;
                case -1:
                    node.bf = 0;
                    hijo.bf = 1;
                    break;
            }

            if (nieto != null) nieto.bf = 0;

            node.right = rotateSR(hijo);
            node = rotateSL(node);
        }

        return node;
    }

    private NodeAVL<E> rotateSR(NodeAVL<E> node) {
        System.out.println("Rotación Simple Derecha (balanceIzquierda) en nodo: " + node.data);
        NodeAVL<E> p = (NodeAVL<E>) node.left;

        node.left = p.right;
        p.right = node;

        System.out.println("Rotación Derecha en nodo: " + node.data + " -> Nuevo nodo raíz: " + p.data);

        return p;
    }

    private NodeAVL<E> rotateSL(NodeAVL<E> node) {
        System.out.println("Rotación Simple Izquierda (balanceDerecha) en nodo: " + node.data);
        NodeAVL<E> p = (NodeAVL<E>) node.right;

        node.right = p.left;
        p.left = node;

        System.out.println("Rotación Izquierda en nodo: " + node.data + " -> Nuevo nodo raíz: " + p.data);

        return p;
    }

    public void remove(E x) {
        height = false;
        this.root = remove(x, (NodeAVL<E>) this.root);
    }

    private NodeAVL<E> remove(Comparable data, NodeAVL<E> node) {
        if (node == null) return null;

        int resC = data.compareTo(node.data);

        if (resC < 0) {
            node.left = remove(data, (NodeAVL<E>) node.left);
            if (height) node = balanceToRightAfterDelete(node);
        } else if (resC > 0) {
            node.right = remove(data, (NodeAVL<E>) node.right);
            if (height) node = balanceToLeftAfterDelete(node);
        } else {
            if (node.left == null || node.right == null) {
                node = (NodeAVL<E>) (node.left != null ? node.left : node.right);
                height = true;
            } else {
                NodeAVL<E> successor = getMin((NodeAVL<E>) node.right);
                node.data = successor.data;
                node.right = remove(successor.data, (NodeAVL<E>) node.right);
                if (height) node = balanceToLeftAfterDelete(node);
            }
        }
        return node;
    }
    private NodeAVL<E> balanceToLeftAfterDelete(NodeAVL<E> node) {
        switch (node.bf) {
            case -1:
                node.bf = 0;
                break;
            case 0:
                node.bf = -1;
                height = false;
                break;
            case 1:
                NodeAVL<E> sucesorder = (NodeAVL<E>) node.right;
                if (sucesorder.bf >= 0) {
                    node = rotateSL(node);
                    if (sucesorder.bf == 0) {
                        node.bf = -1;
                        ((NodeAVL<E>) node.left).bf = 1;
                        height = false;
                    } else {
                        node.bf = 0;
                        ((NodeAVL<E>) node.left).bf = 0;
                    }
                } else {
                    node = balanceToRight(node);
                }
                break;
        }
        return node;
    }

    private NodeAVL<E> balanceToRightAfterDelete(NodeAVL<E> node) {
        switch (node.bf) {
            case 1:
                node.bf = 0;
                break;
            case 0:
                node.bf = -1;
                height = false;
                break;
            case -1:
                NodeAVL<E> sucesorizq = (NodeAVL<E>) node.left;
                if (sucesorizq.bf <= 0) {
                    node = rotateSR(node);
                    if (sucesorizq.bf == 0) {
                        node.bf = 1;
                        ((NodeAVL<E>) node.right).bf = -1;
                        height = false;
                    } else {
                        node.bf = 0;
                        ((NodeAVL<E>) node.right).bf = 0;
                    }
                } else {
                    node = balanceToLeft(node);
                }
                break;
        }
        return node;
    }
    
    public void recorridoPorAmplitud() {
    	if (root == null) return;

    	QueueLink<NodeAVL<E>> queue = new QueueLink<>();
    	queue.enqueue((NodeAVL<E>) root);
    	recorridoPorAmplitud(queue);
    }
    private void recorridoPorAmplitud(QueueLink<NodeAVL<E>> queue) {
    	if (queue.isEmpty()) return;
    	try {
    		NodeAVL<E> node = queue.dequeue();
    		System.out.print(node.data + " ");
    		if (node.left != null) queue.enqueue((NodeAVL<E>) node.left);
    		if (node.right != null) queue.enqueue((NodeAVL<E>) node.right);
    		recorridoPorAmplitud(queue);
    	} catch (ExceptionIsEmpty e) {
    		System.out.println("Error: " + e.getMessage());
    	}
    }

    public String recorridoPreorden() {
    	StringBuilder sb = new StringBuilder();
    	recorridoPreorden((NodeAVL<E>) this.root, sb);
    	return sb.toString().trim();
    }
    private void recorridoPreorden(NodeAVL<E> node, StringBuilder sb) {
    	if (node != null) {
    		sb.append(node.data).append(" ");
    		recorridoPreorden((NodeAVL<E>) node.left, sb);
    		recorridoPreorden((NodeAVL<E>) node.right, sb);
    	}
    }
    private NodeAVL<E> getMin(NodeAVL<E> node) {
        while (node.left != null) {
            node = (NodeAVL<E>) node.left;
        }
        return node;
    }
    

    @Override
    public String toString() {
        return inOrdenAVL((NodeAVL<E>) this.root).toString();
    }

    private StringBuilder inOrdenAVL(NodeAVL<E> node) {
        StringBuilder sb = new StringBuilder();
        if (node != null) {
            sb.append(inOrdenAVL((NodeAVL<E>) node.getLeft()));
            sb.append(node.toString()).append(" ");
            sb.append(inOrdenAVL((NodeAVL<E>) node.getRight()));
        }
        return sb;
    }

}

			