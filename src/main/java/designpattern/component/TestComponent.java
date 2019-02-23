package designpattern.component;

public class TestComponent {
    public static void main(String[] args){
        AbstractFileKiller f1,f2,f3,f4,f5,f6;
        f1 = new FolderKiller("我的收藏");
        f2 = new ImageFileKiller("f.jpg");
        f3 = new TextFileKiller("Hello.txt");

        ((FolderKiller) f1).add(f2);
        ((FolderKiller) f1).add(f3);

        f1.killVirus();

        AbstractFileKiller f11 = new FolderKiller("电影");
        f4 = new VideoFileKiller("interstrella.mp4");
        f5 = new VideoFileKiller("test.mp4");
        ((FolderKiller) f11).add(f4);
        ((FolderKiller) f11).add(f5);

        ((FolderKiller) f1).add(f11);

        f1.killVirus();
    }
}
