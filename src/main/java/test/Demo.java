package test;

import advancedFeatures.annotation.TestAnnotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 *advancedFeatures.annotation and reflect
 *@author yuanjie 2019/10/8 19:18
 */
public class Demo {
    public static void annotationRetainedForReflective() throws Exception {
        Class<AnnotationTestClass> myClass = AnnotationTestClass.class;
        TestAnnotation annotationOnClass = myClass.getAnnotation(TestAnnotation.class);
        System.out.println(annotationOnClass.value());
        Field myField = myClass.getField("name");
        TestAnnotation annotationOnField = myField.getAnnotation(TestAnnotation.class);
        System.out.println(annotationOnField.value());
        Method myMethod1 = myClass.getMethod("getName", null);
        TestAnnotation annotationOnMethod1 = myMethod1.getAnnotation(TestAnnotation.class);
        System.out.println(annotationOnMethod1.value());
        Method myMethod2 = myClass.getMethod("setName", String.class);
        TestAnnotation annotationOnMethod2 = myMethod2.getAnnotation(TestAnnotation.class);
        System.out.println(annotationOnMethod2.value());
        Method myMethod3 = myClass.getMethod("testMethod", null);
        TestAnnotation annotationOnMethod3 = myMethod3.getAnnotation(TestAnnotation.class);
        System.out.println(annotationOnMethod3.value());
    }

    public static void main(String[] args) throws Exception{
        annotationRetainedForReflective();
    }
}
