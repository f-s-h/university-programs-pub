package pgdp.pingulib.datastructures.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BST<T extends Comparable<T>> {
    private BSTNode<T> root;

    public BST() {
        root = null;
    }

    public void insert(T val){
        BSTNode<T> node = new BSTNode<>(val);
        if(root == null){
            root = node;
        }
        else{
            root.insert(val);
        }
    }

    public boolean isEmpty(){
        return root == null;
    }

    public int size(){
        if(root == null){
            return 0;
        }
        else{
            return root.size();
        }
    }

    public boolean contains(T val){
        if(root == null){
            return false;
        }
        else{
            return root.contains(val);
        }
    }

    public List<T> toList(){
        if(root == null){
            return new ArrayList<>();
        }
        else{
            return root.toList(Order.IN);
        }
    }

    public String toString(){
        if(root == null){
            return "[]";
        }
        else{
            return root.toString();
        }
    }

}
