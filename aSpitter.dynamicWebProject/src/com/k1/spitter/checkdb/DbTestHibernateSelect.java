package com.k1.spitter.checkdb;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.k1.spitter.entity.Spitter;

public class DbTestHibernateSelect {

	public static void main(String[] args) {

		// class SessionFactory
		// reads the hibernate config file
		// creates Session object
		// heavy-weight object
		// only create once in your app

		// Session
		// wraps a JDBC connection
		// main object used to save\retrieve objects
		// short-lived object
		// retrieved from Seccion factory

		// create session factory
		// if configure() is empty -
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
		List<Spitter> spittersByNameAndEmail = session
				.createQuery("from Spitter s where s.email like '%@yahoo.com'").getResultList();
		List<Spitter> spittersByNameAndEmail1 = session
				.createQuery("from Spitter s where s.email like '%@yahoo.com' and s.userName='iren'").getResultList();
		List<Spitter> spittersByNameAndEmail2 = session
				.createQuery("from Spitter s where s.userName='iren' and s.email like '%@yahoo%'").getResultList();
		List<Spitter> spittersByNameAndEmail3 = session
				.createQuery("from Spitter s where  s.email like 'b%@yahoo%'").getResultList();
//		session.createQuery("from Student s where s.firstName='"
//				+ name + "' or s.email like '" + emailWild + "'").getResultList();

		// don't forget to close factory at the end
		// spring will take on himself handling session open and close, but when
		// we using poor hibernate
		// better way to wrap all it try{}finally{factory.close();} block
		factory.close();

//		for (Spitter spitter : spittersAll) {
//			System.out.println(spitter);
//		}
//		DbTestHibernateMethods.printSpitters(spittersByName);
//		DbTestHibernateMethods.printSpitters(spittersByEmail);
		System.err.println("=================");
//		DbTestHibernateMethods.printSpitters(spittersByNameAndEmail);
//		DbTestHibernateMethods.printSpitters(spittersByNameAndEmail1);
		DbTestHibernateMethods.printSpitters(spittersByNameAndEmail2);
		DbTestHibernateMethods.printSpitters(spittersByNameAndEmail3);
	}
}


//14.16. Tips & Tricks
//
//You can count the number of query results without returning them:
//
//( (Integer) session.createQuery("select count(*) from ....").iterate().next() ).intValue()
//To order a result by the size of a collection, use the following query:
//
//select usr.id, usr.name
//from User as usr
//    left join usr.messages as msg
//group by usr.id, usr.name
//order by count(msg)
//If your database supports subselects, you can place a condition upon selection size in the where clause of your query:
//
//from User usr where size(usr.messages) >= 1
//If your database does not support subselects, use the following query:
//
//select usr.id, usr.name
//from User usr.name
//    join usr.messages msg
//group by usr.id, usr.name
//having count(msg) >= 1
//As this solution cannot return a User with zero messages because of the inner join, the following form is also useful:
//
//select usr.id, usr.name
//from User as usr
//    left join usr.messages as msg
//group by usr.id, usr.name
//having count(msg) = 0
//Properties of a JavaBean can be bound to named query parameters:
//
//Query q = s.createQuery("from foo Foo as foo where foo.name=:name and foo.size=:size");
//q.setProperties(fooBean); // fooBean has getName() and getSize()
//List foos = q.list();
//Collections are pageable by using the Query interface with a filter:
//
//Query q = s.createFilter( collection, "" ); // the trivial filter
//q.setMaxResults(PAGE_SIZE);
//q.setFirstResult(PAGE_SIZE * pageNumber);
//List page = q.list();
//Collection elements can be ordered or grouped using a query filter:
//
//Collection orderedCollection = s.filter( collection, "order by this.amount" );
//Collection counts = s.filter( collection, "select this.type, count(this) group by this.type" );
//You can find the size of a collection without initializing it:
//
//( (Integer) session.createQuery("select count(*) from ....").iterate().next() ).intValue();
//14.17. Components
//
//Components can be used similarly to the simple value types that are used in HQL queries. They can appear in the select clause as follows:
//
//select p.name from Person p
//select p.name.first from Person p
//where the Person's name property is a component. Components can also be used in the where clause:
//
//from Person p where p.name = :name
//from Person p where p.name.first = :firstName
//Components can also be used in the order by clause:
//
//from Person p order by p.name
//from Person p order by p.name.first
//Another common use of components is in row value constructors.
//
//14.18. Row value constructor syntax
//
//HQL supports the use of ANSI SQL row value constructor syntax, sometimes referred to AS tuple syntax, even though the underlying database may not support that notion. Here, we are generally referring to multi-valued comparisons, typically associated with components. Consider an entity Person which defines a name component:
//
//from Person p where p.name.first='John' and p.name.last='Jingleheimer-Schmidt'
//That is valid syntax although it is a little verbose. You can make this more concise by using row value constructor syntax:
//
//from Person p where p.name=('John', 'Jingleheimer-Schmidt')
//It can also be useful to specify this in the select clause:
//
//select p.name from Person p
//Using row value constructor syntax can also be beneficial when using subqueries that need to compare against multiple values:
//
//from Cat as cat
//where not ( cat.name, cat.color ) in (
//    select cat.name, cat.color from DomesticCat cat
//)
//One thing to consider when deciding if you want to use this syntax, is that the query will be dependent upon the ordering of the component sub-properties in the metadata.
