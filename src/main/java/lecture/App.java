package lecture;

import java.util.function.Function;

public class App
{
    static DoStringStuff concat = (s1, s2) -> s1 + " " + s2;
    static DoStringStuff getBiggestString = (s1,s2) -> s1.length() >= s2.length() ? s1 : s2;
    Function f;

    public static void main(String[] args) {
        String foo = "Foo";
        String bar = "Bar";
        System.out.println(doStringStuff(foo, bar, concat));
        System.out.println(doStringStuff("Hello", "World", getBiggestString));
        String reversed = doStringStuff("Maymanah", "Abdirashid",
                (s1,s2) -> new StringBuilder(s1+ " " +s2).reverse().toString()
        );
        System.out.println(reversed);
    }
    public static String doStringStuff(String first, String second, DoStringStuff action){
        return action.operate(first,second);
    }
}
