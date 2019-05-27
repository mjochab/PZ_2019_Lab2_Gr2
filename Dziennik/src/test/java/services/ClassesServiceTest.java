package services;

import Modele.Classes;
import junit.framework.TestCase;
import org.junit.Assert;

public class ClassesServiceTest extends TestCase {

    public void testPersist() {
        ClassesService classesService = new ClassesService();
        Classes testClass = new Classes("2a");
        classesService.persist(testClass);
        Classes classes = classesService.findById(testClass.getClassId());
        Assert.assertEquals(10,classes.getClassId());
    }

    public void testFindById() {
        ClassesService classesService = new ClassesService();
        Classes classes = classesService.findById(10);
        Assert.assertEquals("2a",classes.getClassName());
    }

    public void testDelete() {
        ClassesService classesService = new ClassesService();
        Classes classes = classesService.findById(10);
        classesService.delete(classes.getClassId());
        Assert.assertEquals(null,classes.getClassId());
    }
}