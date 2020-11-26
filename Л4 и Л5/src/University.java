import java.util.ArrayList;
import java.util.List;

public class University {

    private final List<Achievement> achievements = new ArrayList<>();
    private final List<Student> students = new ArrayList<>();
    private final List<Teacher> teachers = new ArrayList<>();
    private final List<Task> tasks = new ArrayList<>();
    private final List<Mark> marks = new ArrayList<>();
    private final List<Journal> journals = new ArrayList<>();

    public University() {
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public List<Journal> getJournals() {
        return journals;
    }

    public void addAchievement(Achievement ac){
        achievements.add(ac);
    }

    public void addStudent(Student s){
        students.add(s);
    }

    public void addTeacher(Teacher tea){
        teachers.add(tea);
    }

    public void addTask(Task t){
        tasks.add(t);
    }

    public void addMark(Mark m){
        marks.add(m);
    }

    public void addJournal(Journal j) throws Exception{
        for(Journal journal : journals){
            if(journal.getDate().equals(j.getDate()) && journal.getStudent() == j.getStudent() && journal.getSubject() == j.getSubject()){
                throw new Exception("Такое посещение уже есть");
            }
        }
        journals.add(j);
    }
}
