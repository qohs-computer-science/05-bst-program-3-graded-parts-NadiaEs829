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

//Part 2
public boolean delete(Comparable old){
    if(root == null)
        return false;
    else
        return deleteHelper(old, root);
}//end delete
    
 /*for the delete helper function 
TreeNode temp = root;
while(temp.rightRC == null)
    move temp RightChild
*/
static TreeNode getSuccessor(TreeNode curr){
    curr = curr.getRight();
    while(curr != null && curr.getLeft() != null){
    curr = curr.getLeft();
    }//end while
    return curr;
}//end method


private boolean deleteHelper(Comparable old, TreeNode root){
    if(root == null)
        return false;
    if(root.getValue().compareTo(old) > 0){
        //return getLeft.deleteHelper(old,root.getLeft());
        root.setLeft(deleteHelper(old,root.getLeft()));
    }//end else if
    else if(root.getValue().compareTo(old) < 0){
        root.setRight(deleteHelper(old,root.getRight()));
    }//end else if
    else {
        //case 1 - node is a leaf
        if(root.getLeft() == null && root.getRight() == null){
            treeNCount--;
            root = null;
            return true;
        }//end if
        // case 2 - node has 1 subtree
        if(root.getLeft() == null)
            return true;
            //root.getRight()
        else if(root.getRight() == null)
            treeNCount--;
            return true;
            //root.getLeft()
        //case 3 - node has 2 subtrees
        TreeNode temp = root;
        root.setValue(getSuccessor(temp));
        if(root.getLeft() != null && root.getRight() != null)
            old = root.getSuccessor(root);

       /* while(temp.getLeft() != null){
            temp = temp.getLeft();
            if(temp == old)
                old = null;
            treeNCount--;
        */
            return true;
        //}//end while loop
            while(temp.getRight() != null){
                temp = temp.getRight();
                if(temp == old)
                old = null;
            treeNCount--;
            return true;
        }//end while loop
    }//end else statement
    return false;
}//end deleteHelper

//Part 3 - size(), IsEmpty(), find(), replace()

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
}//end IsEmpty method

public boolean find(Comparable toFind){
    if(root == null)
        return false;
    else
        return findHelper(toFind, root);
}//end find method

private boolean findHelper(Comparable toFind, TreeNode root){
    if(root == null)
        return false;
    if(root.getValue().compareTo(toFind) == 0)
        return true;

    else if(root.getValue().compareTo(toFind) > 0)
        return findHelper(toFind, root.getLeft());
    else
        return findHelper(toFind, root.getRight());
}//end of findHelper method

public boolean replace(Comparable old, Comparable toAdd){ //CHECK
    boolean foundOld = find(old);
    if(root == null)
        return false;
    else {
        if((foundOld = true))
            delete(old);
            add(toAdd);
        boolean foundToAdd = find(toAdd);
        if(foundToAdd = true)
            return true;
    }//end else if

    return false;
}//end replace method

//Print methods
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
}//end class