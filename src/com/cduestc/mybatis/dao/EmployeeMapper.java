package com.cduestc.mybatis.dao;

import java.util.List;
import java.util.Map;


import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.cduestc.mybatis.Employee;



public interface EmployeeMapper {
	
	public Employee getEmployeeById(Integer id);
	
	public void addEmp(Employee employee);
	public boolean updateEmp(Employee employee);
	public void deleteEmpById(Integer id);
	/*
	 * ��mybatis����������ʱ���������������װһ��Map��
	 * key��:param1,param2,,,���߲���������(0,1,2)
	 * value ��ʵ�ʵĲ���ֵ
	 * ��EmployeeMapper.xml�����ļ���sql��䣺select from tbl_employee where id = #{param1} and last_name = #{param2}
	 */
	public Employee getEmployeeByIdAndLastName(Integer id,String lastName);
//	����������:����ֱ���ڷ����и������ָ��
	public Employee getEmployeeByIdAndLastName2(@Param("id")Integer id,@Param("last_name")String lastName);

//	POJO:������������ҵ���߼�������ģ�ͣ����ǾͿ���ֱ�Ӵ���Pojo;#{������}��ȡ�����˵�Pojo������ֵ
//	Map��������ǣ�û�ж�Ӧ��pojo�����Դ���map,#{key}
	public Employee getEmpByMap(Map<String, Object> map);
	
//	liek�÷���ģ����ѯ�����ؼ���
	public List<Employee> getEmpsBylastNameLike(String lastName);
	
//	����һ��map����
	public Map<String, Object> getEmpsByIdReturnMap(Integer id);
	
//	���ض��map����
	@MapKey("id")//����mybatis map������ֵ����id
	public Map<Integer, Employee> getEmpsByLastNameLikeReturnMap(String lastname);
}
