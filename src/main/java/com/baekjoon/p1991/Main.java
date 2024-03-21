package com.baekjoon.p1991;

import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static TreeNode root = new TreeNode('A', null, null);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char parent = st.nextToken().charAt(0);
            char leftChild = st.nextToken().charAt(0);
            char rightChild = st.nextToken().charAt(0);

            insert(root, parent, leftChild, rightChild);
        }

        preOrder(root);
        sb.append("\n");
        inOrder(root);
        sb.append("\n");
        postOrder(root);
        sb.append("\n");

        System.out.println(sb);
    }

    static void insert(TreeNode temp, char parent, char leftChild, char rightChild) {
        // 현재 노드가 부모 노드이면 자식 노드들이 있으면 자식 노드 생성
        if (temp.val == parent) {
            temp.left = (leftChild == '.' ? null : new TreeNode(leftChild, null, null));
            temp.right = (rightChild == '.' ? null : new TreeNode(rightChild, null, null));
        } else {
            // 찾고자 하는 부모 노드가 아니라면 현재 노드의 자식이 찾고자 하는 부모노드가 맞을 때 까지 탐색
            if (temp.left != null) {
                insert(temp.left, parent, leftChild, rightChild);
            }
            if (temp.right != null) {
                insert(temp.right, parent, leftChild, rightChild);
            }
        }
    }

    // 전위 순회
    static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        sb.append(node.val);

        preOrder(node.left);

        preOrder(node.right);
    }

    // 중위 순회
    static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);

        sb.append(node.val);

        inOrder(node.right);
    }

    // 후위 순회
    static void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);

        postOrder(node.right);

        sb.append(node.val);
    }
}

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    TreeNode(char val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
