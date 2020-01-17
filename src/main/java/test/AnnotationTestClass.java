package test;

import annotation.TestAnnotation;

@TestAnnotation(value = "Class")
public class AnnotationTestClass {

    @TestAnnotation(value = "Field")
    private String name;

    @TestAnnotation(value = "Get Method")
    private String getName() {
        return name;
    }

    @TestAnnotation(value = "Set Method")
    private void setName(String name) {
        this.name = name;
    }

    @TestAnnotation()
    private void testMethod() {

    }
}
