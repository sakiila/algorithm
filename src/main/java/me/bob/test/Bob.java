package me.bob.test;

import java.util.Objects;

public class Bob {
    
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bob bob = (Bob) o;

        if (name != null ? !name.equals(bob.name) : bob.name != null) return false;
        if (age != null ? !age.equals(bob.age) : bob.age != null) return false;

        return true;
    }

//    @Override
//    public int hashCode() {
//        int result = name != null ? name.hashCode() : 0;
//        result = 31 * result + (age != null ? age.hashCode() : 0);
//        return result;
//    }
}
