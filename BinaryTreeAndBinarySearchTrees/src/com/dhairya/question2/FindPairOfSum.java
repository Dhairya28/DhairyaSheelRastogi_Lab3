package com.dhairya.question2;

import java.util.HashSet;

public class FindPairOfSum {
	static class Node {
        int data;
        Node left, right;
    };
 
    static Node NewNode(int data)
    {
        Node newNode = new Node();
        newNode.data = data;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }
 
    static Node insertKey(Node root, int key)
    {
        if (root == null)
            return NewNode(key);
        if (key < root.data)
            root.left = insertKey(root.left, key);
        else
            root.right = insertKey(root.right, key);
        return root;
    }
 
    public static boolean findPairOfSum(Node root, int sum,
                                HashSet<Integer> set)
    {
        if (root == null)
            return false;
 
        if (findPairOfSum(root.left, sum, set))
            return true;
 
        if (set.contains(sum - root.data)) {
            System.out.println("Pair is found ("+ (sum - root.data) + ", "+root.data + ")");
            return true;
        }
        else
            set.add(root.data);
 
        return findPairOfSum(root.right, sum, set);
    }
 
    static void findPair(Node root, int sum)
    {
        HashSet<Integer> set = new HashSet<Integer>();
        if (!findPairOfSum(root, sum, set))
            System.out.println("Nodes are not found");
    }
    public static void main(String[] args)
    {
        Node root = null;
        root = insertKey(root,40);
        root = insertKey(root,20);
        root = insertKey(root,60);
        root = insertKey(root,10);
        root = insertKey(root,30);
        root = insertKey(root,50);
        root = insertKey(root,70);
        
 
        int sum = 130;
        findPair(root, sum);
    }
}
