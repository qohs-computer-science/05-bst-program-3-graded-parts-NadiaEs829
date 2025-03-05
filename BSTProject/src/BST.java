import java.lang.Comparable;
public class BST implements BSTInterface
{
private TreeNode root;
private int treeNCount;

public BST(){
//creates an empty BST
    root = null;
    treeNCount = 0;
}//end constructor 

public void add(Comparable newVal){
    root = addHelper(newVal, root);
    treeNCount++;
}//end add method

private TreeNode addHelper(Comparable newVal, TreeNode root){
    if(root == null)
        root = new TreeNode(newVal);
    else if(root.getValue().compareTo(newVal) == 0 && root.getLeft() == null){
        //newVal.compareTo(root.getValue())     
        root.setLeft(addHelper(newVal,root.getLeft()));
        //new TreeNode(newVal)
    }//end 1st if
    else if(root.getValue().compareTo(newVal) >= 0){
        //newVal.compareTo(root.getValue()
        if(root.getLeft() == null)
            root.setLeft(new TreeNode(newVal));
        else 
            addHelper(newVal,root.getLeft());
    }//end 2nd else if 
    else if(newVal.compareTo(root.getValue()) < 0 && root.getRight() == null) {
       //if(root.getRight() == null)
            root.setRight(new TreeNode(newVal));
    }//end 3rd else if
    else
        root.setRight(addHelper(newVal, root.getRight()));
    return root;
}//end addHelper method

public boolean delete(Comparable old){
    if(root == null)
        return false;

    if(old.compareTo(root.getValue()) < 0)
        root.setLeft(deleteHelper(old, root.getLeft()));
    else if(old.compareTo(root.getValue()) > 0)
        root.setRight(deleteHelper(old, root.getRight()));
    else{
        //case 1: no kids
        if(root.getLeft() == null){
            root = null;
            return false;
        }
        //case 2: 1 kid
        if(root.getRight() == null && old == root){
            //System.out.println(root.getLeft());
            root = root.getLeft();
            return true;
        }
        TreeNode succ = getSuccessor(root);
        root.setValue(succ.getValue());
        root.setRight(deleteHelper(old,root.getRight()));
    }//end else
    treeNCount--;
    return false;
}//end delete
    
 /*for the delete helper function 
TreeNode temp = root;
while(temp.rightRC == null)
    move temp RightChild
*/
private TreeNode deleteHelper(Comparable old, TreeNode root){
    if(root == null)
        return root;
    else if(old.compareTo(root.getValue()) < 0){ //root > old
        root.setLeft(deleteHelper(old,root.getLeft()));
    }
    else if(old.compareTo(root.getValue()) > 0) //root < old
        root.setRight(deleteHelper(old,root.getRight()));
    else {
        if(root.getLeft() == null && root.getRight() == null){
            root = null;
        }//end if
        if(root.getLeft() == null){
            return root;
        }//end if statement
                 //???
    }//end else statement{
    return root;
}//end deleteHelper

public int size(){
    if(root == null)
        return 0;
    else 
        return treeNCount;
}//end size method

public boolean IsEmpty(){
if(root != null)
    return false;
else 
    return true;
}//end method

public boolean find(Comparable toFind){ //finish this
    if(root == null)
        return false;
    else if(toFind.compareTo(root.getValue()) == 0){
        return true;
    }//end else if
    else
        return false;
}//end method

public boolean replace(Comparable old, Comparable toAdd){
if(root == null)
    return false;
    else if()
else 
    return true;
}//end replace method

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
        printlnHelper(subroot.getRight()); //changed subroot.getLeft() --> subroot.getRight()
    }//end if
}//end printlnHelper

static TreeNode getSuccessor(TreeNode curr){
    curr = curr.getRight();
    while(curr != null && curr.getLeft() != null){
    curr = curr.getLeft();
    }//end while
    return curr;
}//end method
}//end class