package netcracker.lab01.work.analyzer;

import java.lang.reflect.Method;
import java.util.List;

/**
 * A class is an inner object of Map. This one save sorting result and uses in external map
 *
 * @author Nazar Yanovets
 * @version 1.0
 * @see Analyzer
 * @since 1.5
 */
public class InnerResults {

    private Method method;
    private List<Long> executionTime;

    public InnerResults(Method method, List<Long> executionTime) {
        this.method = method;
        this.executionTime = executionTime;
    }

    /**
     * Method return method
     *
     * @return methot
     */
    public Method getMethod() {
        return method;
    }

    /**
     * Method return List holds i itself item
     *
     * @return List
     */
    public List<Long> getExecutionTime() {
        return executionTime;
    }

    @Override
    public String toString() {
        return "Method " + method.getName() + " Vals " + executionTime.toString();
    }
}
