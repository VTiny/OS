package reference;

import java.util.*;

public class pocesschain extends LinkedList {

	void enq(pocess a) {
		if (this.isEmpty() == true) {
			this.addFirst(a);
			System.out.println(a.sign);
		} else {
			this.add(a);
			System.out.println(a.sign);
		}
	}

	void enqready(pocess a) {
		a.state = "ready";
		if (this.isEmpty() == true) {
			this.addFirst(a);
		} else {
			this.add(a);
		}
	}

	public pocess findpocess(String a) {
		int i;
		pocess x = new pocess();
		int size = this.size();
		for (i = 0; i < size; i++) {
			Object s;
			s = this.get(i);
			x = (pocess) s;
			System.out.println(x.sign);
			if (x.gavesign().equals(a)) {
				break;
			}
		}
		if (i != size) {
			return x;
		} else
			return null;
	}

	public void tryone(int a, int b, int c, String d) {
		int i;
		int size = this.size();
		for (i = 0; i < size; i++) {
			Object s;
			pocess x = new pocess();
			s = this.get(i);
			x = (pocess) s;
			if (x.sign.equals(d)) {
				x.osa += a;
				x.osb += b;
				x.osc += c;

			}
		}
	}

	public void cancel(int a, int b, int c, String d) {
		int i;
		int size = this.size();
		for (i = 0; i < size; i++) {
			Object s;
			pocess x = new pocess();
			s = this.get(i);
			x = (pocess) s;
			if (x.sign.equals(d)) {
				x.osa -= a;
				x.osb -= b;
				x.osc -= c;

			}
		}
	}

	int[][] giveneeds() {
		int a[][] = new int[3][200];
		int size = this.size();
		System.out.print(size);
		for (int i = 0; i < size; i++) {
			pocess v = new pocess();
			v = (pocess) super.get(i);
			System.out.println(v.sign);
			a[0][i] = v.gavensa();
			a[1][i] = v.gavensb();
			a[2][i] = v.gavensc();
		}
		return a;
	}

	int[][] giveown() {
		int a[][] = new int[3][200];
		int size = this.size();
		System.out.print(size);
		for (int i = 0; i < size; i++) {
			pocess v = new pocess();
			v = (pocess) super.get(i);
			System.out.println(v.sign);
			a[0][i] = v.gaveosa();
			a[1][i] = v.gaveosb();
			a[2][i] = v.gaveosc();
		}
		return a;
	}

	boolean checkbank() {

		int size = this.size();
		for (int i = 0; i < size; i++) {
			if (((pocess) this.get(i)).flag == 0) {
				return false;
			}

		}
		return true;
	}

	void huifu() {
		int size = this.size();
		for (int i = 0; i < size; i++) {
			((pocess) this.get(i)).flag = 0;

		}
	}

	void removewait(String a) {
		int i;
		int size = this.size();
		for (i = 0; i < size; i++) {
			if (((pocess) this.get(i)).sign.equals(a)) {
				break;
			}

		}
		this.remove(i);
	}
}
