package com.reintegro.profuturo.app.android.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;

import java.io.ByteArrayOutputStream;

public class SignatureView extends View {
    public interface OnBuildSignatureListener<T> {
        void onBuildSignature(T signature);
    }

    private Paint paint;
    private Path path;
    private float lastX;
    private float lastY;

    public SignatureView(Context context) {
        super(context);
        init();
    }

    public SignatureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SignatureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public SignatureView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void buildBase64Signature(OnBuildSignatureListener<String> listener) {
        new Thread(() -> {
            RectF bounds;
            bounds = new RectF();

            path.computeBounds(bounds, true);

            Matrix matrix;
            matrix = new Matrix();
            matrix.setTranslate(-bounds.left, -bounds.top);

            Path helperPath;
            helperPath = new Path();

            path.transform(matrix, helperPath);

            Bitmap bitmapHelper;
            bitmapHelper = Bitmap.createBitmap((int) bounds.width(), (int) bounds.height(), Bitmap.Config.ARGB_8888);

            Canvas canvas;
            canvas = new Canvas(bitmapHelper);
            canvas.drawPath(helperPath, paint);

            ByteArrayOutputStream byteArrayOutputStream;
            byteArrayOutputStream = new ByteArrayOutputStream();

            bitmapHelper.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);

            listener.onBuildSignature(Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT));
        }).start();
    }

    public void clear() {
        path.reset();
        invalidate();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(8);
        paint.setStyle(Paint.Style.STROKE);

        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = event.getX();
                lastY = event.getY();

                path.moveTo(event.getX(), event.getY());

                invalidate();

                return true;

            case MotionEvent.ACTION_MOVE:
                path.quadTo(lastX, lastY, (event.getX() + lastX) / 2, (event.getY() + lastY) / 2);

                lastX = event.getX();
                lastY = event.getY();

                invalidate();

                return true;

            case MotionEvent.ACTION_UP:
                path.lineTo(event.getX(), event.getY());

                invalidate();

                return true;

            default:
                return super.onTouchEvent(event);
        }
    }
}
