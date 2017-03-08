package com.k1.spitter.checkdb;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


// public class MethodsBank {
// static Integer saveToDb(SessionFactory factory, Student student) {
// // if you use sessionFactory.getCurrentSession(), you'll obtain a
// // "current session" which is bound to the lifecycle of
// // the transaction and will be automatically flushed and closed
// // when the transaction ends (commit or rollback).
// // if you decide to use sessionFactory.openSession(), you'll have
// // to manage the session yourself and to flush and close
// // it "manually".
// Session session = factory.getCurrentSession();
// Integer id = null;
// try {
// session.beginTransaction();
// id = (Integer) session.save(student);
// session.getTransaction().commit();
// } catch (HibernateException e) {
// }
// return id;
// }
//
// static Student readById(SessionFactory factory, int id) {
// Session session = factory.getCurrentSession();
// Student student = null;
// try {
// session.beginTransaction();
// student = session.get(Student.class, id);
// session.getTransaction().commit();
// } catch (HibernateException e) {
// e.printStackTrace();
// }
// return student;
// }
//
// static List<Student> readAllRows(SessionFactory factory, String table) {
// Session session = factory.getCurrentSession();
// List<Student> list = new ArrayList<>();
// try {
// session.beginTransaction();
// list = session.createQuery("from " + table).getResultList();
// session.getTransaction().commit();
// } catch (HibernateException e) {
// e.printStackTrace();
// }
// return list;
// }
//
// static void printAllRows(SessionFactory factory, String table) {
// Session session = factory.getCurrentSession();
// List<Student> list = new ArrayList<>();
// try {
// session.beginTransaction();
// list = session.createQuery("from " + table).getResultList();
// for (Student student : list) {
// System.out.println(student);
// }
// session.getTransaction().commit();
// } catch (HibernateException e) {
// e.printStackTrace();
// }
// }
//
// static void truncateTable(SessionFactory factory, String table) {
// Session session = factory.getCurrentSession();
// try {
// session.beginTransaction();
// session.createSQLQuery("truncate table Student").executeUpdate();
// session.getTransaction().commit();
// } catch (HibernateException e) {
// e.printStackTrace();
// }
// }
//
// static void saveListToDb(SessionFactory factory, List<Student> list) {
// Session session = factory.getCurrentSession();
// // list = populateList();
// try {
// session.beginTransaction();
// for (Student student : list) {
// session.save(student);
// }
// session.getTransaction().commit();
// } catch (HibernateException e) {
// e.printStackTrace();
// }
// }
//
// static void rewriteTable(SessionFactory factory, String table) {
// List<Student> list = readAllRows(factory, table);
// truncateTable(factory, table);
// System.out.println("STUDENT BEFORE");
// System.out.println("*********************************************");
// for (Student student : list) {
// System.out.println(student);
// // student.setId(0);
// System.out.println(student);
// }
// System.out.println("STUDENTS AFTER");
// System.out.println("*********************************************");
// printAllRows(factory, table);
// saveListToDb(factory, list);
// list = readAllRows(factory, table);
// System.out.println("STUDENTS AFTER AFTER");
// System.out.println("*********************************************");
// printAllRows(factory, table);
// }
//
// public static List<Student> readByName(Session session, String name) {
// List<Student> theStudents = session
// .createQuery("from Student s where s.firstName='" + name + "'")
// .getResultList();
// return theStudents;
// }
//
// public static List<Student> readByNameOrEmail(Session session, String name,
// String email) {
// List<Student> theStudents = session
// .createQuery("from Student s where s.firstName='" + name
// + "' or s.email='" + email + "'")
// .getResultList();
// return theStudents;
// }
//
// public static List<Student> readByNameAndEmailWildcard(Session session,
// String name, String emailWild) {
// List<Student> theStudents4 = session
// .createQuery("from Student s where s.firstName='" + name
// + "' or s.email like '" + emailWild + "'")
// .getResultList();
// return theStudents4;
// }
//
// static void updateStudentAllEmail(SessionFactory factory) {
// Session session = factory.getCurrentSession();
// session.beginTransaction();
// session.createQuery("update Student set email='foo@yahoo.com'")
// .executeUpdate();
// session.getTransaction().commit();
// }
//
// static void updateStudentById(SessionFactory factory, int id) {
// Session session = factory.getCurrentSession();
// session.beginTransaction();
// session.createQuery(
// "update Student set firstName='Patric' where id=" + id)
// .executeUpdate();
// session.getTransaction().commit();
// }
//
// static void deleteStudentById(SessionFactory factory, int id) {
// Session session = factory.getCurrentSession();
// session.beginTransaction();
// session.createQuery("delete from Student where id=" + id)
// .executeUpdate();
// session.getTransaction().commit();
// }
//
// static void deleteStudentAll(SessionFactory factory) {
// Session session = factory.getCurrentSession();
// session.beginTransaction();
// session.createQuery("delete Student").executeUpdate();
// session.getTransaction().commit();
// }
//
// static List<Student> populateList() {
// List<Student> list = new ArrayList<Student>();
// list.add(new Student("Daffy", "Duck", "daffy@luv2code.com"));
// list.add(new Student("Paul", "Walker", "paul@luv2code.com"));
// list.add(new Student("Vin", "Diezel", "riddik@yahoo.com"));
// list.add(new Student("John", "Doe", "john@yahoo.com"));
// list.add(new Student("Marry", "Public", "republic@yahoo.com"));
// list.add(new Student("Nika", "Props", "popoil@gmail.com"));
// list.add(new Student("Betany", "Rodrigo", "goom@luv2code.com"));
// list.add(new Student("White", "Deg", "winnie@gmail.com"));
// return list;
// }
//
// }
