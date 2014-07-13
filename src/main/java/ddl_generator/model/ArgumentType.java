package ddl_generator.model;

public enum ArgumentType {

    TABLE("-t"), FILE("-f");

    private final String type;

    private ArgumentType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
