package com.baekjoon.p5639;

import java.io.*;

public class Main {
    static TreeNode node;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        node = new TreeNode(Integer.parseInt(input));

        while (true) {
            input = br.readLine();

            if (input == null || input.equals("")) {
                break;
            }

            int val = Integer.parseInt(input);
            TreeNode target = new TreeNode(val); // 연결하려고 하는 대상 노드

            TreeNode parent = node;
            for (TreeNode temp = parent; temp != null;) { // 현재 비교할 노드가 존재하면 비교하면서 제일 하위 노드까지 탐색
                parent = temp;

                if (target.data < parent.data) {
                    temp = parent.left;
                } else {
                    temp = parent.right;
                }
            }

            // 비교할 부모에 대해서 노드를 연결해주기
            if (target.data < parent.data) {
                parent.left = target;
            } else {
                parent.right = target;
            }
        }

        postOrder(node);
        System.out.println(sb);

    }

    static void postOrder(TreeNode node) {
        // 후위 순회는 왼 -> 오 -> 루트
        if (node.left != null)
            postOrder(node.left);
        if (node.right != null)
            postOrder(node.right);

        sb.append(node.data + "\n");
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
