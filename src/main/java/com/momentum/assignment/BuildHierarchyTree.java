/**
 * 
 */
package com.momentum.assignment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.momentum.assignment.model.Employee;

/**
 * @author Santhosh Mancikam
 *
 */
public class BuildHierarchyTree {
	private Map<Integer, Employee> employees = new HashMap<>(); //stores (id, employee) pair
	private Employee employeeObj;
	
	/**
	 * Read data and build map, Iteration, Time O(n), Space O(n), n is number of employees
	 * @param lines
	 */
	protected void readDataAndCreateMap(String[] lines)  {        		
		Employee employee = null;
		for (String strLine : lines) { 			
			String[] values = strLine.split(" ");
			if (values.length >= 3) {					
				employee = new Employee(values[1], values[0], values[2]);		          
			} else {
				employee = new Employee(values[1], values[0], BigDecimal.ZERO.toString());	
			}
			employees.put(employee.getId(), employee);
			if (employee.getManagerId() == 0) {
				employeeObj = employee;
			}
		}
	}
	
	/**
	 * Build tree, Recursion, Time O(n), Space O(h), n is number of employees, h is levels of hierarchy tree
	 * @param root
	 */
	protected void buildHierarchyTree(Employee root) {
		 Employee employee = root;
		 List<Employee> subs = getSubsById(employee.getId());
		 employee.setSubordinates(subs);
		 if (subs.size() == 0) {
			 return;
		 }
		 for (Employee em : subs) {
	    	buildHierarchyTree(em);
		 }
	 }	 
	 
	
	 /**
	  * Get subordinates list by given id, Time O(n), Space O(k) ~ O(n), k is number of subordinates
	  * 
	  * @param managerId
	  * @return
	  */
	protected List<Employee> getSubsById(int managerId) {
		 List<Employee> subs = new ArrayList<Employee>();
		 for (Employee em : employees.values()) {
			 if (em.getManagerId() == managerId) {
				 subs.add(em);
			 }
		 }
		 return subs;
	}
		 
	/**
	 * Print tree, Recursion, Time O(n), Space O(h)
	 * 
	 * @param root
	 * @param level
	 */
	protected void printHierarchyTree(Employee root, int level) {
		for (int i = 0; i < level; i++) 
			System.out.print("\t");	 
			System.out.println(root.getName());		 
			List<Employee> subs = root.getSubordinates();
			for (Employee em : subs) {
				printHierarchyTree(em, level+1);
			}
	}
	
	
	 
	/**
	 * @return the employees
	 */
	public Map<Integer, Employee> getEmployees() {
		return employees;
	}

	/**
	 * @return the employeeObj
	 */
	public Employee getEmployeeObj() {
		return employeeObj;
	}

	public static void main(String[] args) {		  
		 String[] lines = {
				 "Alan 100 150",
				 "Martin 220 100",
				 "Jamie 150",
				 "Alex 275 100",
				 "Steve 400 150",
				 "David 190 400"
		 };	   
		 BuildHierarchyTree tree = new BuildHierarchyTree();
	     tree.readDataAndCreateMap(lines);
	     tree.buildHierarchyTree(tree.employeeObj);
	     tree.printHierarchyTree(tree.employeeObj, 0);
	}
}
