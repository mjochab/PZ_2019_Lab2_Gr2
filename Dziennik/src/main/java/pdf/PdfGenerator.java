package pdf;

import Modele.Grades;
import Modele.Student;
import Modele.Subject;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import services.GradesServices;
import services.StudentServices;
import services.SubjectService;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class PdfGenerator {
    public void createPdf(String filename, long studentId) throws IOException, DocumentException {
        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream(filename));
        doc.open();

        StudentServices studentService = new StudentServices();
        Student student = studentService.findById(studentId);

        doc.add(new Paragraph("Klasa: "+student.getClasses().getClassName()));
        doc.add(new Paragraph("Imie i nazwisko: "+student.getFirstName()+ " " +student.getLastName()));
        doc.add(new Paragraph("Pesel: "+student.getPesel()));
        doc.add(new Phrase(" "));
        doc.add(new Paragraph(" "));
        doc.add(createTable(studentId));

        doc.close();
    }

    private static PdfPTable createTable(long studentId){
        PdfPTable table = new PdfPTable(2);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Wykaz ocen ucznia"));
        cell.setColspan(2);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Przedmiot"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Oceny"));
        table.addCell(cell);

        SubjectService subjectService = new SubjectService();
        List<Subject> subjectList = subjectService.findAllSubjects();

        GradesServices gradesService = new GradesServices();
        List<Grades> gradesList =  gradesService.findAllStudentGrades(studentId);

        for (int i = 0; i < 5 ;i++){
            for (int j = 0 ; j < 2; j++){
                final int subjectIndex = i;
                if (j == 0){
                    table.addCell(subjectList.get(i).getSubjectName());
                } else {
                    List<Grades> gradesFromSpecificSubject = gradesList.stream().filter(x -> x.getSubject().getSubjectId() == subjectList.get(subjectIndex).getSubjectId()).collect(Collectors.toList());
                    StringBuilder sb = new StringBuilder();
                    for (Grades g : gradesFromSpecificSubject){
                        sb.append(g.getGrade());
                        if (gradesFromSpecificSubject.indexOf(g) != gradesFromSpecificSubject.size() - 1){
                            sb.append(", ");
                        }
                    }
                    table.addCell(sb.toString());
                }
            }

        }

        return table;
    }

}
