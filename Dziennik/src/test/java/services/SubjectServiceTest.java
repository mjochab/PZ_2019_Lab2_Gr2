package services;

import Modele.Subject;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class SubjectServiceTest extends TestCase {


    @Test
    public void testPersist() {
        SubjectService subjectService = new SubjectService();
        Subject subject = new Subject(
                "Angielski"
        );

        subjectService.persist(subject);
        Subject subject1 = subjectService.findByName(subject.getSubjectName());
        org.junit.Assert.assertEquals("Angielski",subject1.getSubjectName());
        subjectService.delete(subject1.getSubjectId());

    }

    @Test
    public void testCount() {
        SubjectService subjectService = new SubjectService();
        Assert.assertEquals(3,subjectService.count().intValue());
    }
}