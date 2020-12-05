public enum AchievementType {
    SPORT("Спорт"),
    STUDY("Учеба"),
    SCIENCE("Наука"),
    SOCIAL("Общественная деятельность");

    private final String name;

    AchievementType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }

}
