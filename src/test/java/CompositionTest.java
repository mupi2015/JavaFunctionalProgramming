import org.junit.Before;
import org.junit.Test;

import java.util.function.Function;

public class CompositionTest {

    Function<String,Function<String,String>> compledFunction;
    CustomFunction<String,String> flatFunction;

    @Before
    public void setup(){
        compledFunction = a->b->a+b;
        flatFunction = s->s+" Worked";
    }


    @Test
    public void conception(){

        System.out.println(flatFunction.compose(v->v+"World ").apply("Hello "));


    }


    @Test
    public void simpleCurryingTestCaseChecking(){

        //A simple case of Currying
        System.out.println(compledFunction.apply("Hello0 ").apply("World"));
    }

    @Test
    public void composeAndAndThenTest(){

        System.out.println(flatFunction.andThen(s->s+" and then").apply("Hello"));

        // s->s+" Worked"  => s =  Hello Compose2  compose
        System.out.println(flatFunction.compose(s->s+" compose ").compose(s->s+"Compose2 ").apply("Hello "));


    }

    @Test
    public void functionComposition(){
        System.out.println(compledFunction
                .apply(" Hello0 ")
                .compose(p->p+" COMPOSE ")
                .apply(" World "));

        System.out.println(compledFunction.compose(p->p+" COMPOSE ").apply("Hello").apply("World"));
    }

    @Test
    public void composeAndAndThenTestWithImplementationExpanded(){
        flatFunction = new CustomFunction<String, String>() {
            @Override
            public String apply(String s) {
                System.out.println("***MAIN FUNCTION***");
                return s.toUpperCase();
            }
        };

        System.out.println(flatFunction.compose(new CustomFunction<Object, String>() {
            @Override
            public String apply(Object s) {
                System.out.println("***CALL1***");
                return s + " compose ";
            }
        }).apply("Hello "));

        //System.out.println(flatFunction.andThen(s->s+" andThen ").apply("Hello "));


    }


    @Test
    public void composeAndAndThenTestWithImplementation(){
        flatFunction = s -> {
            System.out.println("***MAIN FUNCTION***"+s);
            return s.toUpperCase();
        };

        String ret = flatFunction.compose(s -> {
            System.out.println("***CALL1***");
            return s + " compose ";
        }).apply("Hello ");

        System.out.println(ret);

        //System.out.println(flatFunction.andThen(s->s+" andThen ").apply("Hello "));


    }

    @Test
    public void templatingExample(){

        Function<String,String> template = arg->arg.toUpperCase();

        System.out.println(template.apply("i am don 10q"));


    }









}
