/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foladesoft.room_walls_renovation.material;

import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import org.foladesoft.room_walls_renovation.room.Door;
import org.foladesoft.room_walls_renovation.room.Room;
import org.foladesoft.room_walls_renovation.room.Window;

/**
 *
 * @author Vladislav
 */
public class Tile {
	
	private double width;
	private double height;

	public Tile(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public double calcArea() {
		return width * height;
	}
	
	// Amount of tiles that cover the whole area
	public int calcPavingTiles(double areaWidth, double areaHeight) {
		int hor = (int)Math.ceil(areaWidth / width);
		int ver = (int)Math.ceil(areaHeight / height);
		return hor * ver;
	}
	
	// Amount of tiles that do not exceed area borders
	public int calcFittingTiles(double areaWidth, double areaHeight) {
		int hor = (int)Math.floor(areaWidth / width);
		int ver = (int)Math.floor(areaHeight / height);
		return hor * ver;
	}
	
	public int calcTilesAmount(Room room) {
		int totalTiles = calcPavingTiles(room.calcPerimeter(), room.getHeight());
		int doorTiles = room.getDoors().stream().collect(
				Collectors.summingInt(
						(Door d) -> calcFittingTiles(d.getWidth(), d.getHeight())));
		int windowTiles = room.getWindows().stream().collect(
				Collectors.summingInt(
						(Window w) -> calcFittingTiles(w.getWidth(), w.getHeight())));
		return totalTiles - (windowTiles + doorTiles);
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
