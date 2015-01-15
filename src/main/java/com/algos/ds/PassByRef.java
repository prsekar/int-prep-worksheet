package com.algos.ds;

public class PassByRef {

	public static void change(Point p11, Point p21) {
		p11.x = 15; p11.y = 15;
		Point tmp = p21;
		tmp.x = 25; tmp.y=25;

	}
	public static void swap (Point p11, Point p21 ) {
		Point tmp = p11;
		p11 = p21;
		p21 = tmp;
				
	}
	
	public static void swap(int x, int y) {
		int tmp = y;
		y = x;
		x = tmp;
	}
	public static void main(String[] args) {
		Point p1 = new Point(); p1.x = 10; p1.y = 10;
		Point p2 = new Point(); p2.x = 20; p2.y = 20;
		System.out.println(p1.x+ " "+ p1.y + "  " + p2.x + " " +p2.y);
		change(p1, p2);
		System.out.println(p1.x+ " "+ p1.y + "  " + p2.x + " " +p2.y);
		swap(p1, p2);
		System.out.println(p1.x+ " "+ p1.y + "  " + p2.x + " " +p2.y);
		int x =10, y = 20;
		swap(x,y);
		System.out.println(x +"   "+ y);
	}
}

class Point {
	public int x;
	public int y;

}
