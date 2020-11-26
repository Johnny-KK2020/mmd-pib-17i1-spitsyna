import java.time.LocalDate;

public class Journal {
    private final LocalDate date;
    private final Student student;
    private final Subject subject;

    public Journal(LocalDate date, Student student, Subject subject) {
        this.date = date;
        this.student = student;
        this.subject = subject;
    }

    public LocalDate getDate() {
        return date;
    }

    public Student getStudent() {
        return student;
    }

    public Subject getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "Дата занятия "+ date + ", студент " + student.getFIO() + ", предмет - " + subject;
    }
}
