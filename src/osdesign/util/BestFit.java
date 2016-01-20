package osdesign.util;

import osdesign.model.MemState;
import osdesign.model.Memory;
import osdesign.model.PCB;
import osdesign.model.PCBState;

import java.util.ArrayList;

public class BestFit {
	public static ArrayList<Memory> kongxianList = new ArrayList<Memory>();

	public void initMemory() {
		Memory Memory = new Memory(0, 1024);
		kongxianList.add(Memory);
	}

	public Memory alloc(int MemoryLength) {
		Memory nf = null;
		for (Memory object : kongxianList) {
			if (object.getLength() >= MemoryLength && object.getMemState().equals(MemState.unused)) {
				nf = new Memory(object.getStar(), object.getStar() + MemoryLength - 1, MemoryLength);
				int i = kongxianList.indexOf(object);
				kongxianList.remove(i);
				if (object.getLength() > MemoryLength) {
					Memory nl = new Memory(nf.getEnd() + 1, object.getEnd());
					kongxianList.add(i, nl);
				}
				break;
			}
		}
		if (nf == null) {
			return nf;
		}
		return nf;
	}

	public void free(Memory f) {
		Memory fm = f;
		for (Memory Memory : kongxianList) {
			if (fm.getEnd() < Memory.getStar()) {
				int i = kongxianList.indexOf(Memory);
				kongxianList.add(i, fm);
				break;
			}
		}
		for (int i = 0; i < kongxianList.size() - 1; i++) {
			Memory mc = kongxianList.get(i);
			for (int j = 0; j < kongxianList.size(); j++) {
				Memory mn = kongxianList.get(j);
				if (mc.getEnd() == mn.getStar() - 1) {
					mc.setEnd(mn.getEnd());
					mc.setLength(mc.getEnd() - mc.getStar() + 1);
					kongxianList.remove(mn);
				}
			}
		}
		for (int i = 0; i < kongxianList.size() - 1; i++) {
			for (int j = i + 1; j < kongxianList.size(); j++) {
				if (kongxianList.get(i).getLength() > kongxianList.get(j).getLength()) {
					Memory temp1 = kongxianList.get(i);
					Memory temp2 = kongxianList.get(j);
					kongxianList.remove(i);
					kongxianList.add(i, temp2);
					kongxianList.remove(j);
					kongxianList.add(j, temp1);
				}
			}
		}
	}
}
