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
public class PaintPot {
	
	private double volume;
	private double withdrawal;

	public PaintPot(double volume, double withdrawal) {
		this.volume = volume;
		this.withdrawal = withdrawal;
	}
	
	// Volume of paint for desired area
	public double calcPaintAmount(double area) {
		return calcPaintAmount(area, 1);
	}
	public double calcPaintAmount(double area, int layers) {
		return area * layers * withdrawal;
	}

	// Amount of pots for desired room
	public int calcPotAmount(Room room) {
		return calcPotAmount(room, 1);
	}
	public int calcPotAmount(Room room, int layers) {
		return (int)Math.ceil(calcPaintAmount(room.calcUnusedWallArea(), layers) / volume);
	}

	//<editor-fold defaultstate="collapsed" desc="Getters & Setters">
		
	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getWithdrawal() {
		return withdrawal;
	}

	public void setWithdrawal(double withdrawal) {
		this.withdrawal = withdrawal;
	}
	
	//</editor-fold>
	
}
