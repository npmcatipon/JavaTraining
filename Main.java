
public class Main {
	public static void main(String[] args) {
		Book myBook = new Book();
		myBook.showTitle();
		
		myBook.title = "The Book 02";
		myBook.showTitle();		
		System.out.println("---------------------------------");
		
		House myHouse = new House();
		myHouse.showAddress();
		
		myHouse.houseNumber = 99;
		myHouse.showAddress();
		System.out.println("---------------------------------");

		Tree myTree = new Tree();
		myTree.showTree();
		
		myTree.treeType = "Groove";
		myTree.showTree();
	}
}
