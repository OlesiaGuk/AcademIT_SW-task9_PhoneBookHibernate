package ru.academits.dao;

import com.mysql.cj.Session;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.stereotype.Repository;
import ru.academits.model.Contact;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.*;

@Repository
public class ContactDaoImpl extends GenericDaoImpl<Contact, Long> implements ContactDao {
    public ContactDaoImpl() {
        super(Contact.class);
    }

    @Override
    public List<Contact> getAllContacts() {
        return findAll();
    }

    @Override
    public List<Contact> findByPhone(String phone) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Contact> cq = cb.createQuery(clazz);

        Root<Contact> root = cq.from(clazz);

        cq.where(cb.equal(root.get("phone"), phone));

        CriteriaQuery<Contact> select = cq.select(root);
        TypedQuery<Contact> q = entityManager.createQuery(select);

        return q.getResultList();
    }

    @Override
    public void delete(List<Long> idList) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Contact> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(clazz);

        Root<Contact> root = criteriaUpdate.from(clazz);

        Expression<Long> exp = root.get("id");
        Predicate predicate = exp.in(idList);

        criteriaUpdate.set("isDeleted", true).where(predicate);

        entityManager.createQuery(criteriaUpdate).executeUpdate();
    }
}
