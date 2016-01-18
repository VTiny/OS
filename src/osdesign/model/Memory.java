package osdesign.model;

public class Memory {
	private int star;
	private int end;
	private int length;

	public Memory(int star, int end, int length) {
		super();
		this.setStar(star);
		this.setEnd(end);
		this.setLength(length);
	}

	public Memory(int star, int end) {
		super();
		this.setStar(star);
		this.setEnd(end);
		this.setLength(end - star + 1);
	}

	public Memory() {
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + end;
		result = prime * result + length;
		result = prime * result + star;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Memory other = (Memory) obj;
		if (end != other.end)
			return false;
		if (length != other.length)
			return false;
		if (star != other.star)
			return false;
		return true;
	}

}
