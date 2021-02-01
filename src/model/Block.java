
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class Block {
    public static final int MAX = 7;
    private final Timer timer;
    private int x, y;
    private List<Observer> observers = new ArrayList<>();

    public Block(int x, int y) {
        this.x = x;
        this.y = y;
        this.timer = new Timer();
        this.timer.schedule(task(),1000,5000);
    }

    
    public void down() {
        if(this.y == 1) return;
        this.y--;
        changed();
    }

    public void right() {
        if(this.x == MAX) return;
        this.x++;
        changed();
    }

    public void left() {
        if(this.x == 1) return;
        this.x--;
        changed();
    }

    public void up() {
        if(this.y == MAX) return;
        this.y++;
        changed();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    private TimerTask task() {
        return new TimerTask() {
            @Override
            public void run() {
                double r = Math.random();
                if(r < 0.20) return;
                if(r >= 0.15) left();
                else if(r >= 0.10) right();
                else if(r >= 0.05) up();
                else down();
            }
        };
    }

    private void changed() {
        for (Observer observer : observers) {
            observer.changed();
        }
    }
    
    public void register(Observer o){
        observers.add(o);
    }
    
    public interface Observer{
        void changed();
    }
    
}
