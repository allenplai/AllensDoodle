package com.example.allenlai.allensdoodle;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBarRed;
    private SeekBar seekBarGreen;
    private SeekBar seekBarBlue;
    private SeekBar seekBarOpacity;
    private SeekBar seekBarBrushSize;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarRed = (SeekBar) findViewById(R.id.redSlider);
        seekBarGreen = (SeekBar) findViewById(R.id.greenSlider);
        seekBarBlue = (SeekBar) findViewById(R.id.blueSlider);

        seekBarBrushSize = (SeekBar) findViewById(R.id.brushSizeSlider);
        seekBarOpacity = (SeekBar) findViewById(R.id.opacitySlider);

        // set the defaults
        seekBarRed.setProgress(0);
        seekBarGreen.setProgress(0);
        seekBarBlue.setProgress(0);
        seekBarOpacity.setProgress(255);
        seekBarBrushSize.setProgress(8);



        seekBarRed.setOnSeekBarChangeListener(changeColor);
        seekBarGreen.setOnSeekBarChangeListener(changeColor);
        seekBarBlue.setOnSeekBarChangeListener(changeColor);
        seekBarOpacity.setOnSeekBarChangeListener(changeOpacity);
        seekBarBrushSize.setOnSeekBarChangeListener(changeBrushSize);

    }

    SeekBar.OnSeekBarChangeListener changeColor = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            DoodleView doodleView = (DoodleView) findViewById(R.id.doodleView);
            int red = (int)(seekBarRed.getProgress());
            int green = (int)(seekBarGreen.getProgress());
            int blue = (int)(seekBarBlue.getProgress());
            doodleView.setColor(red, green, blue);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            Toast.makeText(getApplicationContext(), "red: " + Integer.toString(seekBarRed.getProgress()) +
                                                    " green: " + Integer.toString(seekBarGreen.getProgress()) +
                                                    " blue: " + Integer.toString(seekBarBlue.getProgress()), Toast.LENGTH_SHORT).show();
        }
    };


    SeekBar.OnSeekBarChangeListener changeOpacity = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            DoodleView doodleView = (DoodleView) findViewById(R.id.doodleView);
            int opacity = (int)(seekBarOpacity.getProgress());
            doodleView.setPaintOpacity(opacity);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            Toast.makeText(getApplicationContext(), "Opacity: " + Integer.toString(seekBarOpacity.getProgress()), Toast.LENGTH_SHORT).show();
        }
    };

    SeekBar.OnSeekBarChangeListener changeBrushSize = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            DoodleView doodleView = (DoodleView) findViewById(R.id.doodleView);
            int brushSize = (int)(seekBarBrushSize.getProgress());
            doodleView.setBrushSize(brushSize);
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            Toast.makeText(getApplicationContext(), "Brush Size: " + Integer.toString(seekBarBrushSize.getProgress()), Toast.LENGTH_SHORT).show();
        }
    };

    // xml sets the onCLick method
    public void onClearButtonClick (View v){
        DoodleView doodleView = (DoodleView) findViewById(R.id.doodleView);
        doodleView.clearCanvas();
    }

    public void onUndoButtonClick (View v) {
        DoodleView doodleView = (DoodleView) findViewById(R.id.doodleView);
        doodleView.undo();
    }
}
