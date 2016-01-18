package reference;

public class queue {
	int current;// 当前队列头的元素位置
	int maxsize;
	int rear;
	int fr;
	pocess pp[];

	queue(int a) {
		current = 0;
		maxsize = a;
		rear = 0;
		fr = maxsize;
		pp = new pocess[maxsize];
	}

	void add(pocess a) {
		pp[rear] = a;
		rear++;
	}

	// 删除当前的rear

	void delcurrent() {
		pp[current].state = "finish";
		current++;
	}

	pocess getout() {
		if (current == rear) {
			return null;
		} else
			return pp[current];
	}

	void addready(pocess a) {
		pp[rear] = a;
		pp[rear].state = "ready";
		rear++;
	}

	int[][] giveneeds() {
		int a[][] = new int[3][];

		for (int count = current, i = 0; count < rear; count++, i++) {
			a[0][i] = pp[count].gavensa();
			a[1][i] = pp[count].gavensb();
			a[2][i] = pp[count].gavensc();
		}
		return a;
	}

	int[][] giveown() {
		int a[][] = new int[3][];

		for (int count = current, i = 0; count < rear; count++, i++) {
			a[0][i] = pp[count].gaveosa();
			a[1][i] = pp[count].gaveosb();
			a[2][i] = pp[count].gaveosc();
		}
		return a;
	}

	void tryone(int a, int b, int c, String s) {
		int count = current;
		while (pp[count].sign.equals(s) != true) {
			count++;
		}
		pp[count].osa = pp[count].osa + a;
		pp[count].osb = pp[count].osb + b;
		pp[count].osc = pp[count].osc + c;
	}

	int givesize() {
		return rear = current;
	}

	pocess ret(int a) {
		return pp[a];
	}

	boolean checkbank() {
		int c = 0;
		for (int i = current; i < rear; i++) {
			if (pp[i].flag == 0) { // 有flag为0的话说明没有安全序列
				c = 1;
			}
		}
		if (c == 1) {
			return false;
		} else
			return true;
	}

	void huifu() { // 将wait回复原貌标志

		for (int i = current; i < rear; i++) {
			pp[i].flag = 0;

		}
	}

	int gavecur() {
		return current;
	}

	int gaverear() {
		return rear;
	}

	int giveindex(String p) {
		int i;
		for (i = current; i < rear; i++) {
			if (pp[current].sign == p) {
				break;
			}
		}
		return i;
	}

	void change(int i) {
		pp[i].state = "go";
	}
}
