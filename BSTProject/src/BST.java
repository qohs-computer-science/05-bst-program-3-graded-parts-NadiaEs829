import java.lang.Comparable;
public class BST implements BSTInterface
{
private TreeNode root;


public BST(){
//creates an empty BST
    root = null;
}//end constructor 

public void add(Comparable newVal){
     TreeNode val = new TreeNode (newVal);
    if(root == null)
        root = val;
    else
        root = addHelper(newVal,root);
}//end add method

/*public boolean delete(Comparable old){
    if(root == null)
        return false;
    else if(root > old)
        root.setLeft(delete(root.getLeft(), old));
    else if(root < old)
        root.setRight(delete(root.getRight(), old));
    else {
        if(root.getLeft() == null && root.getRight() == null){
            root = null;
            return true;
        }//end if
        if(root.getLeft() == null)
            return false;           //???
    }//end else statement
}//end delete
*/

public void printInOrder(){
    if(root != null){
        printlnHelper(root.getLeft());
        System.out.println(root.getValue());
        printlnHelper(root.getRight());
    }//end if
}//end InOrder method

public void printPreOrder(){
    if(root != null){
        System.out.println(root.getValue());
        printlnHelper(root.getLeft());
        printlnHelper(root.getRight());
    }//end if 
}//end method

public void printPostOrder(){
    if(root != null){
        printlnHelper(root.getLeft());
        printlnHelper(root.getRight());
        System.out.println(root.getValue());
    }//end if 
}//end method

private TreeNode addHelper(Comparable newVal, TreeNode root){
    if(root == null){
        root = new TreeNode(newVal);
        return root;
    }//end if
    else if(root.value >= newVal && root.getLeft() == null)
        root.setLeft(newVal);
    else if(root.getValue() > newVal)
        addHelper(newVal, root.getLeft());
    else if(root < newVal && root.getRight() == null)
        root.setRight(newVal);
    else
        addHelper(newVal, root.getRight());
}//end addHelper method

private void printlnHelper(TreeNode subroot){
    if(subroot != null){
        printlnHelper(subroot.getLeft());
        System.out.println(subroot.getValue());
        printlnHelper(subroot.getLeft());
    }//end if
}//end printlnHelper


}//end class