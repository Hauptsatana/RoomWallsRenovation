/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foladesoft.room_walls_renovation;

import java.util.ArrayList;
import java.util.List;
import org.foladesoft.room_walls_renovation.room.Door;
import org.foladesoft.room_walls_renovation.room.Room;
import org.foladesoft.room_walls_renovation.room.Window;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Vladislav
 */
public class RoomTest {
	
	//<editor-fold defaultstate="collapsed" desc="Exceptions">
		
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionLength() {
		Room room = new Room(-10, 10, 2, null, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionWidth() {
		Room room = new Room(10, -10, 2, null, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionHeihgt() {
		Room room = new Room(10, 10, 0, null, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionDoorsNull() {
		Room room = new Room(10, 10, 2, null, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionDoorsExceed() {
		List<Door> doors = new ArrayList<>();
		doors.add(new Door(12, 2));
		Room room = new Room(10, 10, 2, null, null);
	}
	
	//</editor-fold>

	//<editor-fold defaultstate="collapsed" desc="Perimeter & Area">
	
	@Test
	public void testPerimeter() {
		List<Door> doors = new ArrayList<>();
		doors.add(new Door(2, 2));
		Room room = new Room(10, 4, 2.8, doors, null);
		Assert.assertTrue(Math.abs(room.calcPerimeter() - 28) < 1e-6);
	}
	
	@Test
	public void testTotalWallArea() {
		List<Door> doors = new ArrayList<>();
		doors.add(new Door(2, 2));
		Room room = new Room(10, 4, 2.8, doors, null);
		Assert.assertTrue(Math.abs(room.calcTotalWallArea() - 28 * 2.8) < 1e-6);
	}
	
	@Test
	public void testDoorArea() {
		List<Door> doors = new ArrayList<>();
		doors.add(new Door(2, 1.5));
		doors.add(new Door(0.5, 0.7));
		Room room = new Room(10, 4, 2.8, doors, null);
		Assert.assertTrue(Math.abs(room.calcDoorArea() - 3.35) < 1e-6);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionWindow() {
		List<Window> windows = new ArrayList<>();
		windows.add(new Window(10, 0));
	}
	
	@Test
	public void testWindowArea() {
		List<Door> doors = new ArrayList<>();
		doors.add(new Door(2, 1.5));
		List<Window> windows = new ArrayList<>();
		windows.add(new Window(3, 1.9));
		windows.add(new Window(2, 1.7));
		
		Room room = new Room(10, 4, 2.8, doors, windows);
		Assert.assertTrue(Math.abs(room.calcWindowArea() - 9.1) < 1e-6);
	}
	
	@Test
	public void testUnusedArea() {
		List<Door> doors = new ArrayList<>();
		doors.add(new Door(2, 1.5));
		doors.add(new Door(0.5, 0.7));
		List<Window> windows = new ArrayList<>();
		windows.add(new Window(3, 1.9));
		windows.add(new Window(2, 1.7));
		
		Room room = new Room(10, 4, 2.8, doors, windows);
		Assert.assertTrue(Math.abs(room.calcUnusedWallArea() - (28 * 2.8 - 9.1 - 3.35)) < 1e-6);
	}
	
	//</editor-fold>
	
}
