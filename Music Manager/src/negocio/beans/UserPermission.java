package negocio.beans;

public enum UserPermission {
    ADM(true), NORMAL(false);

    private Boolean value;

    UserPermission(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return value;
    }

    public String getStrValue() {
        if (value) {
            return "ADM";
        } else {
            return "NORMAL";
        }
    }
}
