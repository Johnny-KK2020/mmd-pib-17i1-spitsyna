public class Mark {
    private final Task task;
    private final Student student;
    private final Teacher teacher;
    private final String result;

    public Mark(Task task, Student student, Teacher teacher, String result) {
        this.task = task;
        this.student = student;
        this.teacher = teacher;
        this.result = result;
    }

    @Override
    public String toString() {
        return "Задания номер : " + task + ", студента : " + student.getFIO() + ", оценил : " + teacher.getFIO() + ", оценка : " + result;
    }
}
