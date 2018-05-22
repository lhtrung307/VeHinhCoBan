package kythuatdohoa;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import kythuatdohoa.Point;

public class DuongTron {
	private BufferedImage image;
	private Point tam = new Point();
	private int R;
	public ArrayList<Point> points;

	public DuongTron(BufferedImage image, Point tam, int r) {
		this.image = image;
		this.tam = tam;
		R = r;
		points = new ArrayList<>();
	}

	public void Doixung(Point tam, int x, int y) {
		Point D;

		D = new Point(tam.getX() + x, tam.getY() + y);
		if (D.getX() > 0 && D.getX() < 640 && D.getY() > 0 && D.getY() < 480) {
			points.add(D);
			Main.drawPoint(D, image);
		}

		D = new Point(tam.getX() - x, tam.getY() + y);
		if (D.getX() > 0 && D.getX() < 640 && D.getY() > 0 && D.getY() < 480) {
			points.add(D);
			Main.drawPoint(D, image);
		}
		D = new Point(tam.getX() + x, tam.getY() - y);
		if (D.getX() > 0 && D.getX() < 640 && D.getY() > 0 && D.getY() < 480) {
			points.add(D);
			Main.drawPoint(D, image);
		}
		D = new Point(tam.getX() - x, tam.getY() - y);
		if (D.getX() > 0 && D.getX() < 640 && D.getY() > 0 && D.getY() < 480) {
			points.add(D);
			Main.drawPoint(D, image);
		}
		D = new Point(tam.getX() + y, tam.getY() + x);
		if (D.getX() > 0 && D.getX() < 640 && D.getY() > 0 && D.getY() < 480) {
			points.add(D);
			Main.drawPoint(D, image);
		}
		D = new Point(tam.getX() - y, tam.getY() + x);
		if (D.getX() > 0 && D.getX() < 640 && D.getY() > 0 && D.getY() < 480) {
			points.add(D);
			Main.drawPoint(D, image);
		}
		D = new Point(tam.getX() + y, tam.getY() - x);
		if (D.getX() > 0 && D.getX() < 640 && D.getY() > 0 && D.getY() < 480) {
			points.add(D);
			Main.drawPoint(D, image);
		}
		D = new Point(tam.getX() - y, tam.getY() - x);
		if (D.getX() > 0 && D.getX() < 640 && D.getY() > 0 && D.getY() < 480) {
			points.add(D);
			Main.drawPoint(D, image);
		}

	}

	public void duongtronMid() {
		int x, y, d;
		x = 0;
		y = R;
		d = 1 - R;
		while (x <= y) {
			Doixung(tam, x, y);
			if (d < 0)
				d += 2 * x + 3;
			else {
				d += 2 * (x - y) + 5;
				y = y - 1;
			}
			x = x + 1;
		}
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public ArrayList<Point> getPoints() {
		return points;
	}

	public void doiXung(Point p) {
		int trx1, try1;
		trx1 = (tam.getX() - p.getX());
		try1 = (tam.getY() - p.getY());

		p.setX(p.getX() - trx1);
		p.setY(p.getY() - try1);

		DuongTron dt = new DuongTron(image, p, R);
		dt.duongtronMid();
	}

}
