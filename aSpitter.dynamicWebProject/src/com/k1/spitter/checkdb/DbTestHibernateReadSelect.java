package com.k1.spitter.checkdb;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.k1.spitter.entity.Spitter;

//hibernate criteria (to read)https://www.tutorialspoint.com/hibernate/hibernate_criteria_queries.htm
public class DbTestHibernateReadSelect {

	public static void main(String[] args) {

		// class SessionFactory reads the hibernate config file
		// creates Session object heavy-weight object only create once in your
		// app

		// Session wraps a JDBC connection main object used to save\retrieve
		// objects
		// short-lived object retrieved from Seccion factory

		// create session factory if configure() is empty -
		// will use default "hibernate.cfg.xml" from src root
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Spitter.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		// start transaction
		session.beginTransaction();

		/////////////////////// SELECT/////////////////////////////
		// remember in query quotes in java - field name must equals to name in
		// entity, not table, hibernate will automatically remap field - using
		// @Column name value
		// select all from table,
		// equals SQL "select * from Spitter"
		List<Spitter> spittersAll = session.createQuery("from Spitter").getResultList();

		// select all with username "habuma",
		// equals SQL "select * from spitter where username='habuma'"
		List<Spitter> spittersByName = session.createQuery("from Spitter s where s.userName='habuma'").getResultList();

		// select all with username "habuma",
		// equals SQL "select * from spitter where email='habuma'"
		List<Spitter> spittersByEmail = session.createQuery("from Spitter s where s.email='artnames@habuma.com'")
				.getResultList();

		// select all with name benson and email yahoo
		// equals SQL
		List<Spitter> spittersByNameAndEmail = session.createQuery("from Spitter s where s.email like '%@yahoo.com'")
				.getResultList();
		List<Spitter> spittersByNameAndEmail1 = session
				.createQuery("from Spitter s where s.email like '%@yahoo.com' and s.userName='iren'").getResultList();
		List<Spitter> spittersByNameAndEmail2 = session
				.createQuery("from Spitter s where s.userName='iren' and s.email like '%@yahoo%'").getResultList();
		List<Spitter> spittersByNameAndEmail3 = session.createQuery("from Spitter s where  s.email like 'b%@yahoo%'")
				.getResultList();
		// session.createQuery("from Student s where s.firstName='"
		// + name + "' or s.email like '" + emailWild + "'").getResultList();

		// don't forget to close factory at the end
		// spring will take on himself handling session open and close, but when
		// we using poor hibernate
		// better way to wrap all it try{}finally{factory.close();} block
		factory.close();

		// for (Spitter spitter : spittersAll) {
		// System.out.println(spitter);
		// }
		// DbTestHibernateMethods.printSpitters(spittersByName);
		// DbTestHibernateMethods.printSpitters(spittersByEmail);
		System.err.println("=================");
		// DbTestHibernateMethods.printSpitters(spittersByNameAndEmail);
		// DbTestHibernateMethods.printSpitters(spittersByNameAndEmail1);
		MethodsPrint.printSpitters(spittersByNameAndEmail2);
		MethodsPrint.printSpitters(spittersByNameAndEmail3);

		factory.close();
	}
}

// https://www.tutorialspoint.com/hibernate/hibernate_query_language.htm
// FROM Clause
// You will use FROM clause if you want to load a complete persistent objects
// into memory. Following is the simple syntax of using FROM clause:
//
// String hql = "FROM Employee";
// Query query = session.createQuery(hql);
// List results = query.list();
// If you need to fully qualify a class name in HQL, just specify the package
// and class name as follows:
//
// String hql = "FROM com.hibernatebook.criteria.Employee";
// Query query = session.createQuery(hql);
// List results = query.list();
// AS Clause
// The AS clause can be used to assign aliases to the classes in your HQL
// queries, specially when you have long queries. For instance, our previous
// simple example would be the following:
//
// String hql = "FROM Employee AS E";
// Query query = session.createQuery(hql);
// List results = query.list();
// The AS keyword is optional and you can also specify the alias directly after
// the class name, as follows:
//
// String hql = "FROM Employee E";
// Query query = session.createQuery(hql);
// List results = query.list();
// SELECT Clause
// The SELECT clause provides more control over the result set than the from
// clause. If you want to obtain few properties of objects instead of the
// complete object, use the SELECT clause. Following is the simple syntax of
// using SELECT clause to get just first_name field of the Employee object:
//
// String hql = "SELECT E.firstName FROM Employee E";
// Query query = session.createQuery(hql);
// List results = query.list();
// It is notable here that Employee.firstName is a property of Employee object
// rather than a field of the EMPLOYEE table.
//
// WHERE Clause
// If you want to narrow the specific objects that are returned from storage,
// you use the WHERE clause. Following is the simple syntax of using WHERE
// clause:
//
// String hql = "FROM Employee E WHERE E.id = 10";
// Query query = session.createQuery(hql);
// List results = query.list();
// ORDER BY Clause
// To sort your HQL query's results, you will need to use the ORDER BY clause.
// You can order the results by any property on the objects in the result set
// either ascending (ASC) or descending (DESC). Following is the simple syntax
// of using ORDER BY clause:
//
// String hql = "FROM Employee E WHERE E.id > 10 ORDER BY E.salary DESC";
// Query query = session.createQuery(hql);
// List results = query.list();
// If you wanted to sort by more than one property, you would just add the
// additional properties to the end of the order by clause, separated by commas
// as follows:
//
// String hql = "FROM Employee E WHERE E.id > 10 " +
// "ORDER BY E.firstName DESC, E.salary DESC ";
// Query query = session.createQuery(hql);
// List results = query.list();
// GROUP BY Clause
// This clause lets Hibernate pull information from the database and group it
// based on a value of an attribute and, typically, use the result to include an
// aggregate value. Following is the simple syntax of using GROUP BY clause:
//
// String hql = "SELECT SUM(E.salary), E.firtName FROM Employee E " +
// "GROUP BY E.firstName";
// Query query = session.createQuery(hql);
// List results = query.list();
// Using Named Paramters
// Hibernate supports named parameters in its HQL queries. This makes writing
// HQL queries that accept input from the user easy and you do not have to
// defend against SQL injection attacks. Following is the simple syntax of using
// named parameters:
//
// String hql = "FROM Employee E WHERE E.id = :employee_id";
// Query query = session.createQuery(hql);
// query.setParameter("employee_id",10);
// List results = query.list();
// UPDATE Clause
// Bulk updates are new to HQL with Hibernate 3, and deletes work differently in
// Hibernate 3 than they did in Hibernate 2. The Query interface now contains a
// method called executeUpdate() for executing HQL UPDATE or DELETE statements.
//
// The UPDATE clause can be used to update one or more properties of an one or
// more objects. Following is the simple syntax of using UPDATE clause:
//
// String hql = "UPDATE Employee set salary = :salary " +
// "WHERE id = :employee_id";
// Query query = session.createQuery(hql);
// query.setParameter("salary", 1000);
// query.setParameter("employee_id", 10);
// int result = query.executeUpdate();
// System.out.println("Rows affected: " + result);
// DELETE Clause
// The DELETE clause can be used to delete one or more objects. Following is the
// simple syntax of using DELETE clause:
//
// String hql = "DELETE FROM Employee " +
// "WHERE id = :employee_id";
// Query query = session.createQuery(hql);
// query.setParameter("employee_id", 10);
// int result = query.executeUpdate();
// System.out.println("Rows affected: " + result);
// INSERT Clause
// HQL supports INSERT INTO clause only where records can be inserted from one
// object to another object. Following is the simple syntax of using INSERT INTO
// clause:
//
// String hql = "INSERT INTO Employee(firstName, lastName, salary)" +
// "SELECT firstName, lastName, salary FROM old_employee";
// Query query = session.createQuery(hql);
// int result = query.executeUpdate();
// System.out.println("Rows affected: " + result);
// Aggregate Methods
// HQL supports a range of aggregate methods, similar to SQL. They work the same
// way in HQL as in SQL and following is the list of the available functions:
//
// S.N. Functions Description
// 1 avg(property name) The average of a property's value
// 2 count(property name or *) The number of times a property occurs in the
// results
// 3 max(property name) The maximum value of the property values
// 4 min(property name) The minimum value of the property values
// 5 sum(property name) The sum total of the property values
// The distinct keyword only counts the unique values in the row set. The
// following query will return only unique count:
//
// String hql = "SELECT count(distinct E.firstName) FROM Employee E";
// Query query = session.createQuery(hql);
// List results = query.list();
// Pagination using Query
// There are two methods of the Query interface for pagination.
//
// S.N. Method & Description
// 1 Query setFirstResult(int startPosition)
// This method takes an integer that represents the first row in your result
// set, starting with row 0.
//
// 2 Query setMaxResults(int maxResult)
// This method tells Hibernate to retrieve a fixed number maxResults of objects.
//
// Using above two methods together, we can construct a paging component in our
// web or Swing application. Following is the example which you can extend to
// fetch 10 rows at a time:
//
// String hql = "FROM Employee";
// Query query = session.createQuery(hql);
// query.setFirstResult(1);
// query.setMaxResults(10);
// List results = query.list();

// 14.16. Tips & Tricks
//
// You can count the number of query results without returning them:
//
// ( (Integer) session.createQuery("select count(*) from ....").iterate().next()
// ).intValue()
// To order a result by the size of a collection, use the following query:
//
// select usr.id, usr.name
// from User as usr
// left join usr.messages as msg
// group by usr.id, usr.name
// order by count(msg)
// If your database supports subselects, you can place a condition upon
// selection size in the where clause of your query:
//
// from User usr where size(usr.messages) >= 1
// If your database does not support subselects, use the following query:
//
// select usr.id, usr.name
// from User usr.name
// join usr.messages msg
// group by usr.id, usr.name
// having count(msg) >= 1
// As this solution cannot return a User with zero messages because of the inner
// join, the following form is also useful:
//
// select usr.id, usr.name
// from User as usr
// left join usr.messages as msg
// group by usr.id, usr.name
// having count(msg) = 0
// Properties of a JavaBean can be bound to named query parameters:
//
// Query q = s.createQuery("from foo Foo as foo where foo.name=:name and
// foo.size=:size");
// q.setProperties(fooBean); // fooBean has getName() and getSize()
// List foos = q.list();
// Collections are pageable by using the Query interface with a filter:
//
// Query q = s.createFilter( collection, "" ); // the trivial filter
// q.setMaxResults(PAGE_SIZE);
// q.setFirstResult(PAGE_SIZE * pageNumber);
// List page = q.list();
// Collection elements can be ordered or grouped using a query filter:
//
// Collection orderedCollection = s.filter( collection, "order by this.amount"
// );
// Collection counts = s.filter( collection, "select this.type, count(this)
// group by this.type" );
// You can find the size of a collection without initializing it:
//
// ( (Integer) session.createQuery("select count(*) from ....").iterate().next()
// ).intValue();
// 14.17. Components
//
// Components can be used similarly to the simple value types that are used in
// HQL queries. They can appear in the select clause as follows:
//
// select p.name from Person p
// select p.name.first from Person p
// where the Person's name property is a component. Components can also be used
// in the where clause:
//
// from Person p where p.name = :name
// from Person p where p.name.first = :firstName
// Components can also be used in the order by clause:
//
// from Person p order by p.name
// from Person p order by p.name.first
// Another common use of components is in row value constructors.
//
// 14.18. Row value constructor syntax
//
// HQL supports the use of ANSI SQL row value constructor syntax, sometimes
// referred to AS tuple syntax, even though the underlying database may not
// support that notion. Here, we are generally referring to multi-valued
// comparisons, typically associated with components. Consider an entity Person
// which defines a name component:
//
// from Person p where p.name.first='John' and
// p.name.last='Jingleheimer-Schmidt'
// That is valid syntax although it is a little verbose. You can make this more
// concise by using row value constructor syntax:
//
// from Person p where p.name=('John', 'Jingleheimer-Schmidt')
// It can also be useful to specify this in the select clause:
//
// select p.name from Person p
// Using row value constructor syntax can also be beneficial when using
// subqueries that need to compare against multiple values:
//
// from Cat as cat
// where not ( cat.name, cat.color ) in (
// select cat.name, cat.color from DomesticCat cat
// )
// One thing to consider when deciding if you want to use this syntax, is that
// the query will be dependent upon the ordering of the component sub-properties
// in the metadata.
