package osdesign.model;

import java.io.Serializable;

/**
 * Created by pokerface_lx
 */
public class Equipment {

    private String name;
    private EquipmentType type;
    private boolean isUsing;
    private String processName;

    public Equipment() {
        this.name = "default";
        this.isUsing = false;
        this.type = EquipmentType.TYPE_DEFAULT;
        this.processName = null;
    }

    public Equipment(String name, EquipmentType type, boolean isUsing, String processName) {
        this.name = name;
        this.type = type;
        this.isUsing = isUsing;
        this.processName = processName;
    }

    public void free() {
        this.isUsing = false;
        this.processName = null;
    }

    @Override
    public boolean equals(Object object) {
        boolean flag = false;
        if (getClass().equals(object.getClass())) {
            Equipment e = (Equipment) object;
            if (this.name.equals(e.getName())
                    && this.type.equals(e.getType())
                    && this.isUsing() == e.isUsing()
                    && this.processName.equals(e.getProcessName())) {
                flag = true;
            }
        }
        return flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EquipmentType getType() {
        return type;
    }

    public void setType(EquipmentType type) {
        this.type = type;
    }

    public boolean isUsing() {
        return isUsing;
    }

    public void setUsing(boolean using) {
        isUsing = using;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }
}
