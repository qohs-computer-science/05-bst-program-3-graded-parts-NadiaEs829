import java.lang.Comparable;
public class BST implements BSTInterface
{
private TreeNode root;


public BST(){
//creates an empty BST
    root = null;
}//end constructor 

public void add(Comparable newVal){
    if(root == null)
        root = new TreeNode(newVal);
    else if(newVal.compareTo(root.getValue()) <= 0){
        if(root.getLeft() == null)
            root.setLeft(new TreeNode(newVal));
        else 
            addHelper(newVal,root.getLeft());
    }//end else if
    else {
        if(newVal.compareTo(root.getValue()) > 0 && root.getRight() == null)
            root.setRight(new TreeNode(newVal));
        else  
            addHelper(newVal,root.getRight());
    }//end else
}//end add method

private TreeNode addHelper(Comparable newVal, TreeNode root){
   /*  if(root == null){
        root = new TreeNode(newVal);
        //return root;
    }//end if */
    if((newVal.compareTo(root.getValue()) <= 0) && root.getLeft() == null ){
        root.setLeft(new TreeNode(newVal));
        //return root;
    }//end 1st else if
    else if(newVal.compareTo(root.getValue()) < 0){
        addHelper(newVal,root.getLeft());
    }//end 2nd else if
    else if(newVal.compareTo(root.getValue()) >= 0 && root.getRight() == null) {
        root.setRight(new TreeNode(newVal));
        //return root;
    }//end 3rd else if
    else
        addHelper(newVal, root.getRight());
    return root;
}//end addHelper method

public boolean delete(Comparable old){
    if(root == null)
        return false;
    else
        root = deleteHelper(old, root); //return deleteHelper(comparable old,TreeNode root);
    return false;
}//end delete
    
/* for the delete helper function 
    else if(root > old){
        root.setLeft(delete(root.getLeft(), old));
        return 
    }
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

*/
private TreeNode deleteHelper(Comparable<TreeNode> old, TreeNode root){
    if(root == null)
        return root;
    else if(old.compareTo(root) > 0){
        
    }
    return root;
}//end deleteHelper

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

private void printlnHelper(TreeNode subroot){
    if(subroot != null){
        printlnHelper(subroot.getLeft());
        System.out.println(subroot.getValue());
        printlnHelper(subroot.getLeft());
    }//end if
}//end printlnHelper


}//end class