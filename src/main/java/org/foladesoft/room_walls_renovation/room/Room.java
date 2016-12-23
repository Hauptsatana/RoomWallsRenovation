/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foladesoft.room_walls_renovation.room;

import java.util.List;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

/**
 *
 * @author Vladislav
 */
public class Room {
	
	private double length;
	private double width;
	private double height;
	
	public List<Door> doors;
	public List<Window> windows;

	public Room(double length, double width, double height, List<Door> doors, List<Window> windows) {
		this.length = length;
		this.width = width;
		this.height = height;
		this.doors = doors;
		this.windows = windows;
	}
	
	public double calcPerimeter() {
		return (length + width) * 2;
	}
	
	// Total wall area for this room
	public double calcTotalWallArea() {
		return width * height;
	}
	
	// Wall area occupied with doors
	public double calcDoorArea() {
		return doors.stream().collect(
				Collectors.summingDouble((Door d) -> d.calcArea()));
	}
	
	// Wall area occupied with windows
	public double calcWindowArea() {
		return windows.stream().collect(
				Collectors.summingDouble((Window w) -> w.calcArea()));
	}
	
	// Wall area free from windows and doors
	public double calcUnusedWallArea() {
		double doorArea = calcDoorArea();
		double windowArea = calcWindowArea();
		return calcTotalWallArea() - doorArea - windowArea;
	}

	//<editor-fold defaultstate="collapsed" desc="Getters & Setters">
		
	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

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

	public List<Door> getDoors() {
		return doors;
	}

	public void setDoors(List<Door> doors) {
		this.doors = doors;
	}

	public List<Window> getWindows() {
		return windows;
	}

	public void setWindows(List<Window> windows) {
		this.windows = windows;
	}
	
	//</editor-fold>
	
}
