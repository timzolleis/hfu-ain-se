package utility.components;

import lombok.Getter;
import utility.form.FormInput;

import java.util.Scanner;

@Getter
public class Selection implements FormInput {
    private String[] options;
    private String label;
    private String name;

    public Selection setName(final String name){
        this.name = name;
        return this;
    }
    public Selection setLabel(final String label){
        this.label = label;
        return this;
    }

    public Selection setOptions(String[] options){
        this.options = options;
        return this;
    }

    public final String getValue() {
        System.out.println(label + ":");
        for (int i = 0; i < options.length; i++) {
            System.out.println(i + ": " + options[i]);
        }
        System.out.print("Select an option by index: ");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        if (index < 0 || index >= options.length) {
            System.out.println("Invalid index. Please try again.");
            return getValue();
        }
        return options[index];
    }




}
