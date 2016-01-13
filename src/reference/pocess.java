package reference;

public class pocess {
    String sign;                //进程标志
    String farsign;             //父进程的标志
    int dotime;                 //所需执行时间
    String state;               //进程状态
    int pri;                    //调度优先级
    int need;                   //所需的内存
    int nsa;                    //所需的资源A
    int nsb;                    //所需的资源B
    int nsc;                    //所需的资源C
    int osa;                    //已有的资源A
    int osb;                    //已有的资源B
    int osc;                    //已有的资源C
    int flag;

    pocess() {
        sign = new String("start");
        farsign = new String();
        state = new String("等待");
        int dotime = 10000;
        flag = 0;

    }

    pocess(String a1, String a2, String a3, String a4, String a5, String a6, String a7, String a8, String a9, String a10, String a11, String a12) {
        sign = new String(a1);
        farsign = new String(a2);
        dotime = Integer.parseInt(a3);
        state = new String(a4);
        pri = Integer.parseInt(a5);
        need = Integer.parseInt(a6);
        nsa = Integer.parseInt(a7);
        nsb = Integer.parseInt(a8);
        nsc = Integer.parseInt(a9);
        osa = Integer.parseInt(a10);
        osb = Integer.parseInt(a11);
        osc = Integer.parseInt(a12);
        flag = 0;
    }

    void changestate(String s) {
        state = s;

    }

    int gettime() {
        return dotime;
    }

    boolean changeos(int a, int b, int c) {
        osa = osa + a;
        osb = osb + b;
        osc = osc + c;
        if (osa == nsa && osb == nsb && osc == nsb) {
            return (true);
        } else
            return (false);
    }

    void exchange(pocess a) {
        this.dotime = a.dotime;
        this.farsign = a.farsign;
        this.need = a.need;
        this.nsa = a.nsa;
        this.nsb = a.nsb;
        this.nsc = a.nsc;
        this.osa = a.osa;
        this.osb = a.osb;
        this.osc = a.osc;
        this.pri = a.pri;
        this.sign = a.sign;
        this.state = a.state;
    }

    String gavesign() {
        return sign;
    }

    int gavemem() {
        return need;
    }

    void setadd(int a) {
        need = a;
    }

    int gavensa() {
        return nsa;
    }

    int gavensb() {
        return nsb;
    }

    int gavensc() {
        return nsc;
    }

    int gaveosa() {
        return osa;
    }

    int gaveosb() {
        return osb;
    }

    int gaveosc() {
        return osc;
    }

    int gavedotime() {
        return dotime;
    }

    int gaveneed() {
        return need;
    }

    String gavestate() {
        return state;
    }

    boolean checkpocess() {
        if (nsa == osa && nsb == osb && nsc == osc) {
            return true;
        } else
            return false;
    }
}
