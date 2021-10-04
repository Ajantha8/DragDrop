package com.amw.dragdrop

import android.annotation.SuppressLint
import android.content.ClipData
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.DragEvent
import android.view.View
import android.view.View.DragShadowBuilder
import android.view.View.OnDragListener
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "DRAG_DROP"
    }

    private var iv1: ImageView? = null
    private var iv2: ImageView? = null
    private var iv3: ImageView? = null
    private var iv4: ImageView? = null
    private var iv5: ImageView? = null
    private var iv6: ImageView? = null
    private var iv7: ImageView? = null
    private var iv8: ImageView? = null
    private var cIV: ImageView? = null
    private var clicked = 0
    private var lastClicked = 0
    private var completed = 0
    private var player: MediaPlayer? = null

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        player = MediaPlayer.create(this@MainActivity, R.raw.drop)
        val bottom = findViewById<View>(R.id.bottom) as LinearLayoutCompat

        iv1 = findViewById<View>(R.id.iv1) as ImageView
        iv2 = findViewById<View>(R.id.iv2) as ImageView
        iv3 = findViewById<View>(R.id.iv3) as ImageView
        iv4 = findViewById<View>(R.id.iv4) as ImageView
        iv5 = findViewById<View>(R.id.iv5) as ImageView
        iv6 = findViewById<View>(R.id.iv6) as ImageView
        iv7 = findViewById<View>(R.id.iv7) as ImageView
        iv8 = findViewById<View>(R.id.iv8) as ImageView

        bottom.setOnDragListener(OnDragListener { _, event ->
            when (event.action) {
                DragEvent.ACTION_DRAG_STARTED -> Log.d(TAG, "ACTION_DRAG_STARTED")
                DragEvent.ACTION_DRAG_LOCATION -> Log.d(TAG, "ACTION_DRAG_LOCATION")
                DragEvent.ACTION_DROP -> {
                    Log.d(TAG, "ACTION_DROP")
                    if (clicked != lastClicked) {
                        completed += 1
                        when (completed) {
                            1 -> iv5?.setImageResource(clicked)
                            2 -> iv6?.setImageResource(clicked)
                            3 -> iv7?.setImageResource(clicked)
                            4 -> {
                                iv8!!.setImageResource(clicked)
                                Toast.makeText(this@MainActivity, "Completed", Toast.LENGTH_SHORT).show()
                            }
                        }
                        player?.start()
                        lastClicked = clicked
                        cIV?.visibility = View.GONE
                        return@OnDragListener true
                    } else {
                        return@OnDragListener false
                    }
                }
                DragEvent.ACTION_DRAG_ENDED -> Log.d(TAG, "ACTION_DRAG_ENDED")
                DragEvent.ACTION_DRAG_ENTERED -> Log.d(TAG, "ACTION_DRAG_ENTERED")
                DragEvent.ACTION_DRAG_EXITED -> Log.d(TAG, "ACTION_DRAG_EXITED")
            }
            true
        })

        iv1?.setOnTouchListener { v, _ ->
            clicked = R.drawable.`as`
            cIV = iv1
            val clipData = ClipData.newPlainText("", "")
            val shadow = DragShadowBuilder(iv1)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                v.startDragAndDrop(clipData, shadow, null, 0)
            } else {
                v.startDrag(clipData, shadow, null, 0)
            }
            false
        }

        iv2?.setOnTouchListener { v, _ ->
            clicked = R.drawable.jc
            cIV = iv2
            val clipData = ClipData.newPlainText("", "")
            val shadow = DragShadowBuilder(iv2)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                v.startDragAndDrop(clipData, shadow, null, 0)
            } else {
                v.startDrag(clipData, shadow, null, 0)
            }
            false
        }
        iv3?.setOnTouchListener { v, _ ->
            clicked = R.drawable.qd
            cIV = iv3
            val clipData = ClipData.newPlainText("", "")
            val shadow = DragShadowBuilder(iv3)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                v.startDragAndDrop(clipData, shadow, null, 0)
            } else {
                v.startDrag(clipData, shadow, null, 0)
            }
            false
        }
        iv4?.setOnTouchListener { v, _ ->
            clicked = R.drawable.kh
            cIV = iv4
            val clipData = ClipData.newPlainText("", "")
            val shadow = DragShadowBuilder(iv4)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                v.startDragAndDrop(clipData, shadow, null, 0)
            } else {
                v.startDrag(clipData, shadow, null, 0)
            }
            false
        }
        startAnimations()
    }

    private fun startAnimations() {
        val handler1 = Handler(Looper.getMainLooper())
        handler1.postDelayed({
            val bottomDown = AnimationUtils.loadAnimation(this@MainActivity, R.anim.bottom_down)
            iv1?.startAnimation(bottomDown)
            iv1?.visibility = View.VISIBLE
            player?.start()
        }, 500)
        val handler2 = Handler(Looper.getMainLooper())
        handler2.postDelayed({
            val bottomDown = AnimationUtils.loadAnimation(this@MainActivity, R.anim.bottom_down)
            iv2?.startAnimation(bottomDown)
            iv2?.visibility = View.VISIBLE
            player?.start()
        }, 1100)
        val handler3 = Handler(Looper.getMainLooper())
        handler3.postDelayed({
            val bottomDown = AnimationUtils.loadAnimation(this@MainActivity, R.anim.bottom_down)
            iv3?.startAnimation(bottomDown)
            iv3?.visibility = View.VISIBLE
            player?.start()
        }, 1700)
        val handler4 = Handler(Looper.getMainLooper())
        handler4.postDelayed({
            val bottomDown = AnimationUtils.loadAnimation(this@MainActivity, R.anim.bottom_down)
            iv4?.startAnimation(bottomDown)
            iv4?.visibility = View.VISIBLE
            player?.start()
        }, 2300)
    }

    override fun onPause() {
        super.onPause()
        player?.stop()
    }

    override fun onStop() {
        super.onStop()
        player?.stop()
    }
}