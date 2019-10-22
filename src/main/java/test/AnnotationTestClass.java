package test;

import annotation.TestAnnotation;

@TestAnnotation(value = "Class")
public class AnnotationTestClass {

    @TestAnnotation(value = "Field")
    public String name;

    @TestAnnotation(value = "Get Method")
    public String getName() {
        return name;
    }

    @TestAnnotation(value = "Set Method")
    public void setName(String name) {
        this.name = name;
    }

    @TestAnnotation()
    public void testMethod() {

    }
}
