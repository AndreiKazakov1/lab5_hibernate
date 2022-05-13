package dao.daoImpl;

import dao.CompanyDao;
import entity.Company;
import entity.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sessionFactory.SessionFactoryImpl;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CompanyDaoImpl implements CompanyDao {

    public CompanyDaoImpl() {
    }

    @Override
    public boolean addCompany(Company company) {
        boolean isAdded = false;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(company);
            tx.commit();
            session.close();
            isAdded = true;
        }
        catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return isAdded;
    }

    @Override
    public boolean updateCompany(Company company) {
        boolean isUpdated = false;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(company);
            transaction.commit();
            session.close();
            isUpdated = true;
        }
        catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return isUpdated;
    }


    @Override
    public boolean deleteCompany(int id) {
        boolean isDeleted = false;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Company company = session.load(Company.class, id);
            Transaction transaction = session.beginTransaction();
            session.delete(company);
            transaction.commit();
            session.close();
            isDeleted = true;
        }
        catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return isDeleted;
    }


    @Override
    public Company findCompanyById(int id) {
        Company company = null;
        try {
            Session session = SessionFactoryImpl.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Company> criteriaQuery = criteriaBuilder.createQuery(Company.class);
            Root<Company> root = criteriaQuery.from(Company.class);
            criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("company_Id"), id));
            company = session.createQuery(criteriaQuery).getSingleResult();
            transaction.commit();
            session.close();
        }
        catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return company;
    }



    @Override
    public Company findCompanyByName(String name) {
        Company company = null;
        try {
            // Тут нужен поиск по имени
        }
        catch (NoClassDefFoundError e) {
            System.out.println("Exception: " + e);
        }
        return company;
    }

    @Override
    public List<Company> showCompanies() {
        List<Company> companies = (List<Company>)SessionFactoryImpl.getSessionFactory().openSession().createQuery("From Company").list();
        return companies;
    }
}

