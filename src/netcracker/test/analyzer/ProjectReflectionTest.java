package netcracker.test.analyzer;

import netcracker.Lab01.analyzer.ProjectReflection;
import netcracker.Lab01.fillers.FillersImpl;
import netcracker.Lab01.fillers.annotations.Filler;
import netcracker.Lab01.sorters.impl.AbstractSorter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.List;

import static org.junit.Assert.*;

public class ProjectReflectionTest {
    private ProjectReflection projectReflection;

    @Before
    public void setUp() throws Exception {

        projectReflection = new ProjectReflection();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAllMethodWhoAnnotatedFillerForExampleClass() throws Exception {
        projectReflection.getAllMethodWhoAnnotatedFiller(Object.class, Object.class);
    }

    @Test
    public void getAllMethodWhoAnnotatedFillerForRealClass() throws Exception {
        String actual = "createRandomIntArray";
        List<Method> list = projectReflection.getAllMethodWhoAnnotatedFiller(FillersImpl.class, Filler.class);
        Method method = list.get(0);
        String s = method.getName();

        assertEquals(s, actual);
    }

    @Test(expected = NullPointerException.class)
    public void getAllMethodWhoAnnotatedFillerTestForNull() throws Exception {
        projectReflection.getAllMethodWhoAnnotatedFiller(null, null);
    }

    @Test
    public void getAllSubsortersClasses() throws Exception {
        String actual = "MergeSort";
        List<Class<? extends AbstractSorter>> list = projectReflection.getAllSubsortersClasses("netcracker.Lab01", AbstractSorter.class);
        String ex = list.get(0).getSimpleName();

        assertEquals(ex, actual);
    }

    @Test(expected = NullPointerException.class)
    public void getAllSubsortersClassesTestForNull() throws Exception {
        projectReflection.getAllSubsortersClasses(null, null);
    }
}