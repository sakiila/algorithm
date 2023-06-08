package me.baobo.test;

import java.util.ArrayList;
import java.util.List;

public class NumberTest {
    
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Bob", 10));
        people.add(new Person("Cfda", 20));
        people.add(new Person("Dfa", 40));
        people.add(new Person("Alice", 21));
        
        Person test = new Person("Test", 15);
        people.stream()
            .filter(p -> p.getAge() > test.getAge())
            .forEach(p -> {
                test.setAge(p.getAge());
                System.out.println("p = " + p);
            });
        
    }
    
    static class Person {
        
        String name;
        int age;
        
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        public int getAge() {
            return age;
        }
        
        public void setAge(int age) {
            this.age = age;
        }
        
        public String getName() {
            return name;
        }
        
        public void setName(String name) {
            this.name = name;
        }
    
        @Override
        public String toString() {
            return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
        }
    }
    
}
