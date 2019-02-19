package designpattern.adapter;


public class TestAdapter {
    public static void main(String[] args){
        NoteBookPC pc = new NoteBookPC();

        USBPS2Adapter adapter = new USBPS2AdapterImpl();

        pc.type(adapter);
    }
}
