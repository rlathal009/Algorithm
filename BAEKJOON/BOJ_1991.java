// import java.io.*;
// import java.util.*;

// public class BOJ_1991 {

//     static class Node{
//         int left;
//         int right;

//         public Node(int left, int right){
//             this.left = left;
//             this.right = right;
//         }
//     }
//     static List<Node>[] list;
//     static int none = '.' - 'A';
    
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));      
//         int n = Integer.parseInt(br.readLine());

//         list = new ArrayList[n+1];
//         for(int i=0; i<n; i++){
//             list[i] = new ArrayList<>();
//         }

//         for(int i=0; i<n; i++){
//             String line = br.readLine();
//             StringTokenizer st = new StringTokenizer(line," ");
//             int data = st.nextToken().charAt(0) - 'A';
//             int left = st.nextToken().charAt(0) - 'A';
//             int right = st.nextToken().charAt(0) - 'A';
//             list[data].add(new Node(left, right));
//         }

//         preorder(0);
//         System.out.println();
//         inorder(0);
//         System.out.println();
//         postorder(0);
//     }

//     static void preorder(int start){
//         for(Node node : list[start]) {
//             int l = node.left;
//             int r = node.right;

//             System.out.print((char)(start+'A'));
//             if( l != none) preorder(l);
//             if( r != none) preorder(r);
//         }
//     }

//     static void inorder(int start){
//         for(Node node : list[start]){
//             int l = node.left;
//             int r = node.right;

//             if(l!= none) inorder(l);
//             System.out.print((char)(start+'A'));
//             if(r!= none) inorder(r);
//         }
//     }

//     static void postorder(int start){
//         for(Node node : list[start]){
//             int l = node.left;
//             int r = node.right;

//             if(l!= none) postorder(l);
//             if(r!= none) postorder(r);
//             System.out.print((char)(start+'A'));
//         }
//     }
// }
