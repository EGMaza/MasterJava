package org.egmaza.api.stream.tareas.tarea1;

import java.util.ArrayList;
import java.util.List;

public class Tarea1 {
    public static void main(String[] args) {
        List<Integer> unoACien = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            unoACien.add(i);
        }

        double stcCien = unoACien.stream()
                .filter(n -> n % 10 != 0)
                .mapToDouble(Integer::doubleValue)
                .map(l -> l / 2)
                .reduce(0, (a,b) -> a+b);

        System.out.println(stcCien);
    }
}