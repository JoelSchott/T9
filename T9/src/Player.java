import java.awt.Color;

public class Player {
    private Color color;
    private String colorName;
    private boolean leftBig = true;
    private boolean leftMedium = true;
    private boolean leftSmall = true;
    private boolean centerBig = true;
    private boolean centerMedium = true;
    private boolean centerSmall = true;
    private boolean rightBig = true;
    private boolean rightMedium = true;
    private boolean rightSmall = true;
    private Selection selected = Selection.NONE;

    public Player(Color color, String colorName){
        this.color = color;
        this.colorName = colorName;
    }

    public boolean canSelect(Selection selection){
        return switch (selection) {
            case LEFT_BIG -> leftBig;
            case LEFT_MEDIUM -> leftMedium;
            case LEFT_SMALL -> leftSmall;
            case CENTER_BIG -> centerBig;
            case CENTER_MEDIUM -> centerMedium;
            case CENTER_SMALL -> centerSmall;
            case RIGHT_BIG -> rightBig;
            case RIGHT_MEDIUM -> rightMedium;
            case RIGHT_SMALL -> rightSmall;
            case NONE -> true;
        };
    }

    public void select(Selection selection) {
        if (canSelect(selection)){
            selected = selection;
        }
    }

    public Selection getSelection(){
        return selected;
    }

    public Size getSelectionSize(){
        return switch (selected) {
            case LEFT_BIG, CENTER_BIG, RIGHT_BIG -> Size.BIG;
            case LEFT_MEDIUM, RIGHT_MEDIUM, CENTER_MEDIUM, NONE -> Size.MEDIUM;
            case LEFT_SMALL, CENTER_SMALL, RIGHT_SMALL -> Size.SMALL;
        };
    }

    public void place() {
        switch (selected) {
            case LEFT_BIG:
                leftBig = false;
                break;
            case LEFT_MEDIUM:
                leftMedium = false;
                break;
            case LEFT_SMALL:
                leftSmall = false;
                break;
            case CENTER_BIG:
                centerBig = false;
                break;
            case CENTER_MEDIUM:
                centerMedium = false;
                break;
            case CENTER_SMALL:
                centerSmall = false;
                break;
            case RIGHT_BIG:
                rightBig = false;
                break;
            case RIGHT_MEDIUM:
                rightMedium = false;
                break;
            case RIGHT_SMALL:
                rightSmall = false;
                break;
        }
        selected = Selection.NONE;
    }

    public Color getColor(){
        return color;
    }

    public String getColorName(){
        return colorName;
    }
}
