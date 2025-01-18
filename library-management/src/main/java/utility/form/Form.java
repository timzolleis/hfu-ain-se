package utility.form;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Form {
    private final Map<String, FormInput> inputs = new LinkedHashMap<>();

    public void addInput(final FormInput input) {
        inputs.put(input.getName(), input);
    }

    public final Map<String, String> run() {
        final Map<String, String> values = new HashMap<>();
        for (FormInput input : inputs.values()) {
            values.put(input.getName(), input.getValue());
        }
        return values;
    }


}
