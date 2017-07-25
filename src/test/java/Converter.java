import org.junit.Test;

import java.util.function.Function;

public class Converter {

    private Double applyCurrying(ExtendedBiFunction<Double, Double, Double> biFunction){

        //Function<Double, Double> mi2kmConverter = biFunction.curry1(1.609);
        //double tenMilesInKm = mi2kmConverter.apply(10.0);
        return biFunction.curry1(1.609).apply(10.0);
    }

    @Test
    public void testCurrying(){
        double result = applyCurrying((aDouble, aDouble2) -> {
            return (aDouble*aDouble2);
        });

        System.out.println(result);
        assert result == 16.09;
    }
}
