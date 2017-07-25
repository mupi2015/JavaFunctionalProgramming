import org.junit.Test;

import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.IntFunction;

public class Converter {

    @Test
    public void simpleCurrying(){
        DoubleFunction<DoubleFunction> curriedMul = a -> b -> a * b;
        Double result = (Double) curriedMul.apply(1.609).apply(10.0);
        assert result == 16.09;
    }

    private Double applyCurryingCase1(ExtendedBiFunction<Double, Double, Double> biFunction){

        //Function<Double, Double> mi2kmConverter = biFunction.curry1(1.609);
        //double tenMilesInKm = mi2kmConverter.apply(10.0);
        return biFunction.curry1(1.609).apply(10.0);
    }

    @Test
    public void testCurrying(){
        double result = applyCurryingCase1((t, u) -> {
            return (t*u);
        });

        System.out.println(result);
        assert result == 16.09;
    }

    private Double applyCurryingCase2(ExtendedBiFunction<Double, Double, Double> biFunction){
        //F = C * 9/5 + 32
        return biFunction.curry1(9.0/5)
                .andThen(n -> n + 32)
                .apply(100.0);
    }
    @Test
    public void testCurrying2(){
        double result = applyCurryingCase2((t, u) -> {
            return (t*u);
        });

        System.out.println(result);
        assert result==212.0;
    }

    private Double applyCurryingCase3(ExtendedBiFunction<Double, Double, Double> biFunction){
        //C = (F - 32) * 5/9 => F * 5/9 - 32*5/9
        return biFunction.curry1(.554)
                .andThen(n -> n - (32*5/9))
                .apply(212.0);
    }

    @Test
    public void testCurrying3(){
        double result = applyCurryingCase3((t, u) -> {
            return (t*u);
        });

        System.out.println(result);
        assert result >= 100.0 && 101 >result;
    }




    //Flow of this
}
