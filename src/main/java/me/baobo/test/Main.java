package me.baobo.test;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        String a = "hello2";
//        final String b = "hello";
//        String c = "hello";Z
//        System.out.println((b == c)); // true
//        String d = b + 2;
//        String e = c + 2;
//        System.out.println((a == d)); // true
//        System.out.println((a == e)); // false

        List<Pet> petInfoList = new ArrayList<>();
        petInfoList.add(new Pet("a", 2));
        petInfoList.add(new Pet("b", 3));
        petInfoList.add(new Pet("c", 4));

        petInfoList.stream()
                .filter(entry -> entry.getPetId() > 2)
                .forEach(petInfo -> {

                });

        petInfoList.forEach(petInfo -> {
            System.out.println("petInfo = " + petInfo);
        });

//
//        String collect = petInfoList.stream().limit(5)
//                .map(Pet::getPetName)
//                .collect(Collectors.joining(","))
//                .concat(", etc.");;
//
//        boolean aNull = Objects.isNull(collect);
//        System.out.println("aNull = " + aNull);
//
//        collect.concat("dfasfasf");
//        System.out.println("collect =" + collect + "=");

    }
}
