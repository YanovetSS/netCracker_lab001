package netcracker.Lab01.analyzer;


import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A class use reflection api and stream api. This one have two general methods.
 * We can get subclasses or some methods who annotated @name
 *
 * @author Nazar Yanovets
 * @version 1.0
 * @see Reflections
 * @see Class
 * @see java.util.stream.Collectors
 * @since 1.8
 */
public class ProjectReflection {

    /**
     * A method works with two class. One of that it implementation where we have some methods who annotation with
     * secon class name and second of that it's you'r annotation
     *
     * @param implementClass
     * @param fillerName
     * @param <T>
     * @return List<Method>
     */
    private <T> List<Method> searchAllMethodWhoAnnotatedFiller(Class<T> implementClass, Class fillerName) {
        List<Method> allAnnotationMethods = new ArrayList<>();
        try {
            for (Method method :
                    Analyzer.class.getClassLoader().loadClass(implementClass.getName()).getMethods()) {
                {
                    if (method.isAnnotationPresent(fillerName)) {
                        try {
                            for (Annotation annotation : method.getDeclaredAnnotations()) {
                                allAnnotationMethods.add(method);
                            }
                        } catch (Throwable ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return allAnnotationMethods;
    }

    /**
     * A method works with String value - basePaskage and Class value. You can get all sub classes of Class value.
     * User stream api and return list sub classes.
     *
     * @param basePackage
     * @param clazz
     * @param <T>
     * @return List
     */
    private <T> List<Class<? extends T>> searchAllSubSorterClass(String basePackage, Class<T> clazz) {
        return new Reflections(basePackage)
                .getSubTypesOf(clazz)
                .stream()
                .filter((c) -> !Modifier.isAbstract(c.getModifiers()))
                .collect(Collectors.toList());
    }

    /**
     * This one returns public realization of {@link,searchAllMethodWhoAnnotatedFiller}
     *
     * @param implementClass
     * @param fillerName
     * @return List
     */
    public List<Method> getAllMethodWhoAnnotatedFiller(Class implementClass, Class fillerName) {
        return searchAllMethodWhoAnnotatedFiller(implementClass, fillerName);
    }

    /**
     * This one returns public realization of {@Ling,searchAllSubSorterClass}
     *
     * @param basePackage
     * @param tClass
     * @param <T>
     * @return List
     */
    public <T> List<Class<? extends T>> getAllSubsortersClasses(String basePackage, Class<T> tClass) {
        return searchAllSubSorterClass(basePackage, tClass);
    }

    /**
     * A method returns size of List. List holds in itself all methods who annotated fillername
     *
     * @param implementClass
     * @param fillerName
     * @return int size
     */
    public int getListSizeWhereWeHaveMethodWhoAnnotatedFiller(Class implementClass, Class fillerName) {
        int size = searchAllMethodWhoAnnotatedFiller(implementClass, fillerName).size();
        return size;
    }

}
