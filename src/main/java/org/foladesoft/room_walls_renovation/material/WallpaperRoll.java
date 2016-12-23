/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foladesoft.room_walls_renovation.material;

import org.foladesoft.room_walls_renovation.room.Room;

/**
 *
 * @author Vladislav
 */
public class WallpaperRoll {
	
	public static enum RapportType { Zero, Horizontal, Diagonal }
	
	private double width;
	private double length;
	private RapportType rapportType;
	private double rapportValue;


	public WallpaperRoll(double width, double length) {
		this(width, length, RapportType.Zero, 0);
	}

	public WallpaperRoll(double width, double length, RapportType rapportType, double rapportValue) {
		this.width = width;
		this.length = length;
		this.rapportType = rapportType;
		this.rapportValue = rapportValue;

	}
	
	// Strip length for desired height
	public double calcStripLength(double height) {
		switch (rapportType) {
			case Zero: 
				return height + 0.1;
			case Horizontal: 
				return Math.ceil(height / rapportValue) * rapportValue + 0.1;
			case Diagonal: 
				return Math.ceil(height / rapportValue) * rapportValue 
					+ rapportValue / 2 + 0.1;
			default:
				throw new RuntimeException("Could not match rapportType with proper Value");
		}
	}
	
	// Possible strips amunt for desired extent
	public int calcStripsAmount(double extent) {
		return (int)Math.ceil(extent / width);
	}
	
	// Amount of strips of desired length in roll
	public int calcStripsInRoll(double stripLength) {
		return (int)Math.floor(length / stripLength);
	}
	
	// Amount of rolls for desired room
	public int calcRollsAmount(Room room) {
		double stripLength = calcStripLength(room.getHeight());
		int stripsAmount = calcStripsAmount(room.calcPerimeter());
		return (int)Math.ceil((double)stripsAmount / calcStripsInRoll(stripLength));
	}
	
	//<editor-fold defaultstate="collapsed" desc="Getters & Setters">
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public RapportType getRapportType() {
		return rapportType;
	}

	public void setRapportType(RapportType rapportType) {
		this.rapportType = rapportType;
	}

	public double getRapportValue() {
		return rapportValue;
	}

	public void setRapportValue(double rapportValue) {
		this.rapportValue = rapportValue;
	}
	
	//</editor-fold>
	
}
