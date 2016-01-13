package reference;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.util.*;
public class osfz extends JFrame{
    int xxoo=0;

    String cc[][]=new String[100][4];
    String aa[]=new String[]{"信息1","信息2","信息3","信息4"};
    pocesschain wait=new pocesschain();//等待进程
    pocesschain ready=new pocesschain();//就绪队列
    chain   free=new chain(); //内存空闲链表
    chain  work=new chain();  //使用内存链表
    int stop=0;
    int sa;
    int sb;
    int sc;
    int sm;




    JTextField a1=new JTextField();
    JTextField a2=new JTextField();
    JTextField a3=new JTextField();
    JTextField a4=new JTextField();
    JTextField a5=new JTextField();
    JTextField a6=new JTextField();
    JTextField a7=new JTextField();
    JTextField a8=new JTextField();
    JTextField a9=new JTextField();
    JTextField a10=new JTextField();
    JTextField a11=new JTextField();
    JTextField a12=new JTextField();
    JTextField a13=new JTextField();
    JTextField a14=new JTextField();
    JTextField a15=new JTextField();
    JTextField a16=new JTextField();

    JTextField a17=new JTextField();//申请的进程名
    JTextField a18=new JTextField();//资源A的总数
    JTextField a19=new JTextField();//资源B的总数
    JTextField a20=new JTextField();//资源C的总数

    JTextField a21=new JTextField();

    JTextField xs=new JTextField();

    JTable t1=new JTable();



    public osfz(){

        super("操作系统模拟程序");
        //cc[0][0]=new String("dsd");
        //cc[0][1]=new String("dsad");
        //cc[0][2]=new String("dscccd");
        //cc[0][3]=new String("dvvsd");
        JTable t1 =new JTable(cc,aa);
        t1.setBackground(Color.WHITE);
        JScrollPane jsp =new JScrollPane(t1);
        JButton b1=new JButton("载入进程");//完成
        JButton b2=new JButton("载入初始信息");
        JButton b3=new JButton("申请");
        b3.addActionListener(new b3a());
        JButton b4=new JButton("正运行的进程");//完成
        JButton b5=new JButton("查看等待进程");
        b5.addActionListener(new b5a());
        JButton b6=new JButton("查看就绪进程");
        b6.addActionListener(new b6a());
        JButton b7=new JButton("忙碌内存表");
        b7.addActionListener(new b7a());
        JButton b8=new JButton("空闲内存表");
        b8.addActionListener(new b8a());
        JLabel xx=new JLabel("银行家算法结果");
        JButton b9=new JButton("开始模拟");//
        b9.addActionListener(new b9a());
        JButton b10=new JButton("停止模拟");//
        b10.addActionListener(new b10a());



        JLabel e1=new JLabel("进程标志");
        JLabel e2=new JLabel("父进程标志");
        JLabel e3=new JLabel("预执行时间");
        JLabel e4=new JLabel("进程状态");
        JLabel e5=new JLabel("调度优先级");
        JLabel e6=new JLabel("所需内存");
        JLabel e7=new JLabel("所需资源A");
        JLabel e8=new JLabel("所需资源B");
        JLabel e9=new JLabel("所需资源C");
        JLabel e10=new JLabel("拥有资源A");
        JLabel e11=new JLabel("拥有资源B");
        JLabel e12=new JLabel("拥有资源C");
        JLabel e13=new JLabel("初始资源A");
        JLabel e14=new JLabel("初始资源B");
        JLabel e15=new JLabel("初始资源C");
        JLabel e16=new JLabel("最大内存");

        JLabel e17=new JLabel("申请资源:");
        JLabel e18=new JLabel("进程名");
        JLabel e19=new JLabel("资源A数");
        JLabel e20=new JLabel("资源B数");
        JLabel e21=new JLabel("资源C数");

        e1.setBounds(10,0,70,20);
        e2.setBounds(10,30,70,20);
        e3.setBounds(10,60,70,20);
        e4.setBounds(10,90,70,20);
        e5.setBounds(10,120,70,20);
        e6.setBounds(10,150,70,20);
        e7.setBounds(10,180,70,20);
        e8.setBounds(10,210,70,20);
        e9.setBounds(10,240,70,20);
        e10.setBounds(10,270,70,20);
        e11.setBounds(10,300,70,20);
        e12.setBounds(10,330,70,20);

        e13.setBounds(180,10,70,20);
        e14.setBounds(270,10,70,20);
        e15.setBounds(360,10,70,20);
        e16.setBounds(450,10,70,20);

        a13.setBounds(180,50,70,20);
        a14.setBounds(270,50,70,20);
        a15.setBounds(360,50,70,20);
        a16.setBounds(450,50,70,20);
        a21.setBounds(540,50,150,20);


        a1.setBounds(90,0,70,20);
        a2.setBounds(90,30,70,20);
        a3.setBounds(90,60,70,20);
        a4.setBounds(90,90,70,20);
        a5.setBounds(90,120,70,20);
        a6.setBounds(90,150,70,20);
        a7.setBounds(90,180,70,20);
        a8.setBounds(90,210,70,20);
        a9.setBounds(90,240,70,20);
        a10.setBounds(90,270,70,20);
        a11.setBounds(90,300,70,20);
        a12.setBounds(90,330,70,20);

        e17.setBounds(50,400,100,20);
        e18.setBounds(10,430,70,20);
        e19.setBounds(10,460,70,20);
        e20.setBounds(10,490,70,20);
        e21.setBounds(10,520,70,20);

        a17.setBounds(90,430,70,20);
        a18.setBounds(90,460,70,20);
        a19.setBounds(90,490,70,20);
        a20.setBounds(90,520,70,20);

        b1.setBounds(50,360,100,20);//载入进程
        b1.addActionListener(new b1a());
        b2.setBounds(240,90,150,20);
        b2.addActionListener(new b2a());
        b3.setBounds(50,550,80,20);
        b4.setBounds(540,90,150,20);
        b5.setBounds(540,130,150,20);
        b6.setBounds(540,170,150,20);
        b7.setBounds(540,210,150,20);
        b8.setBounds(540,250,150,20);
        xx.setBounds(540,290,150,20);
        xs.setBounds(540,330,150,20);
        b9.setBounds(540,370,150,40);
        b10.setBounds(540,430,150,40);

        jsp.setBounds(180,130,340,440);


        a13.setHorizontalAlignment(JTextField.CENTER);
        a14.setHorizontalAlignment(JTextField.CENTER);
        a15.setHorizontalAlignment(JTextField.CENTER);
        a16.setHorizontalAlignment(JTextField.CENTER);
        this.getContentPane().add(e1);
        this.getContentPane().add(e2);
        this.getContentPane().add(e3);
        this.getContentPane().add(e4);
        this.getContentPane().add(e5);
        this.getContentPane().add(e6);
        this.getContentPane().add(e7);
        this.getContentPane().add(e8);
        this.getContentPane().add(e9);
        this.getContentPane().add(e10);
        this.getContentPane().add(e11);
        this.getContentPane().add(e12);
        this.getContentPane().add(e13);
        this.getContentPane().add(e14);
        this.getContentPane().add(e15);
        this.getContentPane().add(e16);
        this.getContentPane().add(e17);
        this.getContentPane().add(e18);
        this.getContentPane().add(e19);
        this.getContentPane().add(e20);
        this.getContentPane().add(e21);
        this.getContentPane().add(a21);




        this.getContentPane().add(a1);
        this.getContentPane().add(a2);
        this.getContentPane().add(a3);
        this.getContentPane().add(a4);
        this.getContentPane().add(a5);
        this.getContentPane().add(a6);
        this.getContentPane().add(a7);
        this.getContentPane().add(a8);
        this.getContentPane().add(a9);
        this.getContentPane().add(a10);
        this.getContentPane().add(a11);
        this.getContentPane().add(a12);
        this.getContentPane().add(a13);
        this.getContentPane().add(a14);
        this.getContentPane().add(a15);
        this.getContentPane().add(a16);
        this.getContentPane().add(a17);
        this.getContentPane().add(a18);
        this.getContentPane().add(a19);
        this.getContentPane().add(a20);



        t1.setBackground(Color.WHITE);
        this.getContentPane().add(b1);
        this.getContentPane().add(b2);
        this.getContentPane().add(b3);
        this.getContentPane().add(b4);
        this.getContentPane().add(b5);
        this.getContentPane().add(b6);
        this.getContentPane().add(b7);
        this.getContentPane().add(b8);
        this.getContentPane().add(b9);
        this.getContentPane().add(b10);
        this.getContentPane().add(xx);
        this.getContentPane().add(xs);
        this.getContentPane().add(jsp);

        this.setLocation(180,100);
        this.setLayout(null);
        this.setSize(800,650);
        this.setVisible(true);

    }
    String[][] cao(chain str){
        String a[][]=new String [100][4];
        int con=str.size();
        for(int i=0;i<con;i++)
        {

            memory p=new memory();
            p=(memory)str.get(i);
            a[i][0]=Integer.toString(p.getstart());;
            a[i][1]=Integer.toString(p.getcontain());
            a[i][2]=p.getstate();
            a[i][3]="内存链";
        }


        return a;

    }


    String[][] cun(pocesschain str){
        String a[][]=new String [100][4];

        int count=str.size();

        for(int i=0;i<count;i++)
        {   pocess pt=new pocess();
            pt=(pocess)str.get(i);
            // System.out.println(pt.gavesign());
            // System.out.println("1");
            a[i][0]=pt.gavesign();
            a[i][1]=Integer.toString(pt.gavedotime());
            a[i][2]=Integer.toString(pt.gaveneed());
            a[i][3]=pt.gavestate();

        }

        return a;

    }

    void jj(String a[][],String b[][])
    {   int i=0,j=0;
        while(b[i][0]!=null){

            while(j<4){

                a[i][j]=b[i][j];
                if(j==0){
                    System.out.println(a[i][j]);
                }
                j++;
            }
            i++;
            j=0;

        }
        while(a[i][0]!=null){

            while(j<4){

                a[i][j]="";
                if(j==0){
                    System.out.println(a[i][j]);
                }
                j++;
            }
            i++;
            j=0;
        }

    }

    //二维数组的赋值
    void pass(int a[][],int b[][],int size){
        for(int i=0;i<3;i++){
            for(int j=0;j<size;j++){
                a[i][j]=b[i][j];
            }
        }
    }
    //编写一个银行家算法
    boolean bank(int a1,int b1,int c1,int a2,int b2,int c2,String pname,pocesschain w)
    {
        int a=a1-a2;
        int b=b1-b2;
        int c=c1-c2;
        w.tryone(a2,b2,c2,pname);
        int ns[][]=new int[3][200];
        int os[][]=new int[3][200];
        int ss=w.size();
        for(int i=0;i<3;i++){
            for(int j=0;j<ss;j++){
                ns[i][j]=(w.giveneeds())[i][j];
                os[i][j]=(w.giveown())[i][j];
            }
        }
        //  pass(ns,w.giveneeds(),ss);
        //	pass(ns,w.giveown(),ss);       //这边可能有点问题
        System.out.print("大小");
        System.out.println(ss);
        System.out.println(os[0][4]);
        System.out.println(os[1][4]);
        System.out.println(os[2][4]);
        System.out.println(ns[0][4]);
        System.out.println(ns[1][4]);
        System.out.println(ns[2][4]);
        w.huifu();
        for(int i=0;i<ss;i++){
            for(int j=0;j<ss;j++){
                System.out.println(j);
                if(((pocess)w.get(j)).flag==0&&os[0][j]+a>=ns[0][j]&&os[1][j]+b>=ns[1][j]&&os[2][j]+c>=ns[2][j])
                {
                    System.out.println(i);
                    System.out.println(j);
                    ((pocess)w.get(j)).flag=1;
                    System.out.println("标志");
                    System.out.println(((pocess)w.get(j)).flag);
                    System.out.println("资源");
                    a+=os[0][j];
                    System.out.println(a);
                    b+=os[1][j];
                    System.out.println(b);
                    c+=os[2][j];
                    System.out.println(c);
                }

            }

        }
        return w.checkbank();
    }
    class b1a implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            pocess p=new pocess(a1.getText(),a2.getText(),a3.getText(),a4.getText(),a5.getText(),a6.getText(),a7.getText(),a8.getText(),a9.getText(),a10.getText(),a11.getText(),a12.getText());
            System.out.println(p.gavesign());
            wait.enq(p);
            //System.out.println(wait.ret(xxoo).gavesign());
            //xxoo++;
        }
    }
    class b2a implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            sa=Integer.parseInt(a13.getText());//资源A
            System.out.println(sa);
            sb=Integer.parseInt(a14.getText());//资源B
            System.out.println(sb);
            sc=Integer.parseInt(a15.getText());//资源C
            System.out.println(sc);
            sm=Integer.parseInt(a16.getText());//内存资源
            System.out.println(sm);
            memory m=new memory(sm);
            free.addFirst(m);

        }
    }
    class b9a implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {

            new Thread(new Runnable() {
                public void run() {
                    while(ready.size()!=0&&stop!=1)
                    {
                        pocess run=new pocess();
                        run=(pocess)ready.getFirst();
                        ready.removeFirst();
                        run.changestate("runing");
                        a21.setText(run.gavesign());
                        System.out.println(run.gavesign());
                        //释放内存
                        int contain=work.setfree(run.gavemem());
                        work.removestart(run.gavemem());
                        memory gg=new memory(run.gavemem(),contain);
                        free.addfree(gg);
                        free.check();
                        try{Thread.sleep(run.dotime);}
                        catch(InterruptedException ex){System.out.println("error!");}
                    }
                }
            }).start();
        }
    }
    class b10a implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {

            stop=1;
        }
    }
    class b3a implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {


            if(bank(sa,sb,sc,Integer.parseInt(a18.getText()),Integer.parseInt(a19.getText()),Integer.parseInt(a20.getText()),a17.getText(),wait)==true)
            {
                String a=a17.getText();
                System.out.print(a);
                pocess zanshi =new pocess();
                zanshi=wait.findpocess(a);
                if(zanshi.checkpocess()==true){
                    //System.out.println(zanshi.need);
                    int address=free.shengqing(zanshi.need);
                    memory hh=new memory(address,zanshi.need);
                    work.addwork(hh);
                    zanshi.setadd(address);
                    ready.enqready(zanshi);
                    xs.setText("予以分配");
                    wait.removewait(a);
                    sa-=Integer.parseInt(a18.getText());
                    sb-=Integer.parseInt(a19.getText());
                    sc-=Integer.parseInt(a20.getText());
                }
                else
                {
                    xs.setText("予以分配");
                    sa-=Integer.parseInt(a18.getText());
                    sb-=Integer.parseInt(a19.getText());
                    sc-=Integer.parseInt(a20.getText());
                }
            }
            else
            {
                wait.cancel(Integer.parseInt(a18.getText()),Integer.parseInt(a19.getText()),Integer.parseInt(a20.getText()),a17.getText());
                xs.setText("会发生死锁不予支持");
            }
            wait.huifu();

        }
    }
    class b5a implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            jj(cc,cun(wait));
            repaint();

        }
    }
    class b6a implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            jj(cc,cun(ready));
            repaint();

        }
    }
    class b7a implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            jj(cc,cao(work));
            repaint();

        }
    }
    class b8a implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            jj(cc,cao(free));
            repaint();

        }
    }
}

