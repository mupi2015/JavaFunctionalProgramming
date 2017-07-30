import java.util.Objects;


@FunctionalInterface
public interface CustomFunction<T,R>{

    R apply(T t);

    default <V> CustomFunction<V, R> compose(CustomFunction<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return new CustomFunction<V, R>() {
            @Override
            public R apply(V v) {
                System.out.println("***CALL2***"+v);
                return CustomFunction.this.apply(before.apply(v));
            }
        };
    }

    default <V> CustomFunction<T, V> andThen(CustomFunction<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return new CustomFunction<T, V>() {
            @Override
            public V apply(T t) {

                return after.apply(CustomFunction.this.apply(t));
            }
        };
    }

}
