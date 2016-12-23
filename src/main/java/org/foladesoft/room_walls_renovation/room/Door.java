/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foladesoft.room_walls_renovation.room;

/**
 *
 * @author Vladislav
 */
public class Door {
	
	private double width;
	private double height;

	public Door(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public double calcArea() {
		return width * height;
	}
	
	//<editor-fold defaultstate="collapsed" desc="Getters & Setters">
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	//</editor-fold>

}
