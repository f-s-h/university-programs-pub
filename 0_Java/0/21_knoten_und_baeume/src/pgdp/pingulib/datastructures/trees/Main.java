package pgdp.pingulib.datastructures.trees;

public class Main {
    public static void main(String[] args){
        BSTNode<Integer> tree = new BSTNode<>(2);
        tree.insert(1);
        tree.insert(3);

        System.out.println(tree.toString());
        System.out.println(tree.contains(4));
    }
}
