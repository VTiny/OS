package reference;

public class memory {
    int start;
    int contain;
    String state;
    public memory next;

    memory() {
        contain = 0;
        state = null;

    }

    memory(int a) {
        int start = 0;
        state = new String("free");
        contain = a;


    }

    memory(String a, String b, String c) {
        start = Integer.parseInt(a);
        contain = Integer.parseInt(b);
        state = c;
    }

    memory(int a, int b) {
        start = a;
        contain = b;
    }

    void change1() {

        state = "work";

    }

    void change2(int a) {
        start = a;
    }

    void change3(int a) {
        contain = a;
    }

    int getstart() {
        return start;
    }

    int getcontain() {
        return contain;
    }

    String getstate() {
        return state;
    }
}
