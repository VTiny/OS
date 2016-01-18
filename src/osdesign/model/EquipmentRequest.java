package osdesign.model;

/**
 * Created by pokerface_lx
 */
public class EquipmentRequest {

	private String name;
	private Integer number;

	/***
	 * EquipmentRequest() 请求的构造函数
	 */
	public EquipmentRequest() {
		this.name = "default request";
		this.number = 0;
	}

	/***
	 * EquipmentRequest(String name) 请求的构造函数
	 *
	 * @param name
	 */
	public EquipmentRequest(String name) {
		this.name = name;
		this.number = 0;
	}

	/***
	 * EquipmentRequest(String name, int number) 请求的构造函数
	 *
	 * @param name
	 * @param number
	 */
	public EquipmentRequest(String name, int number) {
		this.name = name;
		this.number = number;
	}

	/***
	 * 判断两个请求是否相同
	 *
	 * @param o
	 * @return boolean
	 */
	@Override
	public boolean equals(Object o) {
		try {
			EquipmentRequest request = (EquipmentRequest) o;
			if (this.getName().equals(request.getName()) && this.getNumber() == request.getNumber()) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
}
