package com.pccw.immd.adminfunc.smartics2.util;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Dell on 26/2/2018.
 */

public class HibernateUtils  {

    private static EntityManager em;

    public static void setEntityManager(EntityManager em) {
        HibernateUtils.em = em;
    }

    public static EntityManager getEm() {
        return em;
    }

    public static <T> List<T> listByDomain(Class<T> clazz){
        List<T> list = null;
        Session session = em.unwrap(Session.class);

        list = session
                .createCriteria(clazz)
                .list();

        return list;
    }

    public static Session getSession() {
        Session session = em.unwrap(Session.class);
        return session;
    }

    public static <T> List<T> listByDomain(Class<T> clazz, Order ... orders){
        List<T> list = null;
        Session session = em.unwrap(Session.class);

        Criteria criteria = session.createCriteria(clazz);

        if (orders != null) {
            for (Order order : orders) {
                criteria.addOrder(order);
            }
        }

        list = criteria.list();

        return list;
    }


    public static <T> List<T> listByHQL(String HQL){
        return listByHQL(HQL, null, -1, -1);
    }
    public static <T> List<T> listByHQL(String HQL, Map<String, Object> params) {
        return listByHQL(HQL, params, -1, -1);
    }

    public static <T> List<T> listByHQL(String HQL, Map<String, Object> params, int offset, int limit){
        List<T> list = null;
        Session session = em.unwrap(Session.class);
        Query query = session.createQuery(HQL);
        if (params != null) {
            for (String name : params.keySet()) {
                setParam(query, name, params.get(name));
            }
        }

        if ( offset > 0 )
            query.setFirstResult(offset);
        if ( limit > 0 )
            query.setMaxResults(limit);

        list = query.list();
        return list;
    }

    private static void setParam(Query query, String name, Object param) {
        if (param instanceof String){
            query.setString(name, (String)param);
        } else if (param instanceof Character){
            query.setCharacter(name, ((Character) param).charValue());
        } else if (param instanceof Byte){
            query.setByte(name, ((Byte) param).byteValue());
        }else if (param instanceof Short){
            query.setShort(name, ((Short) param).shortValue());
        }else if (param instanceof Integer){
            query.setInteger(name, ((Integer) param).intValue());
        }else if (param instanceof Long){
            query.setLong(name, ((Long) param).longValue());
        }else if (param instanceof Float){
            query.setFloat(name, ((Float) param).floatValue());
        }else if (param instanceof Double){
            query.setDouble(name, ((Double) param).doubleValue());
        }else if (param instanceof Date){
            query.setDate(name,(Date)param);
        }
    }

}
