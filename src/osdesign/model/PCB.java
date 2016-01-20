package osdesign.model;

public class PCB {
	public static int idNum = 1;// 默认ID
	private int ID;
	private int[] Max = new int[3];// 最大需求矩阵
	private int[] Allocation = new int[3];// 已分配矩阵
	private int[] Need = new int[3];// 需求矩阵
	private int[] Work = new int[3];
	private PCBState state;// PCB状态
	private int memory;// 所需内存
	private int runTime;// 运行时间

	public int[] getWork() {
		return Work;
	}

	public void setWork(int[] work) {
		Work = work;
	}

	public PCB() {
		ID = idNum;
		idNum++;
		state = PCBState.WAIT;
	}

	public static int getIdNum() {
		return idNum;
	}

	public static void setIdNum(int idNum) {
		PCB.idNum = idNum;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public PCBState getState() {
		return state;
	}

	public void setState(PCBState state) {
		this.state = state;
	}

	public int getRunTime() {
		return runTime;
	}

	public void setRunTime(int runTime) {
		this.runTime = runTime;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public int[] getMax() {
		return Max;
	}

	public void setMax(int[] max) {
		Max = max;
	}

	public int[] getAllocation() {
		return Allocation;
	}

	public void setAllocation(int[] allocation) {
		Allocation = allocation;
	}

	public int[] getNeed() {
		return Need;
	}

	public void setNeed(int[] need) {
		Need = need;
	}
}
