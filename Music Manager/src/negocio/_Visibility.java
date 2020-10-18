package negocio;

public enum _Visibility {

    VISIBLE(true), INVISIBLE(false);

    protected Boolean value;

    _Visibility(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return value;
    }

    public String getStrValue() {
        if (value) {
            return "VISIBLE";
        } else {
            return "INVISIBLE";
        }
    }
}
