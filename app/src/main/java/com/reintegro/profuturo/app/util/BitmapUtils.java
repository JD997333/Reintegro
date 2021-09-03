package com.reintegro.profuturo.app.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.pdf.PdfRenderer;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;

import java.io.File;
import java.io.IOException;

public class BitmapUtils {
    public interface OnCompleteListener {
        void onComplete(Bitmap bitmap);
    }

    public static void decodeByteArray(byte[] bytes, OnCompleteListener onCompleteListener) {
        new Thread(() -> {
            Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

            Handler handler;
            handler = new Handler(Looper.getMainLooper());
            handler.post(() -> onCompleteListener.onComplete(bitmap));
        }).start();
    }

    public static void decodeFile(Context context, File file, OnCompleteListener onCompleteListener) {
        new Thread(() -> {
            try {
                ParcelFileDescriptor parcelFileDescriptor;
                parcelFileDescriptor = ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY);

                PdfRenderer pdfRenderer;
                pdfRenderer = new PdfRenderer(parcelFileDescriptor);

                PdfRenderer.Page page;
                page = pdfRenderer.openPage(0);

                Bitmap bitmap;
                bitmap = Bitmap.createBitmap(
                    context.getResources().getDisplayMetrics().densityDpi * page.getWidth() / 72,
                    context.getResources().getDisplayMetrics().densityDpi * page.getHeight() / 72,
                    Bitmap.Config.ARGB_8888
                );

                page.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);

                onCompleteListener.onComplete(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
