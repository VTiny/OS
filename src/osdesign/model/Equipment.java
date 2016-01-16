package osdesign.model;

import java.util.*;

/**
 * Created by pokerface_lx
 */
public class Equipment {

    private String name;
    private Integer totalNumber;
    private Integer freeNumber;

    /***
     * Equipment() Equipment构造函数
     */
    public Equipment() {
        this.name = "default equipment";
        this.totalNumber = 0;
        this.freeNumber = this.totalNumber;
    }

    /***
     * Equipment(String name) Equipment构造函数
     *
     * @param name 名称
     */
    public Equipment(String name) {
        this.name = name;
        this.totalNumber = 0;
        this.freeNumber = this.totalNumber;
    }

    /***
     * Equipment(String name, int num) Equipment构造函数
     *
     * @param name 名称
     * @param num  总数量
     */
    public Equipment(String name, int num) {
        this.name = name;
        this.totalNumber = num;
        this.freeNumber = this.totalNumber;
    }

    /***
     * 判断两个设备是否相同，名称相同即两个设备相同
     *
     * @param equipment
     * @return boolean
     */
    public boolean equals(Equipment equipment) {
        if (this.getName().equals(equipment.getName())) {
            return true;
        } else {
            return false;
        }
    }

    /***
     * 判断设备是否相同，输入变量为另一设备名称
     *
     * @param name
     * @return
     */
    public boolean equals(String name) {
        if (this.getName().equals(name)) {
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public Integer getFreeNumber() {
        return freeNumber;
    }

    public void setFreeNumber(Integer freeNumber) {
        this.freeNumber = freeNumber;
    }
}
