package org.egmaza.java8.lambda;

import org.egmaza.java8.lambda.models.Usuario;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class EjemploPredicate {
    public static void main(String[] args) {

        Predicate<Integer> test = num -> num > 10;
        boolean t1 = test.test(11);
        System.out.println("t1 = " + t1);

        Predicate<String> t2 = role -> role.equals("ROLE_ADMIN");
        System.out.println("t2 = " + t2.test("ROLE_ADMIN"));

        //BiPredicate<String, String> t3 = (a,b) -> a.equals(b);
        BiPredicate<String, String> t3 = String::equals;
        System.out.println("t3 = " + t3.test("pepe", "pepe"));

        BiPredicate<Integer, Integer> t4 = (i, j) -> j > i;
        System.out.println("t4 = " + t4.test(5, 10));

        Usuario a = new Usuario();
        Usuario b = new Usuario();
        a.setNombre("Maria");
        b.setNombre("Cata");
        BiPredicate<Usuario,Usuario> t5 = (ua, ub) ->  ua.getNombre().equals(ub.getNombre());
        System.out.println("t5 = " + t5.test(a,b));
    }
}
