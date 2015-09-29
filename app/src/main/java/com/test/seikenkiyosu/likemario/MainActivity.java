package com.test.seikenkiyosu.likemario;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;


public class MainActivity extends Activity implements Runnable {

    MarioView mv;
    Handler hn; //再描画するためのインスタンス
    LinearLayout ll;   //レイアウト

    /* アプリ起動時に実行 */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //タイトルを消す
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //レイアウト初期化
        ll = new LinearLayout(this);
        setContentView(ll);

        //携帯の大きさを取得するための処理
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display dp = wm.getDefaultDisplay();
        Point point = new Point();
        dp.getSize(point);

        hn = new Handler();
        hn.postDelayed(this, 1);    //run を呼び出す

        //レイアウトにView を追加
        mv = new MarioView(this, point.x, point.y);


        ll.addView(mv);
    }

    /* postDelayed によって実行 */
    public void run() {
        mv.invalidate();  //再描画

        hn.postDelayed(this, 1);   //繰り返しrun の呼び出し(右の数字は間隔)
    }

    /* アプリ終了時に実行 */
    public void onDestroy() {
        super.onDestroy();
        hn.removeCallbacks(this);
    }
}