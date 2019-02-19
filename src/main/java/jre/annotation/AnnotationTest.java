package jre.annotation;

@Controller
public class AnnotationTest {

    @Override
    public String toString(){
        return null;
    }

    public static void main(String[] args){

    }

    @GetMapping(value = "/user")
    public void getUsers(){

    }
}
