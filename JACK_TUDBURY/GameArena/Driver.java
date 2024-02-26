import java.lang.Thread;
public class Driver {
    public static void main(String[] args) {
        GameArena arena = new GameArena(1000, 800);
        arena.setBackgroundImage("roadBG.png");
        Car c = new Car("blue");
        Enemy enemy = new Enemy("red", 1);
        Enemy enemy2 = new Enemy("red", 2);
        c.addCar(arena);
        enemy.addEnemy(arena);
        enemy2.addEnemy(arena);
        
        // c.move(arena, true);
        while (true) {
            if (arena.leftPressed()) {
                c.move(arena, false);
                // System.out.println("left");
            }
            else if(arena.rightPressed()){
                c.move(arena, true);
                // System.out.println("right");
            }
            else{
                // System.out.println("hekp");
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            int l1 = c.getLane();
            enemy2.updateEnemy(arena, l1);
            enemy.updateEnemy(arena, l1);
        }
    }
}
