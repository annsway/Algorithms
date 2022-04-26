package OOD;

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Student other = (Student) obj;
        if (age != other.age) return false;
        if (name == null) {
            if (other.name != null) return false;
        } else if (!name.equals(other.name)) return false;
        return true;
    }
    // 省略 get，set方法...
}
class hashTest {
    public static void main(String[] args) {
        Student stu1 = new Student("Jimmy",24);
        Student stu2 = new Student("Jimmy",24); System.out.println("两位同学是同一个人吗？"+stu1.equals(stu2));
        System.out.println("stu1.hashCode() = "+stu1.hashCode());
        System.out.println("stu1.hashCode() = "+stu2.hashCode());
    }
}
