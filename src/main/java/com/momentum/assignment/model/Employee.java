/**
 * 
 */
package com.momentum.assignment.model;

import java.util.List;

/**
 * @author manickas
 *
 */

public class Employee {
	private int id;
	private String name;
	private int managerId;
	private List<Employee> subordinates;
	
	public Employee() {}
    
    //Constructor, Time O(1), Space O(1)
    public Employee(String id,  String name, String managerId) {    
	        this.id = Integer.parseInt(id);	        
	        this.name = name;
	        this.managerId = Integer.parseInt(managerId);
    }
    
    public Employee(String id,  String name) {    
        this.id = Integer.parseInt(id);	        
        this.name = name;
    }

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the managerId
	 */
	public int getManagerId() {
		return managerId;
	}

	/**
	 * @param managerId the managerId to set
	 */
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the subordinates
	 */
	public List<Employee> getSubordinates() {
		return subordinates;
	}

	/**
	 * @param subordinates the subordinates to set
	 */
	public void setSubordinates(List<Employee> subordinates) {
		this.subordinates = subordinates;
	}
    
}
