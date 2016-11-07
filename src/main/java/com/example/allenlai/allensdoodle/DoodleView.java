package com.example.allenlai.allensdoodle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by allenlai on 11/2/16.
 */

public class DoodleView extends View {

    public Paint paintDoodler = new Paint();
    public Path path = new Path();
    public ArrayList<Path> allPaths = new ArrayList<Path>();
    public ArrayList<Paint> allPaints = new ArrayList<Paint>();

    public DoodleView(Context context) {
        super(context);
        init(null, 0);
    }

    public DoodleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public DoodleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    private void init(AttributeSet attrs, int defStyle) {
        this.setBackgroundColor(Color.WHITE);
        paintDoodler.setARGB(255, 0, 0, 0);
        paintDoodler.setAntiAlias(true);
        paintDoodler.setStyle(Paint.Style.STROKE);
        paintDoodler.setStrokeWidth(8);
        allPaths.add(path);
        allPaints.add(paintDoodler);
    }

    private void setPaint(float size, int opacity, int red, int green, int blue) {
        paintDoodler.setARGB(opacity, red, green, blue);
        paintDoodler.setAntiAlias(true);
        paintDoodler.setStyle(Paint.Style.STROKE);
        paintDoodler.setStrokeWidth(size);
    }
    private void setPaint(float size, int opacity, int color) {
        paintDoodler.setColor(color);
        paintDoodler.setAntiAlias(true);
        paintDoodler.setStyle(Paint.Style.STROKE);
        paintDoodler.setStrokeWidth(size);
        paintDoodler.setAlpha(opacity);
    }


    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(int i = 0; i < allPaths.size(); i++) {
            canvas.drawPath(allPaths.get(i), allPaints.get(i));
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float touchX = motionEvent.getX();
        float touchY = motionEvent.getY();
        switch(motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                path = new Path();
                allPaths.add(path);
                allPaints.add(paintDoodler);
                path.moveTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        invalidate();
        return true;
    }


    public void setColor(int red, int green, int blue) {
        float oldSize = paintDoodler.getStrokeWidth();
        int oldOpacity = paintDoodler.getAlpha();
        paintDoodler = new Paint();
        path = new Path();
        setPaint(oldSize, oldOpacity, red, green, blue);
        allPaths.add(path);
        allPaints.add(paintDoodler);
    }

    public void setPaintOpacity(int alpha) {
        float oldSize = paintDoodler.getStrokeWidth();
        int oldColor = paintDoodler.getColor();
        paintDoodler = new Paint();
        path = new Path();
        setPaint(oldSize, alpha, oldColor);
        allPaths.add(path);
        allPaints.add(paintDoodler);
    }

    public void setBrushSize(int size) {
        int oldColor = paintDoodler.getColor();
        int oldOpacity = paintDoodler.getAlpha();
        paintDoodler = new Paint();
        path = new Path();
        setPaint(size, oldOpacity, oldColor);
        allPaths.add(path);
        allPaints.add(paintDoodler);
    }
    public void clearCanvas() {
        for(Path path : allPaths) {
            path.reset();
        }
        invalidate();
        allPaths.clear();
        allPaints.clear();
        path = new Path();
        allPaths.add(path);
        allPaints.add(paintDoodler);
    }

    public void undo() {
        if (!allPaths.isEmpty()) {
            allPaths.remove(allPaths.size()-1);
            allPaints.remove(allPaints.size()-1);
            invalidate();
        }
    }

}





