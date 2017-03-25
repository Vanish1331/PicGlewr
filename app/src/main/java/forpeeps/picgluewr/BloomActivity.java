package forpeeps.picgluewr;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import com.agsw.FabricView.FabricView;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

/**
 * Created by User on 15.03.2017.
 */

public class BloomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);


        final FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.actionbutton);
        final FloatingActionButton floatingActionButton1 = (FloatingActionButton) findViewById(R.id.gActionButton2);



        final FabricView fabricView = (FabricView) findViewById(R.id.faricView);
        fabricView.setColor(Color.BLACK);
        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabricView.cleanPage();
            }
        });


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorPickerDialogBuilder
                        .with(BloomActivity.this)
                        .setTitle("Choose color")
                        .initialColor(Color.WHITE)
                        .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                        .density(12)
                        .setPositiveButton("ok", new ColorPickerClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {
                                fabricView.setColor(selectedColor);
                            }
                        })
                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .build()
                        .show();


            }
        });


        floatingActionButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                floatingActionButton.animate().translationX(-120).scaleX(1).scaleY(1).setDuration(500).start();

                return false;
            }
        });






        fabricView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    floatingActionButton.animate().translationX(0).scaleX(0).scaleY(0).start();
                    floatingActionButton1.animate().translationX(0).scaleX(0).scaleY(0).setDuration(500).start();
                } else if (motionEvent.getAction()==MotionEvent.ACTION_UP) {
                    floatingActionButton.animate().scaleX(1).scaleY(1).start();
                    floatingActionButton1.animate().translationX(0).scaleX(1).scaleY(1).setDuration(500).start();
                }


                return false;
            }
        });

    }

}
