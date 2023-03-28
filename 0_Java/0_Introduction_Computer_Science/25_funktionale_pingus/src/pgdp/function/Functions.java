package pgdp.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Functions {
    public static <A, B> List<B> map(List<A> toMap, Function<A, B> function) {
        var list = new ArrayList<B>();

        for (A a : toMap) {
            list.add(function.apply(a));
        }

        return list;
    }

    public static List<Integer> square(List<Integer> toSquare) {
        return map(toSquare, (a) -> (a * a));
    }

    public static <A> List<String> toString(List<A> toString) {
        return map(toString, (a) -> (a.toString()));
    }

    public static <A> List<A> filter(List<A> toFilter, Predicate<A> filter) {
        List<A> filteredList = new ArrayList<A>();

        for (A a : toFilter){
            if(filter.test(a)) {
                filteredList.add(a);
            }
        }

        return filteredList;
    }

    public static <A> List<A> filterAny(List<A> toFilter, Predicate<A> filter1, Predicate<A> filter2) {
        return filter(toFilter, (a) -> (filter1.test(a) || filter2.test(a)));
    }

    //filters numbers, that are dividable by 7 or by 2
    public static List<Integer> multiple2or7(List<Integer> numbers) {
        return filterAny(numbers, (a) -> (a % 2 == 0), (a) -> (a % 7 == 0));
    }
}
