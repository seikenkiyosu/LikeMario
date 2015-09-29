package com.test.seikenkiyosu.likemario;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class MarioView extends View implements GestureDetector.OnGestureListener{
    protected static final int CharacterSize = 50;

    Ball ball;
    Paint p = new Paint();
    int mobilesizex, mobilesizey;
    public MarioView(Context cn, int msx, int msy) {
        super(cn);
        mobilesizex = msx; mobilesizey = msy;
        ball = new Ball(mobilesizex, mobilesizey);
    }

    /* 描画するときの処理 */
    protected void onDraw(Canvas cs) {
        super.onDraw(cs);
        p.setColor(Color.rgb(ball.r, ball.g, ball.b));
        p.setStyle(Paint.Style.FILL);
        cs.drawCircle(ball.x, ball.y, CharacterSize, p); //10は大きさ
    }

//    /* タッチしたときの処理 */
//    public boolean onTouchEvent(MotionEvent e) {
////        if (e.getAction() == MotionEvent.ACTION_UP) {
//            ball.x += ball.dx;
////            this.invalidate();  //再描画(onDrawを再度呼び出す)
////        }
////        //右半分タッチしたとき
////        while(e.() < mobilesizex/2){
////            ball.x -= ball.dx;
////            this.invalidate();  //再描画(onDrawを再度呼び出す)
////        }
////        //左半分タッチしたとき
////        while(e.getX() > mobilesizex/2){
////            ball.x += ball.dx;
////            this.invalidate();  //再描画(onDrawを再度呼び出す)
////        }
//        this.invalidate();  //再描画(onDrawを再度呼び出す)
//        return true;
//    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        ball.x += ball.dx;
        this.invalidate();  //再描画(onDrawを再度呼び出す)
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}
