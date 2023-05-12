package pgdp.pingulib.datastructures.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryNode<T> extends Node<T> {

	BinaryNode<T> left;
	BinaryNode<T> right;

	public BinaryNode(T value) {
		//Allocate space for exactly two children
		super(value, null, null);
		this.left = null;
		this.right = null;
	}

	public BinaryNode(T value, BinaryNode<T> left, BinaryNode<T> right) {
		super(value, left, right);
		this.left = left;
		this.right = right;
	}

	private List<T> toInOrderList(){
		List<T> list = new ArrayList<>();

		if(left != null){
			for(T val : left.toList(Order.IN)){
				list.add(val);
			}
		}

		list.add(getValue());

		if(right != null){
			for(T val : right.toList(Order.IN)){
				list.add(val);
			}
		}

		return list;
	}

	private List<T> toPreOrderList(){
		List<T> list = new ArrayList<>();

		list.add(getValue());

		if(left != null){
			for(T val : left.toList(Order.PRE)){
				list.add(val);
			}
		}

		if(right != null){
			for(T val : right.toList(Order.PRE)){
				list.add(val);
			}
		}

		return list;
	}

	private List<T> toPostOrderList(){
		List<T> list = new ArrayList<>();

		if(left != null){
			for(T val : left.toList(Order.POST)){
				list.add(val);
			}
		}

		if(right != null){
			for(T val : right.toList(Order.POST)){
				list.add(val);
			}
		}

		list.add(getValue());

		return list;
	}


	@Override
	public List<T> toList(Order order) {
		List<T> list = null;
		switch (order) {
			case IN -> list = toInOrderList();
			case POST -> list = toPostOrderList();
			case PRE -> list = toPreOrderList();
		}
		return list;
	}

	public BinaryNode<T> getLeft(){
		return (BinaryNode<T>) super.getChildren()[0];
	}

	public BinaryNode<T> getRight(){
		return (BinaryNode<T>) super.getChildren()[1];
	}

	public void setLeft(BinaryNode<T> node){
		super.setChild(0, node);
		left = node;
	}

	public void setRight(BinaryNode<T> node){
		super.setChild(1, node);
		right = node;
	}

	@Override
	public String toString(){
		return toInOrderString();
	}

	public String toString(Order order){
		String string = null;

		switch (order){
			case IN -> string = toInOrderString();
			case PRE -> string = toPreOrderString();
			case POST -> string = toPostOrderString();
		}

		return string;
	}

	public String toInOrderString(){
		if(super.isLeaf()){
			return "[" + getValue() + "]";
		}

		String leftString;
		if(left == null) leftString = "-";
		else leftString = left.toInOrderString();

		String rightString;
		if(right == null) rightString = "-";
		else rightString = right.toInOrderString();

		return "[" + leftString + ", " + getValue() + ", " + rightString + "]";
	}

	public String toPreOrderString(){
		if(super.isLeaf()){
			return "[" + getValue() + "]";
		}

		String leftString;
		if(left == null) leftString = "-";
		else leftString = left.toPreOrderString();

		String rightString;
		if(right == null) rightString = "-";
		else rightString = right.toPreOrderString();

		return "[" + getValue() + ", " + leftString  + ", " + rightString + "]";
	}

	public String toPostOrderString(){
		if(super.isLeaf()){
			return "[" + getValue() + "]";
		}

		String leftString;
		if(left == null) leftString = "-";
		else leftString = left.toPostOrderString();

		String rightString;
		if(right == null) rightString = "-";
		else rightString = right.toPostOrderString();

		return "[" + leftString  + ", " + rightString + ", " + getValue() + "]";
	}

}