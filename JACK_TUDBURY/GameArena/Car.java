public class Car {
    // private int speed; /*speed is not implemented yet */
    private String colour;
    private Rectangle body;
    private int lane;

    public Car(String colour){
        setBody(450,600, colour);
        setColour(colour);
        setLane(1);
    }

    public void addCar(GameArena a){
        a.addRectangle(this.body);
    }
    private void updateCar(GameArena a, boolean dir){
        a.removeRectangle(this.body);
        double x = this.body.getXPosition();
        double y = this.body.getYPosition();
        if(dir){
            x = x+180;
        }
        else{
            x = x-180;
        }
        this.body.setXPosition(x);
        this.body.setYPosition(y);
        a.addRectangle(this.body);
    }
    public void move(GameArena a,boolean dir){
        if (dir) {
            switch (getLane()) {
                case 0:
                    setLane(1);
                    updateCar(a, dir);
                    break;
                case 1:
                    setLane(2);
                    updateCar(a, dir);
                    break;
                default:
                    break;
            }
        }
        else{
            switch (getLane()) {
                case 1:
                    setLane(0);
                    updateCar(a, dir);
                    break;
                case 2:
                    setLane(1);
                    updateCar(a, dir);
                    break;
                default:
                    break;
            }
        }
    }

    public void setBody(int x, int y, String colour){
        this.body = new Rectangle(x, y, 100, 150, colour);
    }
    public void setColour(String colour){
        this.colour = colour;
    }
    public void setLane(int lane){
        this.lane = lane;
    }

    public Rectangle getBody(){
        return this.body;
    }
    public String getColour(){
        return this.colour;
    }
    public int getLane(){
        return this.lane;
    }
}
