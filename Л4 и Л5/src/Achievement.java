public class Achievement {
    private final Student student;
    private final AchievementType achievementType;

    public Achievement(Student student, AchievementType achievementType) {
        this.student = student;
        this.achievementType = achievementType;
    }

    @Override
    public String toString() {
        return "Достижение " + student.getFIO() + " в направлении : " + achievementType;
    }
}
