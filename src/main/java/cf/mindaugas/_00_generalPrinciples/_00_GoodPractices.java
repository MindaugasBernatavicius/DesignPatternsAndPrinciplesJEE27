package cf.mindaugas._00_generalPrinciples;

import static jdk.jshell.spi.ExecutionControl.*;

public class _00_GoodPractices {
    public static void main(String[] args) {
        boolean isValid = true; // adverb valid
        int age = 50; // noun
    }

    // verbs for function
    public boolean checkAge() throws NotImplementedException {
        throw new NotImplementedException("Not ready");
    }
}

class Person { // noun for class names
    int age;
}

interface Sortable {} // adverb (correct me if I'm wrong)
