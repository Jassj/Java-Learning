package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.CONSTRUCTOR) // apply to constructor
@Retention(RetentionPolicy.RUNTIME) // load to JVM at runtime
public @interface Constructor_Annotation {
    String value() default "default constructor"; // define a String member with default value
}
