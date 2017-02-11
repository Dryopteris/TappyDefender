package com.mark.tappydefender;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by Mark on 2/5/2017.
 */
public class PlayerShip {

    private final int GRAVITY = -12;
    private final int MIN_SPEED = 1;
    private final int MAX_SPEED = 20;

    private int maxY;
    private int minY;

    private Bitmap bitmap;
    private int x, y;
    private int speed = 0;
    private boolean boosting;

    public PlayerShip (Context context, int screenX, int screenY) {
        int x = 50;
        int y = 50;
        speed = 1;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ship);
        boosting = false;
        minY = 0;
        maxY = screenY - bitmap.getHeight();
    }

    public void update() {
        if(boosting) {
            speed += 2;
        } else {
            speed -= 5;
        }

        if (speed > MAX_SPEED) {
            speed = MAX_SPEED;
        }

        if (speed < MIN_SPEED) {
            speed = MIN_SPEED;
        }

        y -= speed + GRAVITY;

        if (y > maxY) {
            y = maxY;
        }

        if (y < minY) {
            y = minY;
        }
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public int getSpeed() {
        return speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setBoosting() {
        boosting = true;
    }

    public void stopBoosting() {
        boosting = false;
    }
}
