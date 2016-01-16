package osdesign.util;

import osdesign.model.PCB;
import osdesign.model.PCBState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Banker {
	private int resource[] = new int[3];
	private int work[] = new int[3];
	private ArrayList<PCB> waitQueue = new ArrayList<>();
	public static ArrayList<PCB> safeQueue = new ArrayList<>();
	private int pcbNum;
	Scanner in = new Scanner(System.in);

	public void setResource() {
		System.out.print("请输入A类资源的总数量:");
		resource[0] = in.nextInt();
		System.out.print("请输入B类资源的总数量:");
		resource[1] = in.nextInt();
		System.out.print("请输入C类资源的总数量:");
		resource[2] = in.nextInt();
	}

	// public void setPcbNum(int pcbNum) {
	// this.pcbNum = pcbNum;
	// }
	public void setPcbNum() {
		System.out.println("请输入CPU等待队列中进程的总数量");
		pcbNum = in.nextInt();
	}

	public ArrayList<PCB> getWaitQueue() {
		return waitQueue;
	}

	public void setWaitQueue() {
		for (int i = 0; i < pcbNum; i++) {
			PCB bd = new PCB();
			int[] max = new int[3];
			int[] need = new int[3];
			int[] allocation = new int[3];
			for (int j = 0; j < 3; j++) {
				System.out.println("请输入本进程" + (char) ('A' + j) + "类资源的情况");
				System.out.print("MAX:");
				max[j] = in.nextInt();
				System.out.print("NEED:");
				need[j] = in.nextInt();
				System.out.print("ALLOCATION:");
				allocation[j] = in.nextInt();
			}
			bd.setAllocation(allocation);
			bd.setMax(max);
			bd.setNeed(need);
			waitQueue.add(bd);
			System.out.println();
		}
	}

	public void initWork() {
		for (int i = 0; i < 3; i++) {
			int temp = 0;
			for (PCB j : waitQueue) {
				temp += j.getAllocation()[i];
			}
			work[i] = resource[i] - temp;
		}
	}

	public boolean banker_algorithm() {
		while (safeQueue.size()!=waitQueue.size()) {
			int num = 0;
			for (PCB j : waitQueue) {
				if (j.getState()!= PCBState.FINISH) {
					if (j.getNeed()[0] < work[0]) {
						if (j.getNeed()[1] < work[1]) {
							if (j.getNeed()[2] < work[2]) {
								work[0] += j.getAllocation()[0];
								work[1] += j.getAllocation()[1];
								work[2] += j.getAllocation()[2];
								j.setState(PCBState.WAIT);
								safeQueue.add(j);
								j.setState(PCBState.FINISH);
							} else {
								num++;
								continue;
							}
						} else {
							num++;
							continue;
						}
					} else {
						num++;
						continue;
					}
					if (num == (waitQueue.size()-safeQueue.size())&&num!=0) {
						return false;
					}
				}
			}
		}
		return true;
	}

	@Override
	public String toString() {
		PCB i = waitQueue.get(0);
		String a = " MAX\t Need\tAllocation\n";
		String b = "A B C\t A B C\t  A B C\t\tA B C\n";
		String c = Arrays.toString(i.getMax());
		String d = Arrays.toString(i.getNeed());
		String e = Arrays.toString(i.getAllocation());
		String f = a + b + c + d + e + "\n";
		return f;
	}

	public void run() {
		setResource();
		setPcbNum();
		setWaitQueue();
		initWork();
		if (banker_algorithm()) {
			System.out.println("成功");
		} else {
			System.out.println("失败");
		}
	}
}
