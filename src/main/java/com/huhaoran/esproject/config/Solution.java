package com.huhaoran.esproject.config;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int JumpFloor(int target) {
        return 2<<(target - 1);
    }
    /*
    public int[][] matrixMul(int[][] m1, int[][] m2) {

    }
    */
    public int NumberOf1(int n) {
        int ans = 0;
        while(n!=0) {
            n=n&(n-1);
            ans++;
        }
        return ans;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public double Power(double base, int exponent) {
        double ans = 1;
        int k = Math.abs(exponent);
        while(k!=0) {
            if((k&1) != 0)
                ans*=base;
            base*=base;
            k>>=1;
        }
        return exponent > 0? ans:1/ans;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public boolean check(TreeNode root1,TreeNode root2) {
        if(root2 == null) return true;
        if(root1 == null) return false;
        if(root1.val == root2.val) {
            return check(root1.left, root2.left) && check(root1.right, root2.right);
        }
        return false;
    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null) return false;
        return check(root1, root2) || check(root1.left, root2) || check(root1.right, root2);
    }

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        int up = 0;
        int down = matrix.length - 1;
        if(down == -1)
            return ans;
        int left = 0;
        int right = matrix[0].length - 1;
        if(right == -1) return ans;
        while(left <= right && up <= down) {
            for(int i = left; i<= right; i++){
                ans.add(matrix[up][i]);
            }
            for(int i = up + 1; i<= down; i++){
                ans.add(matrix[i][right]);
            }
            if(down == up) break;
            for(int i = right - 1; i>= left; i--){
                ans.add(matrix[down][i]);
            }
            if(left == right) break;
            for(int i = down - 1; i>= up + 1; i--){
                ans.add(matrix[i][left]);
            }
            left++; right--; up++; down--;
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.JumpFloor(1));
    }
}
