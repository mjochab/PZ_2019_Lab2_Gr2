package pdf;

import Modele.Schedule;
import Modele.Student;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import hibernate.HibernateUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import services.ClassesService;
import services.ScheduleService;
import services.StudentServices;
import services.SubjectService;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class SchedulePdf {
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

        doc.add(new Paragraph("Poniedzialek"));
        doc.add(new Paragraph(" "));
        doc.add(createTableMonday(studentId));
        doc.add(new Paragraph(" "));
        doc.add(new Paragraph("Wtorek"));
        doc.add(new Paragraph(" "));
        doc.add(createTableTuesday(studentId));
        doc.add(new Paragraph(" "));
        doc.add(new Paragraph("Sroda"));
        doc.add(new Paragraph(" "));
        doc.add(createTableWednesday(studentId));
        doc.add(new Paragraph(" "));
        doc.add(new Paragraph("Czwartek"));
        doc.add(new Paragraph(" "));
        doc.add(createTableThursday(studentId));
        doc.add(new Paragraph(" "));
        doc.add(new Paragraph("Piatek"));
        doc.add(new Paragraph(" "));
        doc.add(createTableFriday(studentId));
        doc.add(new Paragraph(" "));




        doc.close();
    }


    private static PdfPTable createTableMonday(long studentId) {
        PdfPTable table = new PdfPTable(3);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Godzina rozpoczecia"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Sala"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Przedmiot"));
        table.addCell(cell);

        StudentServices studentService = new StudentServices();
        Student student = studentService.findById(studentId);
        SubjectService subjectService = new SubjectService();

        ClassesService classesService = new ClassesService();
        Integer actual_class = Math.toIntExact(student.getClasses().getClassId());
        ScheduleService scheduleService = new ScheduleService();



            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery("select * from schedule where day = 'Poniedziałek' and class ='" + actual_class + "'");
            List<Object[]> rows = query.list();

            for (Object[] row : rows) {
                Schedule schedule = new Schedule();

                schedule.setRoom(row[2].toString());
                String room = schedule.getRoom();

                Integer actual_classs = Math.toIntExact(student.getClasses().getClassId());
                schedule.setTime(row[3].toString());
                String time = schedule.getTime();
                System.out.println(room);
                System.out.println(time);
                SQLQuery temp_query = session.createSQLQuery
                        ("select su.subject_name from schedule s, subject su where s.day = 'Poniedziałek' and s.room ='" + room + "' and s.time='" + time + "' and class ='" + actual_classs + "' and s.subject_id = su.subject_id");
                List<String> list = temp_query.list();
                for (int j = 0; j < list.size(); j++) {

                    String s1 = list.get(j);


                    System.out.println(s1);

                    cell = new PdfPCell((new Paragraph(time)));
                    table.addCell(cell);

                    cell = new PdfPCell((new Paragraph(room)));
                    table.addCell(cell);

                    cell = new PdfPCell((new Paragraph(s1)));
                    table.addCell(cell);


                }
            }

        return table;
        }

    private static PdfPTable createTableTuesday(long studentId) {
        PdfPTable table = new PdfPTable(3);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Godzina rozpoczecia"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Sala"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Przedmiot"));
        table.addCell(cell);

        StudentServices studentService = new StudentServices();
        Student student = studentService.findById(studentId);
        SubjectService subjectService = new SubjectService();

        ClassesService classesService = new ClassesService();
        Integer actual_class = Math.toIntExact(student.getClasses().getClassId());
        ScheduleService scheduleService = new ScheduleService();



        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("select * from schedule where day = 'Wtorek' and class ='" + actual_class + "'");
        List<Object[]> rows = query.list();

        for (Object[] row : rows) {
            Schedule schedule = new Schedule();

            schedule.setRoom(row[2].toString());
            String room = schedule.getRoom();

            Integer actual_classs = Math.toIntExact(student.getClasses().getClassId());
            schedule.setTime(row[3].toString());
            String time = schedule.getTime();
            System.out.println(room);
            System.out.println(time);
            SQLQuery temp_query = session.createSQLQuery
                    ("select su.subject_name from schedule s, subject su where s.day = 'Wtorek' and s.room ='" + room + "' and s.time='" + time + "' and class ='" + actual_classs + "' and s.subject_id = su.subject_id");
            List<String> list = temp_query.list();
            for (int j = 0; j < list.size(); j++) {

                String s1 = list.get(j);


                System.out.println(s1);

                cell = new PdfPCell((new Paragraph(time)));
                table.addCell(cell);

                cell = new PdfPCell((new Paragraph(room)));
                table.addCell(cell);

                cell = new PdfPCell((new Paragraph(s1)));
                table.addCell(cell);


            }
        }

        return table;
    }

    private static PdfPTable createTableWednesday(long studentId) {
        PdfPTable table = new PdfPTable(3);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Godzina rozpoczecia"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Sala"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Przedmiot"));
        table.addCell(cell);

        StudentServices studentService = new StudentServices();
        Student student = studentService.findById(studentId);
        SubjectService subjectService = new SubjectService();

        ClassesService classesService = new ClassesService();
        Integer actual_class = Math.toIntExact(student.getClasses().getClassId());
        ScheduleService scheduleService = new ScheduleService();



        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("select * from schedule where day = 'Środa' and class ='" + actual_class + "'");
        List<Object[]> rows = query.list();

        for (Object[] row : rows) {
            Schedule schedule = new Schedule();

            schedule.setRoom(row[2].toString());
            String room = schedule.getRoom();

            Integer actual_classs = Math.toIntExact(student.getClasses().getClassId());
            schedule.setTime(row[3].toString());
            String time = schedule.getTime();
            System.out.println(room);
            System.out.println(time);
            SQLQuery temp_query = session.createSQLQuery
                    ("select su.subject_name from schedule s, subject su where s.day = 'Środa' and s.room ='" + room + "' and s.time='" + time + "' and class ='" + actual_classs + "' and s.subject_id = su.subject_id");
            List<String> list = temp_query.list();
            for (int j = 0; j < list.size(); j++) {

                String s1 = list.get(j);


                System.out.println(s1);

                cell = new PdfPCell((new Paragraph(time)));
                table.addCell(cell);

                cell = new PdfPCell((new Paragraph(room)));
                table.addCell(cell);

                cell = new PdfPCell((new Paragraph(s1)));
                table.addCell(cell);


            }
        }

        return table;
    }

    private static PdfPTable createTableThursday(long studentId) {
        PdfPTable table = new PdfPTable(3);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Godzina rozpoczecia"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Sala"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Przedmiot"));
        table.addCell(cell);

        StudentServices studentService = new StudentServices();
        Student student = studentService.findById(studentId);
        SubjectService subjectService = new SubjectService();

        ClassesService classesService = new ClassesService();
        Integer actual_class = Math.toIntExact(student.getClasses().getClassId());
        ScheduleService scheduleService = new ScheduleService();



        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("select * from schedule where day = 'Czwartek' and class ='" + actual_class + "'");
        List<Object[]> rows = query.list();

        for (Object[] row : rows) {
            Schedule schedule = new Schedule();

            schedule.setRoom(row[2].toString());
            String room = schedule.getRoom();

            Integer actual_classs = Math.toIntExact(student.getClasses().getClassId());
            schedule.setTime(row[3].toString());
            String time = schedule.getTime();
            System.out.println(room);
            System.out.println(time);
            SQLQuery temp_query = session.createSQLQuery
                    ("select su.subject_name from schedule s, subject su where s.day = 'Czwartek' and s.room ='" + room + "' and s.time='" + time + "' and class ='" + actual_classs + "' and s.subject_id = su.subject_id");
            List<String> list = temp_query.list();
            for (int j = 0; j < list.size(); j++) {

                String s1 = list.get(j);


                System.out.println(s1);

                cell = new PdfPCell((new Paragraph(time)));
                table.addCell(cell);

                cell = new PdfPCell((new Paragraph(room)));
                table.addCell(cell);

                cell = new PdfPCell((new Paragraph(s1)));
                table.addCell(cell);


            }
        }

        return table;
    }

    private static PdfPTable createTableFriday(long studentId) {
        PdfPTable table = new PdfPTable(3);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Godzina rozpoczecia"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Sala"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Przedmiot"));
        table.addCell(cell);

        StudentServices studentService = new StudentServices();
        Student student = studentService.findById(studentId);
        SubjectService subjectService = new SubjectService();

        ClassesService classesService = new ClassesService();
        Integer actual_class = Math.toIntExact(student.getClasses().getClassId());
        ScheduleService scheduleService = new ScheduleService();



        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("select * from schedule where day = 'Piątek' and class ='" + actual_class + "'");
        List<Object[]> rows = query.list();

        for (Object[] row : rows) {
            Schedule schedule = new Schedule();

            schedule.setRoom(row[2].toString());
            String room = schedule.getRoom();

            Integer actual_classs = Math.toIntExact(student.getClasses().getClassId());
            schedule.setTime(row[3].toString());
            String time = schedule.getTime();
            System.out.println(room);
            System.out.println(time);
            SQLQuery temp_query = session.createSQLQuery
                    ("select su.subject_name from schedule s, subject su where s.day = 'Piątek' and s.room ='" + room + "' and s.time='" + time + "' and class ='" + actual_classs + "' and s.subject_id = su.subject_id");
            List<String> list = temp_query.list();
            for (int j = 0; j < list.size(); j++) {

                String s1 = list.get(j);


                System.out.println(s1);

                cell = new PdfPCell((new Paragraph(time)));
                table.addCell(cell);

                cell = new PdfPCell((new Paragraph(room)));
                table.addCell(cell);

                cell = new PdfPCell((new Paragraph(s1)));
                table.addCell(cell);


            }
        }

        return table;
    }


}
