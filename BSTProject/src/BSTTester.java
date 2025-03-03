/*
 * TODO: Name: Nadia Escamilla
 * TODO: Date: 2/20/25
 * TODO: Class Period: 7
 * TODO: Program Description: This program will create a BST and will be able to delete, add, and search for nodes based on the user input in a BST
 */

 import java.lang.Comparable;

 public class BSTTester {
   public static void main(String[] args) {
   BST tree = new BST();
   /*  tree.add("O");
    tree.add("R");
    tree.add("C");
    tree.add("H");
    tree.add("A");
    tree.add("R");
    tree.add("D");
    tree.add("Q");
    tree.add("U");
    tree.add("I");
    tree.add("N");
    tree.add("C");
    tree.add("E");
    */
    tree.add("A");
    tree.add("B");
    tree.add("C");
    tree.add("D");
  
  System.out.println("This is pre order");
  tree.printPreOrder();
  System.out.println("This is post order");
  tree.printPostOrder();
  System.out.println("This is in order");
  tree.printInOrder();
  //System.out.println("This should output no nodes");
  //System.out.println(tree.delete("O"));

	
 }//end main
}//end class