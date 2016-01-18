package reference;

public class memorychain {
	int size;
	// private memory cm[];
	memory first;

	memorychain() {
		size = 50;
		first = null;
	}

	void add(memory a) {
		first = a;
		a.next = null;
	}

	/*
	 * void addfree(memory a){
	 * 
	 * } void addwork(memory a){
	 * 
	 * }
	 */
	void findfree(memory a) {
		memory cur;
		cur = first;
		a.next = cur;
		a.state = "work";
		first = a;

	}

	void findwork(memory a) {
		memory cur;
		cur = first;
		a.next = cur;
		a.state = "free";
		first = a;

	}

	// 释放空间 参数是初址
	int shengqing(int a) {
		memory cur, cur_before;
		cur = first;
		cur_before = null;
		while (cur != null && cur.contain < a) {
			cur_before = cur;
			cur = cur.next;

		}
		if (cur.contain == a) {
			int w = cur.start;
			cur_before.next = cur.next;
			return w;
		} else if (cur.contain > a) {
			int w = cur.start;
			cur.start = cur.start + a;
			cur.contain = cur.contain - a;
			return w;
		} else
			return -1;
	}

	// �ͷſռ� �����ǳ�ַ
	int setfree(int a) {
		memory cur, cur_before;
		cur = first;
		cur_before = null;
		while (cur != null) {
			if (cur.start == a) {
				break;
			}
			cur = cur.next;
			cur = cur.next;
		}
		int k = cur.contain;
		cur.next = cur.next;
		return k;
	}

	void check() {
		memory cur, cur_before;
		cur = first;
		cur_before = null;
		while (cur.next != null) {
			if (cur.next.start == cur.contain + cur.start) {
				cur.next.start = cur.start;
				cur.next.contain = cur.next.contain + cur.contain;
				cur_before.next = cur.next;
				cur = cur_before.next;
			} else
				cur_before = cur.next;
			cur = cur.next;
		}

	}

	memory getfirst() {
		return first;
	}
}
