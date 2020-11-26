import java.time.LocalDate;
import java.util.Scanner;

public class Program {
    private static final Scanner IN = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        University university = new University();
        String userInput;
        do {
            System.out.println("Выберите дальнейшее действие:" +
                    "\n1.Работа с журналом посещения" +
                    "\n2.Работа со студентами" +
                    "\n3.Работа с преподователями" +
                    "\n4.Работа с достижениями" +
                    "\n5.Работа с заданиями" +
                    "\n6.Работа с оценками" +
                    "\n7.Записать данные в файл" +
                    "\n8.Выгрузить данные из файла" +
                    "\n9.Выход");
            userInput = IN.nextLine();
            switch (userInput) {
                case "1":
                    System.out.println("Что именно вы хотите сделать?" +
                            "\n1.Добавить посещение" +
                            "\n2.Посмотрть журнал");
                    String case1Switch = IN.nextLine();
                    switch (case1Switch) {
                        case "1":
                            createJournal(university);
                            printJournal(university);
                            break;
                        case "2":
                            printJournal(university);
                            break;
                        default:
                            System.out.println("Выберите из предложенных вариантов!");
                    }
                    break;
                case "2":
                    System.out.println("Что именно вы хотите сделать?" +
                            "\n1.Добавить студента" +
                            "\n2.Посмотрть список студентов");
                    String case2Switch = IN.nextLine();
                    switch (case2Switch) {
                        case "1":
                            createStudent(university);
                            printStudent(university);
                            break;
                        case "2":
                            printStudent(university);
                            break;
                        default:
                            System.out.println("Выберите из предложенных вариантов!");
                    }
                    break;
                case "3":
                    System.out.println("Что именно вы хотите сделать?" +
                            "\n1.Добавить препода" +
                            "\n2.Посмотрть список преподов");
                    String case3Switch = IN.nextLine();
                    switch (case3Switch) {
                        case "1":
                            createTeacher(university);
                            printTeacher(university);
                            break;
                        case "2":
                            printTeacher(university);
                            break;
                        default:
                            System.out.println("Выберите из предложенных вариантов!");
                    }
                    break;
                case "4":
                    System.out.println("Что именно вы хотите сделать?" +
                            "\n1.Добавить достижение" +
                            "\n2.Посмотрть список достижений");
                    String case4Switch = IN.nextLine();
                    switch (case4Switch) {
                        case "1":
                            createAchievement(university);
                            printAchievement(university);
                            break;
                        case "2":
                            printAchievement(university);
                            break;
                        default:
                            System.out.println("Выберите из предложенных вариантов!");
                    }
                    break;
                case "5":
                    System.out.println("Что именно вы хотите сделать?" +
                            "\n1.Добавить задание" +
                            "\n2.Посмотрть список заданий");
                    String case5Switch = IN.nextLine();
                    switch (case5Switch) {
                        case "1":
                            createTask(university);
                            printTask(university);
                            break;
                        case "2":
                            printTask(university);
                            break;
                        default:
                            System.out.println("Выберите из предложенных вариантов!");
                    }
                    break;
                case "6":
                    System.out.println("Что именно вы хотите сделать?" +
                            "\n1.Добавить оценку" +
                            "\n2.Посмотрть оценки");
                    String case6Switch = IN.nextLine();
                    switch (case6Switch) {
                        case "1":
                            createMark(university);
                            printMark(university);
                            break;
                        case "2":
                            printMark(university);
                            break;
                        default:
                            System.out.println("Выберите из предложенных вариантов!");
                    }
                    break;
                case "7":
                    Service.write(university);
                    System.out.println("Данные записаны");
                    break;
                case "8":
                    System.out.println("Осторожно, не сохраненные данные будут удалены!" +
                            "\nХотите продолжить?" +
                            "\n1.Да" +
                            "\n2.Нет");
                    String case8Switch = IN.nextLine();
                    switch (case8Switch) {
                        case "1":
                            university = Service.reader();
                            System.out.println("Данные успешно выгружены");
                            break;
                        case "2":
                            break;
                        default:
                            System.out.println("Выберите из предложенных вариантов!");
                    }
                    break;
                case "9":
                    System.out.println("Спасибо за работу!");
                    break;
                default:
                    System.out.println("Выберите из предложенных вариантов!");
                    break;
            }
        } while (!"9".equals(userInput));
    }

    private static void printJournal(University university) {
        System.out.println("Журнал посещений:");
        for (int i = 0; i < university.getJournals().size(); ++i) {
            Journal journal = university.getJournals().get(i);
            System.out.println(i + ". " + journal);
        }
    }

    private static void createJournal(University university) {
        System.out.println("Введите дату посещения в формате гггг-мм-дд");
        String dateAsString = IN.nextLine();
        LocalDate date = LocalDate.parse(dateAsString);
        System.out.println("Выберити студента");
        for (int i = 0; i < university.getStudents().size(); ++i) {
            Student student = university.getStudents().get(i);
            System.out.println(i + ". " + student);
        }
        String studentChoice = IN.nextLine();
        int studentChoiceInt = Integer.parseInt(studentChoice);
        System.out.println("Выберите предмет");
        Subject[] subjects = Subject.values();
        for (int i = 0; i < Subject.values().length; ++i) {
            System.out.println(i + ". " + subjects[i]);
        }
        String subChoice = IN.nextLine();
        int subChoiceInt = Integer.parseInt(subChoice);
        Student student = university.getStudents().get(studentChoiceInt);
        Journal newJournal = new Journal(date,student,subjects[subChoiceInt]);
        try {
            university.addJournal(newJournal);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void createAchievement(University university){
        System.out.println("Выберите студента:");
        for (int i = 0; i < university.getStudents().size(); ++i) {
            Student student = university.getStudents().get(i);
            System.out.println(i + ". " + student);
        }
        String stChoice = IN.nextLine();
        int stChoiceInt = Integer.parseInt(stChoice);
        AchievementType[] achievementTypes = AchievementType.values();
        System.out.println("Выберите направление:");
        for (int i = 0; i < AchievementType.values().length; ++i) {
            System.out.println(i + ". " + achievementTypes[i]);
        }
        String acTypeChoice = IN.nextLine();
        int acTypeChoiceInt = Integer.parseInt(acTypeChoice);
        Achievement newAchievement = new Achievement(university.getStudents().get(stChoiceInt),achievementTypes[acTypeChoiceInt]);
        university.addAchievement(newAchievement);
    }

    private static void createMark(University university){
        System.out.println("Выберите задание:");
        for (int i = 0; i < university.getTasks().size(); ++i) {
            Task task = university.getTasks().get(i);
            System.out.println(i + ". " + task);
        }
        String taskChoice = IN.nextLine();
        int taskChoiceInt = Integer.parseInt(taskChoice);
        System.out.println("Выберите студента:");
        for (int i = 0; i < university.getStudents().size(); ++i) {
            Student student = university.getStudents().get(i);
            System.out.println(i + ". " + student);
        }
        String stChoice = IN.nextLine();
        int stChoiceInt = Integer.parseInt(stChoice);
        System.out.println("Выберите преподователя:");
        for (int i = 0; i < university.getTeachers().size(); ++i) {
            Teacher teacher = university.getTeachers().get(i);
            System.out.println(i + ". " + teacher);
        }
        String teachChoice = IN.nextLine();
        int teachChoiceInt = Integer.parseInt(teachChoice);
        System.out.println("Напишите оценку:");
        String result = IN.nextLine();
        Mark newMark = new Mark(university.getTasks().get(taskChoiceInt),university.getStudents().get(stChoiceInt),university.getTeachers().get(teachChoiceInt),result);
        university.addMark(newMark);
    }

    private static void createStudent(University university){
        System.out.println("Введите ФИО:");
        String name = IN.nextLine();
        System.out.println("Введите группу:");
        String group = IN.nextLine();
        System.out.println("Введите номер зачетной книжки:");
        String gradebook = IN.nextLine();
        Student newStudent = new Student(name,group,gradebook);
        university.addStudent(newStudent);
    }

    private static void createTask(University university){
        System.out.println("Введите номер задачи:");
        String num = IN.nextLine();
        int number = Integer.parseInt(num);
        System.out.println("Введите описание:");
        String about = IN.nextLine();
        Task newTask = new Task(number,about);
        university.addTask(newTask);
    }

    private static void createTeacher(University university){
        System.out.println("Введите ФИО:");
        String tname = IN.nextLine();
        System.out.println("ВЫберите предмет:");
        Subject[] subjects = Subject.values();
        for (int i = 0; i < Subject.values().length; ++i) {
            System.out.println(i + ". " + subjects[i]);
        }
        String subChoice = IN.nextLine();
        int subChoiceInt = Integer.parseInt(subChoice);
        Teacher newTeacher = new Teacher(tname,subjects[subChoiceInt]);
        university.addTeacher(newTeacher);
    }

    private static void printAchievement(University university){
        System.out.println("Достижения:");
        for (int i = 0; i < university.getAchievements().size(); ++i) {
            Achievement achievement = university.getAchievements().get(i);
            System.out.println(i + ". " + achievement);
        }
    }

    private static void printMark(University university){
        System.out.println("Оценки:");
        for (int i = 0; i < university.getMarks().size(); ++i) {
            Mark mark = university.getMarks().get(i);
            System.out.println(i + ". " + mark);
        }
    }

    private static void printStudent(University university){
        System.out.println("Список студентов:");
        for (int i = 0; i < university.getStudents().size(); ++i) {
            Student student = university.getStudents().get(i);
            System.out.println(i + ". " + student);
        }
    }

    private static void printTask(University university){
        System.out.println("Задания:");
        for (int i = 0; i < university.getTasks().size(); ++i) {
            Task task = university.getTasks().get(i);
            System.out.println(i + ". " + task);
        }
    }

    private static void printTeacher(University university){
        System.out.println("Список преподователей:");
        for (int i = 0; i < university.getTeachers().size(); ++i) {
            Teacher teacher = university.getTeachers().get(i);
            System.out.println(i + ". " + teacher);
        }
    }
}
