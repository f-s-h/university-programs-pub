package pgdp.pingulib.datastructures.trees;

public class BSTNode<T extends Comparable<T>> extends BinaryNode<T> {

    public BSTNode(T value) {
        super(value);
    }

    public BSTNode(T value, BSTNode<T> left, BSTNode<T> right){
        super(value, left, right);
    }

    public void insert(T val){
        //insert on left side
        if(val.compareTo(getValue()) < 0){
            // If the left node is empty, insert the value there, otherwise insert recursively in the left child
            if(getLeft() == null) setLeft(new BSTNode<>(val));
            else ((BSTNode<T>) getLeft()).insert(val);
        }
        //insert on right side
        else if(val.compareTo(getValue()) > 0){
            // If the right node is empty, insert the value there, otherwise insert recursively in the right child
            if(getRight() == null) setRight(new BSTNode<>(val));
            else ((BSTNode<T>) getRight()).insert(val);
        }
        //values are equal -> do nothing
    }

    public boolean contains(T val){
        //search in left side
        if(val.compareTo(getValue()) < 0){
            if(getLeft() == null) return false;
            else return ((BSTNode<T>) getLeft()).contains(val);
        }
        //search in right side
        else if(val.compareTo(getValue()) > 0){
            if(getRight() == null) return false;
            else return ((BSTNode<T>) getRight()).contains(val);
        }
        //values are equal -> return true
        return true;
    }

}
