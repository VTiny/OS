package osdesign.model;

/**
 * Created by pokerface_lx
 */
public class EquipmentRequest {

    private String name;
    private Integer timeA;
    private Integer timeB;
    private Integer timeC;
    private EquipmentRequestState state;

    public EquipmentRequest() {
        this.name = "default";
        this.timeA = 0;
        this.timeB = 0;
        this.timeC = 0;
        this.state = EquipmentRequestState.DEFAULT;
    }

    /***
     * @param name
     * @param timeA
     * @param timeB
     * @param timeC
     */
    public EquipmentRequest(String name, int timeA, int timeB, int timeC) {
        this.name = name;
        this.timeA = timeA;
        this.timeB = timeB;
        this.timeC = timeC;
        this.state = EquipmentRequestState.READY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTimeA() {
        return timeA;
    }

    public void setTimeA(Integer timeA) {
        this.timeA = timeA;
    }

    public Integer getTimeB() {
        return timeB;
    }

    public void setTimeB(Integer timeB) {
        this.timeB = timeB;
    }

    public Integer getTimeC() {
        return timeC;
    }

    public void setTimeC(Integer timeC) {
        this.timeC = timeC;
    }

    public EquipmentRequestState getState() {
        return state;
    }

    public void setState(EquipmentRequestState state) {
        this.state = state;
    }
}
