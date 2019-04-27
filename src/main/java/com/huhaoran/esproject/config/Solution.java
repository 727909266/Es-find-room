package com.huhaoran.esproject.config;

import javafx.util.Pair;
import org.joda.time.DateTime;

import java.lang.reflect.Array;
import java.math.MathContext;
import java.util.*;
import java.util.stream.Collectors;

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

    public void handle(TreeNode h) {
        if(h == null) return;
        if(h.left != null || h.right != null) {
            TreeNode t = h.left;
            h.left = h.right;
            h.right = t;
            handle(h.left);
            handle(h.right);
        }
    }

    public void Mirror(TreeNode h) {
        if(h == null) return;
        if(h.left != null || h.right != null) {
            TreeNode t = h.left;
            h.left = h.right;
            h.right = t;
            Mirror(h.left);
            Mirror(h.right);
        }
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

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    public void push(int node) {
        s1.push(node);
        if(s2.empty()) s2.push(node);
        else {
            if(node < s2.peek()) {
                s2.push(node);
            }else{
                s2.push(s2.peek());
            }
        }
    }

    public void pop() {
        s1.pop();
        s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return s2.peek();
    }

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> s = new Stack<>();
        int n = pushA.length;
        int j = 0;
        for(int i = 0 ;i < n; i++){
            s.push(pushA[i]);
            while (j <= n){
                if(!s.empty() && s.peek() == popA[j]) {
                    s.pop();
                    j++;
                } else {
                    break;
                }
            }
        }
        return s.empty();
    }

    private void adjust(int[] heap, int parent, int len) {
        for(int child = parent*2+1; child<len;child=child*2+1) {
            if(child +1 < len &&heap[child]<heap[child+1])
                child++;
            if(child>parent){
                int temp = heap[parent];
                heap[parent] = heap[child];
                heap[child] = temp;
            } else {
                break;
            }
        }
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k>input.length || k==0) {
            return new ArrayList<>();
        }
        int[] heap = new int[k];
        for(int i = 0;i<k;i++) {
            heap[i] = input[i];
        }
        for(int i = (k-2)/2;i>=0;i--){
            adjust(heap, i, k);
        }
        for(int i=k;i<input.length;i++){
            if(heap[0] > input[i]){
                heap[0] = input[i];
                adjust(heap, 0, k);
            }
        }

        for(int i=k-1;i>=0;i--){
            int t = heap[0];
            heap[0] = heap[i];
            heap[i] = t;
            adjust(heap, 0, i);
        }
        ArrayList<Integer> ans = Arrays.stream(heap).boxed().collect(Collectors.toCollection(ArrayList::new));
        return ans;

    }

    public void solve(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flag=false;
        List<List<Pair<Integer, Integer>> > ans = new ArrayList<>();
        for(int j=0;j<n;j++) {
            int x=0, y=j;
            List<Pair<Integer, Integer>> ss = new ArrayList<>();
            ss.add(new Pair<>(x, y));
            while(x>=0&&x<m&&y>=0&&y<n){
                x+=1;
                y-=1;
                if(x>=0&&x<m&&y>=0&&y<n)
                    ss.add(new Pair<>(x, y));
                    //System.out.println(String.format("i:%s, j:%s", x, y));
            }
            ans.add(ss);
        }

        for(int i=0;i<m;i++){
            int x=i;
            int y=n-1;
            List<Pair<Integer, Integer>> ss = new ArrayList<>();
            ss.add(new Pair<>(x, y));
            while(x>=0&&x<m&&y>=0&&y<n){
                x+=1;
                y-=1;
                if(x>=0&&x<m&&y>=0&&y<n)
                    ss.add(new Pair<>(x, y));
               /// System.out.println(String.format("i:%s, j:%s", x, y));
            }
            ans.add(ss);
        }

        for(int i=0;i<ans.size();i++){
            List<Pair<Integer, Integer>> x = ans.get(i);
            if(!flag){
                for(int j = x.size()-1;j>=0;j--){
                    System.out.println(String.format("i:%s, j:%s", x.get(j).getKey(),  x.get(j).getValue()));
                }
            }
            else{
                for(int j = 0;j<x.size();j++){
                    System.out.println(String.format("i:%s, j:%s", x.get(j).getKey(),  x.get(j).getValue()));
                }
            }
            flag=!flag;
        }
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length == 0) return 0;
        int sum = array[0];
        int ans = array[0];
        for(int i=1;i<array.length;i++) {
            if(array[i] + sum > array[i])
                sum = array[i] + sum;
            else
                sum = array[i];
            ans = Math.max(sum, ans);
        }
        return ans;
    }

    public int power(int a, int b){
        int ans = 1;
        int base = a;
        while(b!=0) {
            if((b & 1) != 0)
                ans *= base;
            base *= base;
            b>>=1;

        }
        return ans;
    }
    public int NumberOf1Between1AndN_Solution(int n) {
        double c = 1.0;
        if(n >c){

        }
        int bit = n/10 + 1;
        if(bit == 1) return 1;
        int ans = 0;
        int mod = 1;
        int nn = n;
        while(nn>0) {
            int curBit = nn%10;
            nn/=10;
            ans += nn*mod;
            if(curBit>1)
                ans += mod;
            else if(curBit == 1){
                ans += n%mod;
            }

            mod*=10;
        }
        return ans;

    }

    public int FirstNotRepeatingChar(String str) {
        int[] flag = new int['z'];
        for(int i=0;i<str.length();i++){
            char s = str.charAt(i);
            flag[s]++;
        }
        for(int i=0;i<str.length();i++){
            if(flag[str.charAt(i)] == 1)
                return i;
        }
        return -1;
    }

    public int GetUglyNumber_Solution(int index) {
        int[] ans = new int[index];
        ans[0] = 1;
        int f2=0,f3=0,f5=0;
        for(int i=1;i<index;i++){
            ans[i] = Math.min(Math.min(ans[f2]*2, ans[f3]*3), ans[f5]*5);
            if(ans[i] == ans[f2]*2) f2++;
            if(ans[i] == ans[f3]*3) f3++;
            if(ans[i] == ans[f5]*5) f5++;
        }
        return ans[index-1];
    }

    private void merge(int[] array, int l, int mid,int r, int[] ans){
        int leftCount = mid - l +1;
        int rightCount = r - mid;
        int[] left = new int[leftCount];
        int[] right = new int[rightCount];
        int k =0;
        for(int i=l;i<=mid;i++){
            left[k++] = array[i];
        }
        k=0;
        for(int i=mid+1;i<=r;i++){
            right[k++] = array[i];
        }
        int i = leftCount-1, j = rightCount-1;
        k = r;
        while(i>=0&&j>=0){
            if(left[i] > right[j]){
                array[k--] = left[i--];
                ans[0] = (ans[0] + j+1) %1000000007;
            }else{
                array[k--] = right[j--];
            }
        }
        for(; i>=0;i--) array[k--] = left[i];
        for(; j>=0;j--) array[k--] = right[j];

    }
    private void mergeSort(int[] array, int l, int r, int[] ans){
        if(l>=r) return ;
        int mid = (l+r) /2;
        mergeSort(array, l, mid, ans);
        mergeSort(array, mid+1, r, ans);
        merge(array, l, mid, r, ans);
    }



    public int InversePairs(int [] array) {
        int[] ans = new int[1];
        mergeSort(array, 0, array.length -1, ans);
        return ans[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Map<String, String> x = new HashMap<>();
        x.put("1", "!");
        solution.InversePairs(new int[]{3,1,2,8,1});
    }
}
