import java.util.function.BiFunction;
import java.util.function.Function;

public interface ExtendedBiFunction<T, U, R>extends BiFunction<T, U, R> {

    R apply(T t, U u);

    /**
     * new Function(){
     *       @Override
     *       R apply(T t){
     *           return t;
     *       }
     *   }
     *   def fun(param a):Function{
     *      def fun1(param b):Function{
     *          return apply(a,b)
     *        }
     *      return fun1
     *   }
     *
     */
    default Function<U, R> curry1(T t) {
        System.out.println("Parameter passed to the main function is "+t);
        Function<U, R> function = (U u)->{
            System.out.println("Passing t: "+t+" and u :"+u+
                    " to BiFunction's R apply(T t, U u)");
            return apply(t, u);
        };
        return function;
    }

    default Function<T, R> curry2(U u) {
        return t -> apply(t, u);
    }
}
