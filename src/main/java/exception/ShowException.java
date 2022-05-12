package exception;

import org.hibernate.HibernateError;

public class ShowException {
    public static void showNotice(Exception e) {
        System.out.println("Exception :" + e);
    }
}
