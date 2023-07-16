package designpattern.factory;

import org.w3c.dom.css.Rect;

public class ShapeFactory {

    Shape getShape(String input){
        switch (input) {
            case "CIRCLE" :
                return new Circle();
            case "RECTANGLE" :
                return new Rectangle();
            default :
                return null;
        }
    }
}
