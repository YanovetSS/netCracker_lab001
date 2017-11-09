package netcracker.Lab01.fillers.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Create author annotation with name -Filler
 *
 * @author Nazar Yanovets
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Filler {
    String author() default "Nazar";

    String comments();
}
