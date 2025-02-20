import java.lang.Comparable;

public class BST implements BSTInterface
{

public BST(){
//creates an empty BST
root = null;
}//end constructor 

public void add(comparable newVal){
    if(root = null)
        root = new TreeNode(newVal);
    else if(root.value >= newVal){
        if(root.left = null)
            root.left = new TreeNode(newVal);
        else

    }//end else if
    
}//end add method

public void printInOrder(){
    if(root != null){
        printlnHelper(root.getLeft());
        System.out.println(root.getValue);
        printlnHelper(root.getRight());
    }//end if
}//end InOrder method

public void printPreOrder(){
    if(root != null){
        System.out.println(root.getValue);
        printlnHelper(root.getLeft());
        printlnHelper(root.getRight());
    }//end if 
}//end method

public void printPostOrder(){
    if(root != null){
        printlnHelper(root.getLeft());
        printlnHelper(root.getRight());
        System.out.println(root.getValue);
    }//end if 
}//end method


private void addHelper(comparable newVal, root){
    if( root.value >= newVal && root.left == null)
        root.left = new TreeNode(newVal);
    else if(root.value >= newVal)
        addHelper(newVal, root.left);
    else if(root.value < newVal && root.right == null)
        root.right = new TreeNode(newVal);
    else
        addHelper(newVal, root.right);
}//end addHelper method



}//end class