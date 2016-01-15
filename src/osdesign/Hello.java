package osdesign;

import osdesign.model.Equipment;
import osdesign.model.EquipmentType;

/**
 * Created by pokerface_lx
 */
public class Hello {
    public static void main(String[] args) {
        new EquipmentImitate().initEquipments();
        String s1 = new String("test");
        String s2 = new String("tes");
        s2 = s2 + 't';
        Equipment e1 = new Equipment(s1, EquipmentType.TYPE_A, true);
        Equipment e2 = new Equipment(s2, EquipmentType.TYPE_A, true);
        System.out.println(e1.equals(e2));
    }
}
