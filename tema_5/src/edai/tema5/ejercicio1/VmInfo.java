package edai.tema5.ejercicio1;

import java.io.Serializable;
import java.util.Calendar;

public class VmInfo implements Serializable, Comparable<VmInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 372145882315001688L;
	private String processName;
	private Calendar startDate;
	private Calendar endDate;

	public VmInfo() {

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
	public int compareTo(VmInfo vm) {
		return (int) (((this.endDate.getTimeInMillis() - this.startDate.getTimeInMillis()) / 1000)
				- ((vm.getEndDate().getTimeInMillis() - vm.getStartDate().getTimeInMillis()) / 1000));
	}
}
