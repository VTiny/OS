package osdesign.util;

import osdesign.model.PCB;
import osdesign.model.PCBState;

import java.io.IOException;
import java.util.ArrayList;

public class Banker {
	public static int resource[] = new int[3];
	public static ArrayList<PCB> waitQueue = new ArrayList<>();
	public static ArrayList<PCB> safeQueue = new ArrayList<>();
	public static int pcbNum = 0;
	private int available[] = new int[3];

	public ArrayList<PCB> getWaitQueue() {
		return waitQueue;
	}

	public void initAvailable() {
		for (int i = 0; i < 3; i++) {
			int temp = 0;
			for (PCB j : waitQueue) {
				temp += j.getAllocation()[i];
			}
			available[i] = resource[i] - temp;
		}
	}

	public boolean banker_algorithm() throws IOException {
		while (safeQueue.size() != waitQueue.size()) {
			int num = 0;
			for (PCB j : waitQueue) {
				if (j.getState() != PCBState.FINISH) {
					if(j.getMax()[0]>resource[0]){
						return false;
					}
					if(j.getMax()[1]>resource[1]){
						return false;
					}
					if(j.getMax()[2]>resource[2]){
						return false;
					}
					if (j.getNeed()[0] <= available[0]) {
						if (j.getNeed()[1] <= available[1]) {
							if (j.getNeed()[2] <= available[2]) {
								available[0] += j.getAllocation()[0];
								j.getWork()[0] += available[0];
								available[1] += j.getAllocation()[1];
								j.getWork()[1] += available[1];
								available[2] += j.getAllocation()[2];
								j.getWork()[2] += available[2];
								j.setState(PCBState.WAIT);
								safeQueue.add(j);
								j.setState(PCBState.FINISH);
								num = 0;
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
					if (num == (waitQueue.size() - safeQueue.size()) && num != 0) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public String run() throws IOException {
		initAvailable();
		if (banker_algorithm()) {
			return "存在安全序列";
		}
		return "不存在安全序列";
	}
}
