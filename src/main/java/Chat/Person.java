package Chat;

import java.io.Serializable;

public class Person implements Serializable {
   static String name;
    String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Person(String name, String age) {

        this.name = name;
        this.age = age;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name+" "+this.age;
    }
}
