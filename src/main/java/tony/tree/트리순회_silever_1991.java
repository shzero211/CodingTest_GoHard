package tony.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Node{
    char data;
    Node left;
    Node right;
    Node(char data){
        this.data=data;
    }
}
class Tree{
    public Node root;
    public void createNode(char data,char leftData,char rightData){
        if(root==null){
            root=new Node(data);
            root.left=leftData!='.'?new Node(leftData):null;
            root.right=rightData!='.'?new Node(rightData):null;
        }else{
            searchNode(root,data,leftData,rightData);
        }
    }

    public  void searchNode(Node root, char data, char leftData, char rightData) {
        if(root==null){
            return;
        }
        if(root.data==data){
            root.left=leftData!='.'?new Node(leftData):null;
            root.right=rightData!='.'?new Node(rightData):null;
        }else{
            searchNode(root.left,data,leftData,rightData);
            searchNode(root.right,data,leftData,rightData);
        }
    }
    public void preOrder(Node node)
    {
       if(node!=null){
           System.out.print(node.data);
           if(node.left!=null) preOrder(node.left);
           if(node.right!=null) preOrder(node.right);
       }
    }

    public void inOrder(Node node)
    {
        if(node!=null){

            if(node.left!=null) inOrder(node.left);
            System.out.print(node.data);
            if(node.right!=null) inOrder(node.right);
        }
    }
    public void postOrder(Node node)
    {
        if(node!=null){
            if(node.left!=null) postOrder(node.left);
            if(node.right!=null) postOrder(node.right);
            System.out.print(node.data);
        }
    }
}

public class 트리순회_silever_1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        Tree t=new Tree();
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            char data=st.nextToken().charAt(0);
            char leftData=st.nextToken().charAt(0);
            char rightData=st.nextToken().charAt(0);
            t.createNode(data,leftData,rightData);
        }
        t.preOrder(t.root);
        System.out.println();
        t.inOrder(t.root);
        System.out.println();
        t.postOrder(t.root);
    }
}
