package junseok.snr.study.java.api.switchs;

public class SwitchTypeMatch {

    public String getTypeName(Object obj) {
        String type = "Else Type";

        if (obj instanceof String) {
            type = "String";
        } else if (obj instanceof Integer) {
            type = "Integer";
        } else if (obj instanceof Long) {
            type = "Long";
        }

        return type;
    }

    public String getTypeNameSwitch(Object obj) {
        return switch (obj) {
            case String s -> "String";
            case Integer i -> "Integer";
            case Long l -> "Long";
            default -> "Else Type";
        };
    }
}
