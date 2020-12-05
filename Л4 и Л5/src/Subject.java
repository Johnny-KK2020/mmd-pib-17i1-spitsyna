public enum Subject {
    PHYSICS("Физика"),
    MATH("Математика"),
    HISTORY("История");

    private final String name;

    Subject(String name) {
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
