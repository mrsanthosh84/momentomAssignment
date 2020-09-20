/**
 * 
 */
package com.momentum.assignment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.momentum.assignment.model.Employee;

/**
 * @author manickas
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class BuildHierarchyTreeTest {

	@Test
	public void givenStringDataThenStoredIntoEmployeeObj() {
		BuildHierarchyTree buildHierarchyTree = new BuildHierarchyTree();
		 String[] lines = {
				 "Alan 100 150",
				 "Jamie 150"
		};	   
		buildHierarchyTree.readDataAndCreateMap(lines);
		assertEquals(150, buildHierarchyTree.getEmployeeObj().getId());
		assertEquals("Jamie", buildHierarchyTree.getEmployeeObj().getName());
	}
	
	@Test
	public void givenNoManagerThenEmployeeObjIsEmpty() {
		BuildHierarchyTree buildHierarchyTree = new BuildHierarchyTree();
		 String[] lines = {
				 "Alan 100 150"
		};	   
		buildHierarchyTree.readDataAndCreateMap(lines);
		assertNull(buildHierarchyTree.getEmployeeObj());
	}
	

	@Test
	public void givenStringArrayOfEmployeeThenReturnSubordinates() {
		BuildHierarchyTree buildHierarchyTree = new BuildHierarchyTree();
		 String[] lines = {
				 "Alan 100 150",
				 "Jamie 150"
		};	   
		buildHierarchyTree.readDataAndCreateMap(lines);
		List<Employee> subs = buildHierarchyTree.getSubsById(150);
		assertEquals(1, subs.size());
	}
	
	@Test
	public void givenStringArrayOfWithoutManagerThenReturnSubordinatesIsEmpty() {
		BuildHierarchyTree buildHierarchyTree = new BuildHierarchyTree();
		 String[] lines = {
				 "Alan 100 150"
		};	   
		buildHierarchyTree.readDataAndCreateMap(lines);
		List<Employee> subs = buildHierarchyTree.getSubsById(250);
		assertEquals(0, subs.size());
	}
}
