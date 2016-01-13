package reference;

import java.util.*;

public class chain extends LinkedList {
    int setfree(int a) {
        int i;
        int size = this.size();
        int con = 0;
        for (i = 0; i < size; i++) {
            memory x = new memory();
            x = (memory) this.get(i);
            if (x.start == a) {
                con = x.contain;
                break;
            }
        }
        return con;
    }

    void addfree(memory a) {
        if (this.isEmpty() == true) {
            a.state = "free";
            this.addFirst(a);
        } else {
            int i;
            int size = this.size();

            for (i = 0; i < size; i++) {
                memory x = new memory();
                x = (memory) this.get(i);
                if (x.start > a.start) {

                    break;
                }
            }

            a.state = "free";
            this.add(i, a);
        }
    }

    void check() {
        int i;
        int size = this.size();

        for (i = 0; i < size - 1; i++) {
            memory x = new memory();
            x = (memory) this.get(i);
            memory y = new memory();
            y = (memory) this.get(i + 1);
            if (y.start == x.start + x.contain) {
                y.start = x.start;
                y.contain += x.contain;
                remove(i);
                i--;
                size = this.size();
            }
        }
    }

    void addwork(memory a) {
        if (this.isEmpty() == true) {
            a.state = "work";
            this.addFirst(a);
        } else {
            int i;
            int size = this.size();

            for (i = 0; i < size; i++) {
                memory x = new memory();
                x = (memory) this.get(i);
                if (x.start > a.start) {

                    break;
                }
            }

            a.state = "work";
            this.add(i, a);
        }
    }

    //申请给出的是大小，返回时初址
    int shengqing(int a) {
        int i = 0;
        int size = this.size();
        System.out.println(size);
        for (i = 0; i < size; i++) {
            memory x = new memory();
            x = (memory) this.get(i);
            if (x.contain > a) {

                int add = ((memory) this.get(i)).start;
                ((memory) this.get(i)).start = ((memory) this.get(i)).start + a;
                ((memory) this.get(i)).contain = ((memory) this.get(i)).contain - a;
                return add;
            }
            if (x.contain == a) {
                int s = x.start;
                this.remove(i);
                return s;

            }
        }
        return -1;

    }

    void removestart(int a) {
        int i = 0;
        int size = this.size();
        System.out.println(size);
        for (i = 0; i < size; i++) {
            memory x = new memory();
            x = (memory) this.get(i);
            if (x.start == a) {
                this.remove(i);
                break;
            }
        }
    }
}
