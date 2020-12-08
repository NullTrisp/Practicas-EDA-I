package edai.tema5.ejercicio1;

import edai.tema5.BinaryTree;
import edai.tema5.TreeNode;

public class VmMeter {

	public static VmInfo getHighestCpuTimeVm(BinaryTree<VmInfo> vms) {
		TreeNode<VmInfo> current = vms.getRoot();
		int i;
		for (i = 0; i < vms.size(); i++) {
			if (current.getRightNode() != null) {
				current = current.getRightNode();
			} else {
				break;
			}
		}

		return current.getData();
	}
}
