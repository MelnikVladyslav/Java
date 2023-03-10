package program;

import models.Question;
import models.QuestionItem;
import models.Role;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        showQuestions();
    }
    private static void insertRole() {
        Scanner in = new Scanner(System.in);
        Session context = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        System.out.println("Enter role name:");
        String name = in.nextLine();
        Role role = new Role();
        role.setName(name);
        context.save(role);
        context.close();
    }
    private static void showRoles() {
        Session context = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = context.createQuery("FROM Role");
        List<Role> roles = query.list();
        for (Role role : roles)
        {
            System.out.println(role);
        }
        context.close();
    }

    //Show questions
    private static void showQuestions() {
        Session context = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = context.createQuery("FROM Question");
        List<Question> questions = query.list();
        for (Question question : questions)
        {
            System.out.println(question);
        }
        context.close();
    }

    //Add question
    private static void addQuestion() {
        Scanner in = new Scanner(System.in);
        Session context = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = context.beginTransaction();
        System.out.println("Вкажіть питання:");
        String questionText = in.nextLine();
        Question question = new Question();
        question.setName(questionText);
        context.save(question);
        String action="";
        do {
            System.out.println("Введіть варіанти відповіді:");
            String text = in.nextLine();
            System.out.print("Правильність відповіді(0/1)->_");
            boolean isTrue = Byte.parseByte(in.nextLine())==1? true: false;
            QuestionItem qi = new QuestionItem();
            qi.setText(text);
            qi.setTrue(isTrue);
            qi.setQuestion(question);
            context.save(qi);
            System.out.print("Додати наступний варінат(1-так, 0-вийти)->_");
            action=in.nextLine();
        }while(!action.equals("0"));
        tx.commit();
        context.close();
    }

    //Delete question
    private static void deleteQuestion() {
        Scanner in = new Scanner(System.in);
        Session context = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = context.beginTransaction();
        System.out.println("Вкажіть питання:");
        int questionId = in.nextInt();
        Session session ;
        MyObject myObject ;

        session = sessionFactory.getCurrentSession();
        myObject = (MyObject)session.load(MyObject.class,id);
        session.delete(myObject);

        //This makes the pending delete to be done
        session.flush() ;
        tx.commit();
        context.close();
    }
}
