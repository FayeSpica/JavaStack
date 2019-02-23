package designpattern.component;

/**
 * 抽象组件
 * */
public interface Component {
    void operation();
}

/**
 * 叶子组件
 * */
interface Leaf extends Component{

}

/**
 * 容器组件
 * */
interface Container extends Component{
    void add(Component c);
    void remove(Component c);
    Component getChild(int index);
}


