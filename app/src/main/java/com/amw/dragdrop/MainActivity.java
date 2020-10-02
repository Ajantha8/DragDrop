package com.amw.dragdrop;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DRAG_DROP";

    LinearLayoutCompat bottom;
    ImageView iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, cIV;
    int clicked, lastClicked, completed = 0;
    MediaPlayer player;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player = MediaPlayer.create(MainActivity.this, R.raw.drop);

        bottom = (LinearLayoutCompat) findViewById(R.id.bottom);

        iv1 = (ImageView) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);
        iv3 = (ImageView) findViewById(R.id.iv3);
        iv4 = (ImageView) findViewById(R.id.iv4);

        iv5 = (ImageView) findViewById(R.id.iv5);
        iv6 = (ImageView) findViewById(R.id.iv6);
        iv7 = (ImageView) findViewById(R.id.iv7);
        iv8 = (ImageView) findViewById(R.id.iv8);

        /*top.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                final int action = event.getAction();

                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        break;

                    case DragEvent.ACTION_DRAG_LOCATION:
                        break;

                    case DragEvent.ACTION_DROP: {
                        fail += 1;
                        return true;
                    }

                    case DragEvent.ACTION_DRAG_ENDED: {
                        total += 1;
                        int value = total - fail;
                        successTV.setText("Success : " + value);
                        totalTV.setText("Total   : " + total);
                        return true;
                    }

                    case DragEvent.ACTION_DRAG_ENTERED:
                        break;

                    case DragEvent.ACTION_DRAG_EXITED:
                        break;

                    default:
                        break;

                }

                return true;
            }

        });*/

        bottom.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                final int action = event.getAction();

                switch (action) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        Log.d(TAG, "ACTION_DRAG_STARTED");
                        break;

                    case DragEvent.ACTION_DRAG_LOCATION:
                        Log.d(TAG, "ACTION_DRAG_LOCATION");
                        break;

                    case DragEvent.ACTION_DROP: {
                        Log.d(TAG, "ACTION_DROP");
                        if (clicked != lastClicked) {
                            completed += 1;
                            switch (completed) {
                                case 1:
                                    iv5.setImageResource(clicked);
                                    break;
                                case 2:
                                    iv6.setImageResource(clicked);
                                    break;
                                case 3:
                                    iv7.setImageResource(clicked);
                                    break;
                                case 4:
                                    iv8.setImageResource(clicked);
                                    Toast.makeText(MainActivity.this, "Completed", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                            player.start();
                            lastClicked = clicked;
                            cIV.setVisibility(View.GONE);
                            return true;
                        } else {
                            return false;
                        }
                    }

                    case DragEvent.ACTION_DRAG_ENDED:
                        Log.d(TAG, "ACTION_DRAG_ENDED");
                        break;

                    case DragEvent.ACTION_DRAG_ENTERED:
                        Log.d(TAG, "ACTION_DRAG_ENTERED");
                        break;

                    case DragEvent.ACTION_DRAG_EXITED:
                        Log.d(TAG, "ACTION_DRAG_EXITED");
                        break;
                }

                return true;
            }

        });

        /*drag.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData clipData = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadow = new View.DragShadowBuilder(drag);
                v.startDragAndDrop(clipData, shadow, null, 0);
                return false;
            }
        });*/


        /*iv.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData clipData = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadow = new View.DragShadowBuilder(iv);
                v.startDragAndDrop(clipData, shadow, null, 0);
                clicked = R.drawable.as;
                return false;
            }
        });*/

        iv1.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                clicked = R.drawable.as;
                cIV = iv1;
                ClipData clipData = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadow = new View.DragShadowBuilder(iv1);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    v.startDragAndDrop(clipData, shadow, null, 0);
                } else {
                    v.startDrag(clipData, shadow, null, 0);
                }
                return false;
            }
        });

        iv2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                clicked = R.drawable.jc;
                cIV = iv2;
                ClipData clipData = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadow = new View.DragShadowBuilder(iv2);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    v.startDragAndDrop(clipData, shadow, null, 0);
                } else {
                    v.startDrag(clipData, shadow, null, 0);
                }
                return false;
            }
        });

        iv3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                clicked = R.drawable.qd;
                cIV = iv3;
                ClipData clipData = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadow = new View.DragShadowBuilder(iv3);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    v.startDragAndDrop(clipData, shadow, null, 0);
                } else {
                    v.startDrag(clipData, shadow, null, 0);
                }
                return false;
            }
        });

        iv4.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                clicked = R.drawable.kh;
                cIV = iv4;
                ClipData clipData = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadow = new View.DragShadowBuilder(iv4);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    v.startDragAndDrop(clipData, shadow, null, 0);
                } else {
                    v.startDrag(clipData, shadow, null, 0);
                }
                return false;
            }
        });

        startAnimations();
    }

    void startAnimations() {
        final Handler handler1 = new Handler(Looper.getMainLooper());
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation bottomDown = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bottom_down);
                iv1.startAnimation(bottomDown);
                iv1.setVisibility(View.VISIBLE);
                player.start();
            }
        }, 500);

        final Handler handler2 = new Handler(Looper.getMainLooper());
        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation bottomDown = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bottom_down);
                iv2.startAnimation(bottomDown);
                iv2.setVisibility(View.VISIBLE);
                player.start();
            }
        }, 1100);

        final Handler handler3 = new Handler(Looper.getMainLooper());
        handler3.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation bottomDown = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bottom_down);
                iv3.startAnimation(bottomDown);
                iv3.setVisibility(View.VISIBLE);
                player.start();
            }
        }, 1700);

        final Handler handler4 = new Handler(Looper.getMainLooper());
        handler4.postDelayed(new Runnable() {
            @Override
            public void run() {
                Animation bottomDown = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bottom_down);
                iv4.startAnimation(bottomDown);
                iv4.setVisibility(View.VISIBLE);
                player.start();
            }
        }, 2300);
    }

    @Override
    protected void onPause() {
        super.onPause();
        player.stop();
    }

    @Override
    protected void onStop() {
        super.onStop();
        player.stop();
    }
}
