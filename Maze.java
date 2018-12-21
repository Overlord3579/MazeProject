package com.example.a203241.mazegrid;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.view.MotionEvent;

public class Maze extends AppCompatActivity

{
    DemoView demoView;          // custom view for this demo program's Activity (not using
    // R.layout.activity_main that Android Studio provides by default

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);      // not using the default activity_main XML resource
        demoView = new DemoView(this);
        setContentView(demoView);
    }

    private class DemoView extends View
    {
        @Override
        public boolean onTouchEvent(MotionEvent event)
        {

            int eventAction = event.getAction();

            // you may need the x/y location
            int x = (int)event.getX();
            int y = (int)event.getY();

            // put your code in here to handle the event
            switch (eventAction)
            {
                case MotionEvent.ACTION_DOWN:

                    break;
                case MotionEvent.ACTION_UP:

                    break;
                case MotionEvent.ACTION_MOVE:
                    event.getY();
                    event.getX();
                    if(event.getY() >= 0 && event.getX() >= 300)
                    {
                        x += 10;
                    }
                    else if(event.getY() >= 0 && event.getX() <= 100)
                    {
                        x -= 10;
                    }
                    else if(event.getY() <= 100 && event.getX() >= 0)
                    {
                        y -= 10;
                    }
                    else if(event.getY() >= 300 && event.getX() >= 0)
                    {
                        y += 10;
                    }

                    break;
            }

            // tell the View to redraw the Canvas
            invalidate();

            // tell the View that we handled the event
            return true;

        }
        public DemoView(Context context)
        {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas)
        {
            super.onDraw(canvas);

            int screenWidth = getWidth();      // width of the View object but can be thought of as the canvas width
            int screenHeight = getHeight();    // canvas height (TODO: figure out how to account for height of action bar)

            // creating Paint objects to serve as reusable brushes (fill) and pens (stroke)

            Paint paint = new Paint();              // general, miscellaneous paint tasks

            Paint whiteBrush = new Paint();         // white, filled "paintbrush"
            whiteBrush.setColor(Color.WHITE);
            whiteBrush.setStyle(Paint.Style.FILL);

            Paint redBrush = new Paint();           // red, filled paintbrush
            redBrush.setColor(Color.RED);
            redBrush.setStyle(Paint.Style.FILL);

            Paint redPen = new Paint();           // red "pen" that does not fill
            redPen.setColor(Color.RED);
            redPen.setStyle(Paint.Style.STROKE);  // creating a "pen" that does not fill in regions
            redPen.setStrokeWidth(5);            // width of the pen's stroke
            redPen.setAntiAlias(true);         // smooth edges

            // paint the background of the View's canvas
            paint.setColor(Color.BLACK);
            canvas.drawPaint(paint);


            //Drawing Lines for Maze using drawLine

            canvas.drawLine(0, 0, 400, 0, redPen);         //Top border of maze
            canvas.drawLine(400, 0, 400, 400, redPen);     //Right border of maze
            canvas.drawLine(0, 0, 0, 400, redPen);        //Left border of maze
            canvas.drawLine(0, 400, 400, 400, redPen);     //Bottom border of maze
            canvas.drawLine(200, 0, 200, 150, redPen);
            canvas.drawLine(200, 150, 300, 150, redPen);
            canvas.drawLine(200, 50, 400, 50, redPen);
            canvas.drawLine(0, 50, 100, 50, redPen);
            canvas.drawLine(100, 50, 100, 250, redPen);
            canvas.drawLine(50, 150, 150, 150, redPen);
            canvas.drawLine(50, 100, 50, 200, redPen);
            canvas.drawLine(50, 200, 350, 200, redPen);
            canvas.drawLine(350, 100, 350, 350, redPen);
            canvas.drawLine(250, 350, 350, 350, redPen);
            canvas.drawLine(200, 250, 200, 400, redPen);
            canvas.drawLine(150, 250, 150, 300, redPen);
            canvas.drawLine(50, 250, 50, 400, redPen);
            canvas.drawLine(50, 350, 100, 350, redPen);

            //Drawing Rectangles for Maze and filling them using drawRect

            canvas.drawRect(50, 150, 100, 200, redBrush);
            canvas.drawRect(200, 250, 300, 300, redBrush);
            canvas.drawRect(100, 300, 150, 350, redBrush);

            //Drawing a clear start and finish for the Maze using drawText

            paint.setColor(Color.MAGENTA);
            paint.setTextSize(24);
            canvas.drawText("Start", 0, 20, paint);
            canvas.drawText("Finish", 0, 380, paint);

        }

    }



}



