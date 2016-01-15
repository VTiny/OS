package osdesign;

import osdesign.model.Equipment;
import osdesign.model.EquipmentRequest;
import osdesign.model.EquipmentRequestState;
import osdesign.model.EquipmentType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by pokerface_lx
 */
public class EquipmentImitate {

    private List<Equipment> equipmentListA;
    private List<Equipment> equipmentListB;
    private List<Equipment> equipmentListC;
    private List<EquipmentRequest> requestList;

    /***
     * 对设备进行初始化
     * A设备有3个，B设备有2个，C设备有5个
     */
    public void initEquipments() {
        equipmentListA = new ArrayList<>();
        equipmentListB = new ArrayList<>();
        equipmentListC = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (i < 3) {
                equipmentListA.add(new Equipment("设备A-" + (i + 1), EquipmentType.TYPE_A, false, null));
            }
            if (i < 2) {
                equipmentListB.add(new Equipment("设备B-" + (i + 1), EquipmentType.TYPE_B, false, null));
            }
            if (i < 5) {
                equipmentListC.add(new Equipment("设备C-" + (i + 1), EquipmentType.TYPE_C, false, null));
            }
        }
        System.out.println();
    }

    public void initRequests() {
        requestList = new ArrayList<>();
        System.out.println("输入设备请求队列（输入-1时结束）：");
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            System.out.println("请求名称：");
            String name = scan.next();
            if (name.equals("-1")) {
                return;
            }
            System.out.println("设备A使用时间：");
            int timeA = scan.nextInt();
            System.out.println("设备B使用时间：");
            int timeB = scan.nextInt();
            System.out.println("设备C使用时间：");
            int timeC = scan.nextInt();
            requestList.add(new EquipmentRequest(name, timeA, timeB, timeC));
        }
    }

    /***
     * 使用FCFS（First Come First Service）算法对设备请求进行处理
     */
    public void FCFS() {
        int time = 0;
        while (!requestList.isEmpty()) {
            System.out.println("---时间:" + time + "---");
            EquipmentRequest request = requestList.get(0);
            request.setState(EquipmentRequestState.WAITING);
            int timeA = request.getTimeA();
            int timeB = request.getTimeB();
            int timeC = request.getTimeC();
            for (Equipment e: equipmentListA) {

            }
        }
    }

    /***
     * 显示该时刻每个设备的使用情况
     */
    public void showState() {
        for (Equipment e : equipmentListA) {
            System.out.print("id:" + e.getName()
                    + ",using:" + e.isUsing() + ",process:" + e.getProcessName() + '\t');
        }
        System.out.println();
        for (Equipment e : equipmentListB) {
            System.out.print("id:" + e.getName()
                    + ",using:" + e.isUsing() + ",process:" + e.getProcessName() + '\t');
        }
        System.out.println();
        for (Equipment e : equipmentListC) {
            System.out.print("id:" + e.getName()
                    + ",using:" + e.isUsing() + ",process:" + e.getProcessName() + '\t');
        }
        System.out.println();
    }


}
