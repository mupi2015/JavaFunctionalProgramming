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
    public void composeAndAndThenTestWithImplementation(){
        flatFunction = new CustomFunction<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };

        System.out.println(flatFunction.compose(s->s+" compose ").apply("Hello "));
        System.out.println(flatFunction.andThen(s->s+" andThen ").apply("Hello "));


    }









}
