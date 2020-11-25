package tema_5;

import java.util.Arrays;

public class main {

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();

		tree.insert(15);
		tree.insert(9);
		tree.insert(6);
		tree.insert(14);
		tree.insert(13);
		tree.insert(20);
		tree.insert(17);
		tree.insert(64);
		tree.insert(26);
		tree.insert(72);

		Object[] idk = tree.listPath(6);

		for (Object o : idk) {
			System.out.println(o);
		}
	}
}
