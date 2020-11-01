/**
 * 
 */
package com.suresh.template;

/**
 * @author manisx
 *
 */
public abstract class HouseTemplate {
	public final void buildHouse() {
		buildFoundation();
		buildPillar();
		buildWall();
		buildWindow();
		System.out.println("House is built....");
	}
	
	final void buildFoundation(){
		System.out.println("Building foundation with cement, iron and rod....");
	}
	
	final void buildWindow(){
		System.out.println("Building Window with Glass...");
	}
	
	abstract void buildPillar();
	abstract void buildWall();
}
