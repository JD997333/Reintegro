package com.reintegro.profuturo.app.util;

import android.net.Uri;

public class BiometricEngineUtils {
    public static final String PATH_HUELLA = "huellaDigital";
    public static final String CONTENT_AUTHORITY = "com.profuturo.biometria.contentproviders";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_HUELLA).build();

    public static Uri buildEmployeeWorkerUriQuery(String app, String tag, String clientCurp, String agentCode) {
        return CONTENT_URI.buildUpon().appendPath(app).appendPath(tag).appendPath(clientCurp).appendPath(agentCode).build();
    }
}
