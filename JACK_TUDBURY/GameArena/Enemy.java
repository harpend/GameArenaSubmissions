import java.util.Random;

public class Enemy {
    private String colour;
    private Rectangle body;
    private int lane;
    private int speed;
    private boolean end;
    private int score;
    private Random rand = new Random();
    public Enemy(String colour, int seed){
        rand.setSeed(seed);
        setColour(colour);
        int l = rand.nextInt(3);
        setLane(l);
        setSpeed(1);
        setEnd(false);
        setScore(0);
        switch (l) {
            case 0:
                setBody(270,-100, colour);
                setLane(l);
                break;
            case 1:
                setBody(450,-100, colour);
                setLane(l);
                break;
            case 2:
                setBody(630,-100, colour);
                setLane(l);
                break;
            default:
                break;
        }
    }
    public void addEnemy(GameArena a){
        a.addRectangle(this.body);
    }
    public void updateEnemy(GameArena a, int l1){
        
        a.removeRectangle(this.body);
        double x = this.body.getXPosition();
        double y = this.body.getYPosition();
        int s = getSpeed();
        int r = getScore();
        
        if (y<1000) {
            // System.out.println(l1+ "-" + this.getLane());
            if ((700>y && y>450) && collide(l1)){
                setEnd(true);
                a.clearGameArena();
                
                a.setBackgroundImage("YOU CRASHE.png");
                
                a.removeRectangle(body);
                String scoreString = "Score:"+ r;
                Text text = new Text(scoreString, 50, 400, 500, "white");
                a.addText(text);
            }
            if(!end){
                
                y = y +10 + s;
                this.body.setXPosition(x);
                this.body.setYPosition(y);
                a.addRectangle(this.body);
                
            }
        }
        
        else{           
            s = s + 3;
            setSpeed(s);
            y = -100;
            
            int l = rand.nextInt(3);
            switch (l) {
                case 0:
                    x = 270;
                    setLane(l);
                    break;
                case 1:
                    x = 450;
                    setLane(l);
                    break;
                case 2:
                    x = 630;
                    setLane(l);
                    break;
                default:
                    break;
                }
            if(!end){
                this.body.setXPosition(x);
                this.body.setYPosition(y);
                a.addRectangle(this.body);
                
                setScore( score+ 1);
                
            }
        }
    }
    public void setBody(int x, int y, String colour){
        this.body = new Rectangle(x, y, 100, 150, colour);
    }
    public boolean collide(int l1){
        if (l1 == this.lane){
            return true;
        }
        return false;
    }
    public void setColour(String colour){
        this.colour = colour;
    }
    public void setLane(int lane){
        this.lane = lane;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public void setEnd(boolean end){
        this.end = end;
    }
    public void setScore(int score){
        this.score = score;
    }
    public int getScore(){
        return this.score;
    }
    public boolean getEnd(){
        return this.end;
    }
    public int getSpeed(){
        return this.speed;
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
