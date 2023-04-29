package jdbc;

import java.io.Serializable;

public class JavaBean implements Serializable {
private int width;
private int height;
public int getWidth() {
	return width;
}
public void setWidth(int width) {
	if(width>1920)
		this.width=1920;
	else if(width<10)
		this.width=10;
	else
	this.width = width;
}
public int getHeight() {
	return height;
}
public void setHeight(int height) {
	if(height>1080)
		this.height=1080;
	else if(height<10)
		this.height=10;
	else
	this.height = height;
}

}
