package com.kugstr.kotlinmeetupvol1.chapter_3;

public class DataClasses_Java {

    private String name;
    private String age;

    public DataClasses_Java(String name, String age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataClasses_Java that = (DataClasses_Java) o;

        if (!name.equals(that.name)) return false;
        return age.equals(that.age);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "DataClasses_Java{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
