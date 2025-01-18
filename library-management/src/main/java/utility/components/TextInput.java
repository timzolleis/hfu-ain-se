package utility.components;

import lombok.Getter;
import utility.form.FormInput;

import java.util.Scanner;

@Getter
public class TextInput implements FormInput {

    private String label;
    private String name;

    public TextInput setName(final String name){
        this.name = name;
        return this;
    }

    public TextInput setLabel(final String label){
        this.label = label;
        return this;
    }

    @Override
    public String getValue() {
        System.out.print(label + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
