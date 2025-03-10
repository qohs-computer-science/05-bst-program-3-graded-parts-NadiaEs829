/*
 * TODO: Name: Nadia Escamilla
 * TODO: Date: 2/20/25
 * TODO: Class Period: 7
 * TODO: Program Description: This program will create a BST and will be able to delete, add, and search for nodes based on the user input in a BST
 */

 import java.lang.Comparable;

 public class BSTTester {
   public static void main(String[] args) {
  //Part 1
   BST tree = new BST();
    tree.add("O");
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

  System.out.println("This is pre order:");
  tree.printPreOrder();
  System.out.println("This is post order:");
  tree.printPostOrder();
  System.out.println("This is in order:");
  tree.printInOrder();
  //Part 2
  System.out.println(" Deleting R: ");
  tree.delete("A");
  //Part 3
  //System.out.println("Current size of BST: " + tree.size());
  //System.out.println("BST is empty, T or F:  " + tree.IsEmpty());
  //System.out.println("Is Q in the BST? T or F: " + tree.find("Q"));
  //System.out.println("Replacing A with W" + tree.replace("A", "W"));
 }//end main
}//end class