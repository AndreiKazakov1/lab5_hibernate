package service.serviceImpl;

import dao.CompanyDao;
import dao.daoImpl.CompanyDaoImpl;
import entity.Company;
import exception.ShowException;
import org.hibernate.HibernateError;
import service.CompanyService;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {

    CompanyDao companyDao = new CompanyDaoImpl();

    public CompanyServiceImpl() {}

    @Override
    public boolean addCompany(Company company) {
        boolean isAdded = false;
        try {
            companyDao.addCompany(company);
            isAdded = true;
        }
        catch (HibernateError e) {
            ShowException.showNotice(e);
        }
        return isAdded;
    }

    @Override
    public boolean updateCompany(Company company) {
        boolean isUpdated = false;
        System.out.println("Это ДЗ");
        return isUpdated;
    }

    @Override
    public boolean deleteCompany(int id) {
        System.out.println("Это ДЗ");
        // return isDeleted;
        return false;
    }

    @Override
    public List<Company> showCompanies() {
        System.out.println("Это ДЗ");
        // return companies;
        return null;
    }

    @Override
    public Company findCompanyById(int id) {
        System.out.println("Это ДЗ");
        //return company;
        return null;
    }

    @Override
    public Company findCompanyByName(String name) {
        System.out.println("Это ДЗ");
        //  return company;
        return null;
    }
}

