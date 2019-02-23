package designpattern.component;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象构建
 * */
public interface AbstractFileKiller {
    void killVirus();  //杀毒
}


class ImageFileKiller implements AbstractFileKiller{
    private String name;

    public ImageFileKiller(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("--对图像文件:["+this.name+"]进行查杀");
    }
}

class TextFileKiller implements AbstractFileKiller{
    private String name;

    public TextFileKiller(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("--对文本文件:["+this.name+"]进行查杀");
    }
}

class VideoFileKiller implements AbstractFileKiller{
    private String name;

    public VideoFileKiller(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("--对视频文件:["+this.name+"]进行查杀");
    }
}

class FolderKiller implements AbstractFileKiller{
    private String name;

    // 定义容器，用来存放容器构建下的子节点
    private List<AbstractFileKiller> list = new ArrayList<>();

    public FolderKiller(String name) {
        this.name = name;
    }

    public void add(AbstractFileKiller killer){
        list.add(killer);
    }

    public void remove(AbstractFileKiller killer){
        list.remove(killer);
    }

    public AbstractFileKiller getChild(int index){
        return list.get(index);
    }

    @Override
    public void killVirus() {
        System.out.println("--文件夹："+this.name+"，进行查杀");

        for (AbstractFileKiller killer:list){
            killer.killVirus();
        }
    }
}
