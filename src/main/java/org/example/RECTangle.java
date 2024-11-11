package org.example;

public class RECTangle {

    private double x;
    private double y;
    private double width;
    private double height;

    public RECTangle(double x, double y, double xSize, double ySize) {
        this.x = x;
        this.y = y;
        this.width = xSize;
        this.height = ySize;
    }

    public boolean intersects(RECTangle other) {
        // Проверка, лежит ли хотя бы одна точка первого прямоугольника внутри второго
        boolean pointInOther = (this.x >= other.x && this.x <= other.x + other.width &&
                this.y >= other.y && this.y <= other.y + other.height) ||
                (this.x + this.width >= other.x && this.x + this.width <= other.x + other.width &&
                        this.y >= other.y && this.y <= other.y + other.height) ||
                (this.x >= other.x && this.x <= other.x + other.width &&
                        this.y + this.height >= other.y && this.y + this.height <= other.y + other.height) ||
                (this.x + this.width >= other.x && this.x + this.width <= other.x + other.width &&
                        this.y + this.height >= other.y && this.y + this.height <= other.y + other.height);

        // Проверка, лежит ли хотя бы одна точка второго прямоугольника внутри первого
        boolean otherPointInThis = (other.x >= this.x && other.x <= this.x + this.width &&
                other.y >= this.y && other.y <= this.y + this.height) ||
                (other.x + other.width >= this.x && other.x + other.width <= this.x + this.width &&
                        other.y >= this.y && other.y <= this.y + this.height) ||
                (other.x >= this.x && other.x <= this.x + this.width &&
                        other.y + other.height >= this.y && other.y + other.height <= this.y + this.height) ||
                (other.x + other.width >= this.x && other.x + other.width <= this.x + this.width &&
                        other.y + other.height >= this.y && other.y + other.height <= this.y + this.height);

        return pointInOther || otherPointInThis;
    }
}

/* public boolean intersects(RECTangle other) {
    return this.x <= other.x + other.width &&
           this.x + this.width >= other.x &&
           this.y <= other.y + other.height &&
           this.y + this.height >= other.y;
}*/



