package com.cduestc.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.cduestc.mybatis.Department;
import com.cduestc.mybatis.Employee;
import com.cduestc.mybatis.dao.DepartmentMapper;
import com.cduestc.mybatis.dao.EmployeeMapperDynamicSQL;
import com.cduestc.mybatis.dao.EmployeeMapperPlus;



public class MybatisTestPlus {

	public SqlSessionFactory getSqlSessionFactory() throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}

	@Test
	public void test0() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			EmployeeMapperPlus eMapperPlus = sqlSession.getMapper(EmployeeMapperPlus.class);
			Employee employee = eMapperPlus.getEmpAndDept(3);
			System.out.println(employee);
			sqlSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		
	}
	@Test
	public void test1() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			EmployeeMapperPlus eMapperPlus = sqlSession.getMapper(EmployeeMapperPlus.class);
			Employee employee = eMapperPlus.getEmpByIdStep(3);
			System.out.println(employee);
			System.out.println(employee.getDept());
			sqlSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		
	}
	@Test
	public void test2() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			DepartmentMapper dMapper = sqlSession.getMapper(DepartmentMapper.class);
			Department department = dMapper.getDeptByIdPlus(3);
			System.out.println(department);
			System.out.println(department.getEmps());
			sqlSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		
	}
	@Test
	public void test3() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			EmployeeMapperDynamicSQL mapperDynamicSQL = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
			Employee employee = new Employee(4,"%i%","2","LiSa@qq.com");
			List<Employee> emps = mapperDynamicSQL.getEmpsByIf(employee);
			for(Employee employee2 : emps){
				System.out.println(employee2);
			}
			sqlSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		
	}
	@Test
	public void test4() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			EmployeeMapperDynamicSQL mapperDynamicSQL = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
			Employee employee = new Employee(0,null,null,null);
			List<Employee> emps = mapperDynamicSQL.getEmpsByChoose(employee);
			for(Employee employee2 : emps){
				System.out.println(employee2);
			}
			sqlSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		
	}
	
	@Test
	public void test5() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			EmployeeMapperDynamicSQL mapperDynamicSQL = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
			Employee employee = new Employee(1,"Tom","1","Tom@qq.com");
			mapperDynamicSQL.updateEmp(employee);
			
			sqlSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		
	}
	
	@Test
	public void test6() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			EmployeeMapperDynamicSQL mapperDynamicSQL = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
			Employee employee = new Employee(1,"TOM","0","TOM@qq.com");
			mapperDynamicSQL.updateEmpByTrim(employee);
			
			sqlSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		
	}
	@Test
	public void test7() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			EmployeeMapperDynamicSQL mapperDynamicSQL = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
			List<Integer> ids=Arrays.asList(1,2,3,4);
			List<Employee> emList = mapperDynamicSQL.getEmpsByForeach(ids);
			for(Employee employee : emList){
				System.out.println(employee);
			}
			sqlSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		
	}
	@Test
	public void test8() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			EmployeeMapperDynamicSQL mapperDynamicSQL = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
//			List<Employee> employees = new ArrayList<Employee>();
//			employees.add(new Employee("Mike","0","Mike@qq.com",new Department(1)));
//			employees.add(new Employee("Jams","1","Jams@qq.com",new Department(2)));
//			employees.add(new Employee("Poul","1","Poul@qq.com",new Department(3)));
//			mapperDynamicSQL.addEmps(employees);
			List<Employee> employees2 = new ArrayList<Employee>();
			employees2.add(new Employee("Mike3","0","Mike3@qq.com",new Department(1)));
			employees2.add(new Employee("Jams3","1","Jams3@qq.com",new Department(2)));
			employees2.add(new Employee("Poul3","1","Poul3@qq.com",new Department(3)));
			mapperDynamicSQL.addEmps2(employees2);
			sqlSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		
	}
	@Test
	public void test9() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			EmployeeMapperDynamicSQL mapperDynamicSQL = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
			Employee employee = new Employee();
			employee.setLastname("i");
			List<Employee> employees = mapperDynamicSQL.getEmpsTestInnerParameter(employee);
			for(Employee employee2 : employees){
				System.out.println(employee2);
			}
			sqlSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		
	}
	@Test
	public void testInsertColumn() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			EmployeeMapperDynamicSQL mapperDynamicSQL = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
			List<Employee> employees2 = new ArrayList<Employee>();
			employees2.add(new Employee("Mike3","0","Mike3@qq.com",new Department(1)));
			employees2.add(new Employee("Jams3","1","Jams3@qq.com",new Department(2)));
			employees2.add(new Employee("Poul3","1","Poul3@qq.com",new Department(3)));
			mapperDynamicSQL.addEmps(employees2);
			sqlSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		
	}
	
}
