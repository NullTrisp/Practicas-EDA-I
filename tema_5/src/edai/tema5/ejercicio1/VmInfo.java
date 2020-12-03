package ejercicio1;

import java.io.Serializable;
import java.util.Calendar;

import tema_5.BinaryTree;

public class VmMeter implements Serializable, Comparable<VmMeter> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 372145882315001688L;
	private String processName;
	private Calendar startDate;
	private Calendar endDate;

	public VmMeter() {

	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	@Override
	public int compareTo(VmMeter arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static VmMeter getHighestCpuTimeVm(BinaryTree<VmMeter> tree) {
		// TODO Auto-generated method stub
		return null;
	}
}
