public class Student implements Human{

    private final String name;
    private final String group;
    private final String gradebook;

    public Student(String name, String group, String gradebook) {
        this.name = name;
        this.group = group;
        this.gradebook = gradebook;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public String getGradebook() {
        return gradebook;
    }

    @Override
    public String getFIO() {
        return getName();
    }

    @Override
    public String toString() {
        return "Студент : " + name + ", Группа : " + group + ", Зачетная книжка номер : " + gradebook;
    }
}
