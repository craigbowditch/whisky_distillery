package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    @Autowired
     EntityManager entityManager;

    @Transactional
    public List<Whisky> getAllWhiskiesByYear(int year){
        List<Whisky> whiskies = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Whisky.class);
            cr.add(Restrictions.eq("year", year));
            whiskies = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return whiskies;
    }

    @Transactional
    public List<Whisky> getAllWhiskiesByRegion(String region){
        List<Whisky> whiskies = null;
        Session session = entityManager.unwrap((Session.class));
        try {
            Criteria cr = session.createCriteria(Whisky.class);
            cr.createAlias("distillery", "dist");
            cr.add(Restrictions.eq("dist.region", region));
            whiskies = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return whiskies;
    }

    @Transactional
    public List<Whisky> getAllWhiskiesByDistilleryAndAge(String distillery, int age){
        List<Whisky> whiskies = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Whisky.class);
            cr.createAlias("distillery", "dist");
            cr.add(Restrictions.eq("dist.name", distillery));
            cr.add(Restrictions.eq("age", age));
            whiskies = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return whiskies;

    }
}
