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
		if (width <= 0 || height <= 0) {
			throw new IllegalArgumentException("Door dimensions must be positive");
		}
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
		if (width <= 0) {
			throw new IllegalArgumentException("Door width must be positive");
		}
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		if (height <= 0) {
			throw new IllegalArgumentException("Door height must be positive");
		}
		this.height = height;
	}
	
	//</editor-fold>

}
