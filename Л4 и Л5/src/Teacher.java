public class Teacher implements Human {

    private final String name;
    private final Subject subject;

    public Teacher(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public Subject getSubject() {
        return subject;
    }

    @Override
    public String getFIO() {
        return getName();
    }

    @Override
    public String toString() {
        return name + ", " + subject;
    }
}
