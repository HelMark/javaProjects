package javaSyntax;

import java.lang.Math;

public class Rectangle {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    //Tostring, min/max, width, height
    @Override
    public String toString() {
        return  "Rectangle: (" + x1  + "," + y1 + ").(" + x2 + "," + y2 + ")";
    }
    public int getMinX(){
        return Math.min(this.x1, this.x2);
    }
    public int getMinY(){
        return Math.min(this.y1, this.y2);
    }
    public int getMaxX(){
        return Math.max(this.x1, this.x2);
    }
    public int getMaxY(){
        return Math.max(this.y1, this.y2);
    }
    public int getWidth(){
        return Math.abs(this.x2 - this.x1);
    }
    public int getHeight(){
        return Math.abs(this.y2 - this.y1);
    }
    
    //isEmpty check
    public boolean isEmpty(){
        if((x1 == x2) || (y1 == y2)){
            return true;
        }else{
            return false;
        }
    }

    //contains integers
    public boolean contains(int x, int y){
        int minX = Math.min(this.x1, this.x2), minY = Math.min(this.y1, y2);
        int maxX = Math.max(this.x1, this.x2), maxY = Math.max(this.y1, this.y2);

        if (isEmpty()){
            return false;
        } else if(minX <= x && maxX >= x && minY <= y && maxY >= y){
            return true;
        } else{
            return false;
        }
    }

    //add integers
    public boolean add(int x, int y){
        int minX = Math.min(this.x1, this.x2), minY = Math.min(this.y1, y2);
        int maxX = Math.max(this.x1, this.x2), maxY = Math.max(this.y1, this.y2);

        if (maxX < x && minY > y){
            if (x1 == maxX && y1 == minY){
                x1 = x;
                y1 = y;
            } else{
                x2 = x;
                y2 = y;
            }
            return true;
        } else if (minX > x && maxY < y){
            if (x1 == maxX && y1 == minY){
                x2 = x;
                y2 = y;
            } else{
                x1 = x;
                x2 = y;
            }
            return true;
        } else if (maxX < x && maxY < y){
            if (x1 == maxX && y1 == minY){
                x1 = x;
                y2 = y;
            } else{
                x2 = x;
                y1 = y;
            }
            return true;
        } else if (minX > x && minY > y){
            if (x1 == maxX && y1 == minY){
                x2 = x;
                y1 = y;
            } else{
                x1 = x;
                y2 = y;
            }
            return true;
        }else{
            return false;
        }
    }

    //contains rectangel
    public boolean contains(Rectangle rect){
        int x2_rect = rect.getMaxX();
        int x1_rect = rect.getMinX();
        int y1_rect = rect.getMaxY(); 
        int y2_rect = rect.getMinY();

        if (x1_rect >= this.x1 && y1_rect <= this.y1 && x2_rect <= this.x2 && y2_rect >= this.y2){
            return true;
        } else{
            return false;
        }
    }

    //add rectangel
    public boolean add(Rectangle rect){
        if (rect.isEmpty()){
            return false;
        } else if (contains(rect)){
            return false;
        } else{
            int x1_rect = rect.getMinX();
            int y1_rect = rect.getMinY(); 
            int x2_rect = rect.getMaxX();
            int y2_rect = rect.getMaxY();
            
            int minX = Math.min(this.x1, this.x2), minY = Math.min(this.y1, y2);
            int maxX = Math.max(this.x1, this.x2), maxY = Math.max(this.y1, this.y2);
    

            if (x2_rect > maxX || y2_rect < minY){
                add(x2_rect, y2_rect);
            } else if (x1_rect < minX || y1_rect > maxY){
                add(x1_rect, y1_rect);
            } else if (x1_rect == minX && x2_rect == maxX && y1_rect == minY && y2_rect == maxY) {
                return false;
            }
            return true;
        }
    }
    
    //union of rectangels
    public Rectangle union(Rectangle rect){
            int x1_rect = rect.getMinX();
            int y1_rect = rect.getMinY(); 
            int x2_rect = rect.getMaxX();
            int y2_rect = rect.getMaxY();

            int minX = Math.min(this.x1, this.x2), minY = Math.min(this.y1, y2);
            int maxX = Math.max(this.x1, this.x2), maxY = Math.max(this.y1, this.y2);

            int maxX_of_the_rectangels = Math.max(x2_rect, maxX);
            int maxY_of_the_rectangles = Math.max(y2_rect, maxY);
            int minX_of_the_rectangels = Math.min(x1_rect, minX);
            int minY_of_the_rectangels = Math.min(y1_rect, minY);

            int x1_newRect = minX_of_the_rectangels;
            int y1_newRect = maxY_of_the_rectangles;
            int x2_newRect = maxX_of_the_rectangels;
            int y2_newRect = minY_of_the_rectangels;

       return new Rectangle(x1_newRect, y1_newRect, x2_newRect, y2_newRect);
    }

    //intersection of rectangels
    public Rectangle intersection(Rectangle rect){
        if(intersects(rect)) {
        int x1_rect = rect.getMinX();
        int y1_rect = rect.getMinY();

        int minX = Math.min(this.x1, this.x2), minY = Math.min(this.y1, y2);
        int maxX = Math.max(this.x1, this.x2), maxY = Math.max(this.y1, this.y2);

        int maxX_of_the_mins = Math.max(x1_rect, minX);
        int maxY_of_the_mins = Math.max(y1_rect, minY);

        int x1_newRect = maxX_of_the_mins;
        int y1_newRect = maxY;
        int x2_newRect = maxX;
        int y2_newRect = maxY_of_the_mins;

        return new Rectangle(x1_newRect, y1_newRect, x2_newRect, y2_newRect);
        } 
        return null;
    }
    public boolean intersects(Rectangle rect) {
        int x1_rect = rect.getMinX();
        int y1_rect = rect.getMaxY(); 
        int x2_rect = rect.getMaxX();
        int y2_rect = rect.getMinY();

        int minX = Math.min(this.x1, this.x2), minY = Math.min(this.y1, y2);
        int maxX = Math.max(this.x1, this.x2), maxY = Math.max(this.y1, this.y2);

        if (x1_rect < minX && y1_rect > maxY && x2_rect > maxX && y2_rect < minY || x1_rect > minX && y1_rect < maxY && x2_rect < maxX && y2_rect > minY){
            return true;
        } else if (minX < x1_rect && x1_rect < maxX && y1_rect > minY && y2_rect < maxY){
            return true;
        } else if (minX < x2_rect && x2_rect < maxX && y1_rect > minY && y2_rect < maxY) {
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(0, 0, 5, 5);
        Rectangle rect2 = new Rectangle(3, 3, 7, 7);

        Rectangle intersection = rect1.intersection(rect2);
        System.out.println(intersection);
    }
}