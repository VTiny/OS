package osdesign.util;

import osdesign.model.Equipment;
import osdesign.model.EquipmentRequest;
import osdesign.model.EquipmentRunState;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pokerface_lx
 */
public class EquipmentManagement {

	// public EquipmentRequest request = null;
	public List<Equipment> equipments;
	public EquipmentRunState flag = EquipmentRunState.DEFAULT;

	String name = new String("equipments.txt");

	// public static void main(String args[]) throws IOException {
	// EquipmentManagement e = new EquipmentManagement();
	// e.firstInit();
	// e.init();
	// }

	/***
	 * 对设备队列进行初始化，默认有3个设备A，2个设备B
	 *
	 * @throws IOException
	 */
	public void firstInit() throws IOException {
		File path = new File(name);
		if (path.exists()) {
			System.out.println("file exists");
			// return;
		}
		path.createNewFile();
		FileWriter fw = new FileWriter(name);
		fw.write("设备A\n3\n3\n");
		fw.write("设备B\n2\n2\n");
		fw.flush();
		fw.close();
	}

	/***
	 * 从本地文件读取现在设备的状态
	 */
	public void init() throws IOException {
		equipments = new ArrayList<>();
		FileReader fr = new FileReader(name);
		BufferedReader br = new BufferedReader(fr);
		while (true) {
			String name = br.readLine();
			if (name == null) {
				break;
			}
			int total = Integer.parseInt(br.readLine());
			int free = Integer.parseInt(br.readLine());
			equipments.add(new Equipment(name, total, free));
		}
		br.close();
		fr.close();
	}

	/***
	 * 添加设备的函数,初始数量为0
	 *
	 * @param name
	 */
	public void add(String name) throws IOException {
		init();
		if (!this.has(name)) {
			equipments.add(new Equipment(name));
		}
		update();
	}

	/***
	 * 添加设备的函数 如果设备队列中含有此设备，则在总数量中加上相应数量 如果设备队列中没有此设备，则添加此设备，数量设置为此数量
	 *
	 * @param equipment
	 */
	public void add(Equipment equipment) throws IOException {
		init();
		for (Equipment e : equipments) {
			if (e.equals(equipment)) {
				int addNum = equipment.getTotalNumber();
				e.setTotalNumber(e.getTotalNumber() + addNum);
				e.setFreeNumber(e.getFreeNumber() + addNum);
				return;
			}
		}
		equipments.add(equipment);
		update();
	}

	/***
	 * 删除设备，变量为设备名称
	 *
	 * @param name
	 */
	public void delete(String name) throws IOException {
		init();
		for (Equipment e : equipments) {
			if (e.getName().equals(name)) {
				equipments.remove(e);
				break;
			}
		}
		update();
	}

	/***
	 * 删除设备，变量为设备
	 *
	 * @param equipment
	 */
	public void delete(Equipment equipment) throws IOException {
		init();
		for (Equipment e : equipments) {
			if (e.equals(equipment)) {
				equipments.remove(e);
			}
		}
		update();
	}

	public void alter(String name, Equipment replaceEquipment) throws IOException {
		init();
		for (Equipment e : equipments) {
			if (e.getName().equals(name)) {
				equipments.set(equipments.indexOf(e), replaceEquipment);
			}
		}
		update();
	}

	/***
	 * 查看设备队列中是否含有此设备
	 *
	 * @param equipment
	 * @return boolean
	 */
	public boolean has(Equipment equipment) throws IOException {
		init();
		for (Equipment e : equipments) {
			if (e.equals(equipment)) {
				return true;
			}
		}
		return false;
	}

	/***
	 * 查看设备队列中是否含此名称的设备
	 *
	 * @param name
	 * @return boolean
	 */
	public boolean has(String name) throws IOException {
		init();
		for (Equipment e : equipments) {
			if (e.equals(name)) {
				return true;
			}
		}
		return false;
	}

	/***
	 * 运行此函数前提是队列has（request） 相应设备的FreeNumber减去request的number
	 *
	 * @param request
	 */
	public void run(EquipmentRequest request) throws IOException {
		init();
		for (Equipment e : equipments) {
			if (e.getName().equals(request.getName())) {
				if ((e.getFreeNumber() - request.getNumber()) < 0) {
					flag = EquipmentRunState.WAITING;
					return;
				} else {
					e.setFreeNumber(e.getFreeNumber() - request.getNumber());
					flag = EquipmentRunState.RUNNING;
					return;
				}
			}
		}
		update();
	}

	/***
	 * 运行此函数前提是队列has（request） 相应设备的FreeNumber加上request的number
	 *
	 * @param request
	 */
	public void free(EquipmentRequest request) throws IOException {
		init();
		for (Equipment e : equipments) {
			if (e.equals(request.getName())) {
				e.setFreeNumber(e.getFreeNumber() + request.getNumber());
				flag = EquipmentRunState.DEFAULT;
				break;
			}
		}
		update();
	}

	/***
	 * 向本地文件中更新数据
	 *
	 * @throws IOException
	 */
	public void update() throws IOException {
		FileWriter fw = new FileWriter(name);
		StringBuilder sb = new StringBuilder();
		for (Equipment equipment : equipments) {
			sb.append(equipment.getName() + '\n');
			sb.append(equipment.getTotalNumber().toString() + '\n');
			sb.append(equipment.getFreeNumber().toString() + '\n');
		}
		fw.write(sb.toString());
		fw.flush();
		fw.close();
	}

}
