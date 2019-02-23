package designpattern.iterator;

public class TestIterator {
    public static void main(String[] args){
           ConcreteMyAggregate aggregate = new ConcreteMyAggregate();
           aggregate.addObject("1");
           aggregate.addObject("2");
           aggregate.addObject("3");
           aggregate.addObject("4");

           MyIterator iterator = aggregate.iterator();
           while (iterator.hasNext()){
               System.out.println(iterator.getCurrentObj());
               iterator.next();
           }
    }
}
