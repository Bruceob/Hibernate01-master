package com.emerson.test.Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.emerson.test.Bean.Student;
public class test{ 

	@Test
	public void testAdd(){
	//1.加载配置文件
		Configuration cfg=new Configuration();
		cfg.configure();
	//2.创建sessionfactory对象
		SessionFactory sessionfactory=cfg.buildSessionFactory();
	//3.使用sessionfactory创建session对象
		Session session=sessionfactory.openSession();
	//4.开启事务
		Transaction tx=session.beginTransaction();
	//5.具体逻辑CRUD操作
		Student student=new Student();
		student.setS_name("小明");
		student.setS_number("123456");
		
		session.save(student);
		
	//6.提交事务
		tx.commit();
	//7.关闭资源
		session.close();
		sessionfactory.close();
	}
}