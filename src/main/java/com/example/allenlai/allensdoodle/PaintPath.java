package com.example.allenlai.allensdoodle;

import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by allenlai on 11/6/16.
 */

public class PaintPath {

    public Path path;
    public Paint paint;

    public PaintPath(Path path, Paint paint){
        super();
        path = path;
        paint = paint;
    }

    public Paint getPaint(){
        return paint;
    }



}
