package com.test.seikenkiyosu.likemario;

import java.util.Random;

public class Ball {

    //position
    float x,y;

    //velocity
    float dx,dy;

    //color
    int r,g,b;

    public Ball(int width, int height) {
        if(width < height) {
            this.x = width / 8;
            this.y = height * (float) (9.0 / 10.0);
        }
        else {
            this.x = 200;
            this.y = 100;
//            this.x = width * (float) (9.0 / 10.0);
//            this.y = height / 8;
        }

        this.dx = 10;
        this.dy = 0;

        //紅梅色
        this.r = 38;
        this.g = 38;
        this.b = 38;

    }
}
