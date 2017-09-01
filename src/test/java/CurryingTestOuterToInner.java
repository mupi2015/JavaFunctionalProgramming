import org.junit.Test;

import java.util.function.Function;

public class CurryingTestOuterToInner {


    @Test
    public void curryingTestOneInDetails(){

        Function<Double,Function<Double,Double>> method1 = new Function<Double, Function<Double, Double>>() {
            @Override
            public Function<Double, Double> apply(Double aDouble) {
                return new Function<Double, Double>() {
                    @Override
                    public Double apply(Double bDouble) {
                        return aDouble*bDouble;
                    }
                };
            }
        };
        //Calling From Outer to Inner
        System.out.println(method1.apply(1.5).apply(1.5));
    }

    @Test
    public void curryingTestOneInDetailsLess1(){

        Function<Double,Function<Double,Double>> method1 = (Double aDouble) -> new Function<Double, Double>() {
            @Override
            public Double apply(Double bDouble) {
                return aDouble*bDouble;
            }
        };
        System.out.println(method1.apply(1.5).apply(1.5));
    }

    @Test
    public void curryingTestOneInDetailsLess2(){
        Function<Double,Function<Double,Double>> method1 = aDouble -> bDouble -> aDouble*bDouble;

        System.out.println(
                method1
                        .apply(1.5)
                        .andThen(s->s-10)
                        .apply(1.5)
        );
    }

}
