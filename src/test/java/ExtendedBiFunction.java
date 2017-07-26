import java.util.function.BiFunction;
import java.util.function.Function;

public interface ExtendedBiFunction<T, U, R>extends BiFunction<T, U, R> {

    R apply(T t, U u);

    /*Its line return new Function(){
         @Override
         R apply(T t){
             return t;
        }
     }*/
    default Function<U, R> curry1(T t) {
        System.out.println("Parameter passed to the main function is "+t);
        return (U u) -> {
            System.out.println("Passing t: "+t+" and u :"+u+" to BiFunction's R apply(T t, U u)");
            return apply(t, u);
        };
    }

    default Function<T, R> curry2(U u) {
        return t -> apply(t, u);
    }
}
