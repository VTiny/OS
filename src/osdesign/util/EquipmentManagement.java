package osdesign.util;

import osdesign.model.Equipment;
import osdesign.model.EquipmentRequest;
import osdesign.model.EquipmentRunState;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pokerface_lx
 */
public class EquipmentManagement {

    //    public EquipmentRequest request = null;
    public List<Equipment> equipments;
    public EquipmentRunState flag = EquipmentRunState.DEFAULT;

    /***
     * 对设备队列进行初始化，默认有3个设备A，2个设备B
     */
    public void init() {
        equipments = new ArrayList<>();
        equipments.add(new Equipment("设备A", 3));
        equipments.add(new Equipment("设备B", 2));
    }

    /***
     * 添加设备的函数,数量为0
     *
     * @param name
     */
    public void add(String name) {
        if (!this.has(name)) {
            equipments.add(new Equipment(name));
        }
    }

    /***
     * 添加设备的函数
     * 如果设备队列中含有此设备，则在总数量中加上相应数量
     * 如果设备队列中没有此设备，则添加此设备，数量设置为此数量
     *
     * @param equipment
     */
    public void add(Equipment equipment) {
        for (Equipment e : equipments) {
            if (e.equals(equipment)) {
                int addNum = equipment.getTotalNumber();
                e.setTotalNumber(e.getTotalNumber() + addNum);
                e.setFreeNumber(e.getFreeNumber() + addNum);
                return;
            }
        }
        equipments.add(equipment);
    }

    /***
     * 删除设备，变量为设备名称
     *
     * @param name
     */
    public void delete(String name) {
        for (Equipment e : equipments) {
            if (e.equals(name)) {
                equipments.remove(e);
            }
        }
    }

    /***
     * 删除设备，变量为设备
     *
     * @param equipment
     */
    public void delete(Equipment equipment) {
        for (Equipment e : equipments) {
            if (e.equals(equipment)) {
                equipments.remove(e);
            }
        }
    }

    /***
     * 查看设备队列中是否含有此设备
     *
     * @param equipment
     * @return boolean
     */
    public boolean has(Equipment equipment) {
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
    public boolean has(String name) {
        for (Equipment e : equipments) {
            if (e.equals(name)) {
                return true;
            }
        }
        return false;
    }

    /***
     * 运行此函数前提是队列has（request）
     * 相应设备的FreeNumber减去request的number
     *
     * @param request
     */
    public void run(EquipmentRequest request) {
        for (Equipment e : equipments) {
            if (e.equals(request.getName())) {
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
    }

    /***
     * 运行此函数前提是队列has（request）
     * 相应设备的FreeNumber加上request的number
     *
     * @param request
     */
    public void free(EquipmentRequest request) {
        for (Equipment e : equipments) {
            if (e.equals(request.getName())) {
                e.setFreeNumber(e.getFreeNumber() + request.getNumber());
                flag = EquipmentRunState.DEFAULT;
                break;
            }
        }
    }
}
