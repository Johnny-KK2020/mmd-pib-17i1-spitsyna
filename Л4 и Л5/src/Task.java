public class Task {
    private final int number;
    private final String about;

    public Task(int number, String about) {
        this.number = number;
        this.about = about;
    }

    @Override
    public String toString() {
        return "Задание номер : " + number + ", " + about;
    }
}
