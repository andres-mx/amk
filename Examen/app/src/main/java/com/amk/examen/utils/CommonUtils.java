package com.amk.examen.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;

import com.amk.examen.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by andresaleman on 9/21/17.
 */

public final class CommonUtils {

    private static final String TAG = "CommonUtils";

    private CommonUtils() {
        // This utility class is not publicly instantiable
    }

    public static ProgressDialog showLoadingDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.show();
        if (progressDialog.getWindow() != null) {
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }

    public static boolean isRegexAUpperCaseLetter(String letter)
    {
        Pattern pattern;
        Matcher matcher;
        final String USER_PATTERN =
                "(?=.*[A-Z])(?=.*[a-z]).*";
        pattern = Pattern.compile(USER_PATTERN);
        matcher = pattern.matcher(letter);
        return matcher.matches();
    }

    public static boolean isRegexSpecialCharacter(String special)
    {
        Pattern pattern;
        Matcher matcher;
        final String USER_PATTERN =
                "^[a-zA-Z0-9äöüÄÖÜñÑ]*$";
        pattern = Pattern.compile(USER_PATTERN);
        matcher = pattern.matcher(special);
        return matcher.matches();
    }

    public static boolean isLengthEigth(String length)
    {
        boolean isLength = false;
        if(length.length()>7)
        {
            isLength = true;
        }

        return isLength;
    }

    public static boolean isRegexSpace(String space)
    {
        Pattern pattern;
        Matcher matcher;
        final String USER_PATTERN =
                "^\\S+$";
        pattern = Pattern.compile(USER_PATTERN);
        matcher = pattern.matcher(space);
        return matcher.matches();
    }

    public static boolean isEmpty(String user, String password)
    {
        boolean isTrue=false;
        if(!TextUtils.isEmpty(user) && !TextUtils.isEmpty(password))
        {
            isTrue = true;
        }

        return isTrue;
    }



    public static String loadJSONFromAsset(Context context, String jsonFileName)
            throws IOException {

        AssetManager manager = context.getAssets();
        InputStream is = manager.open(jsonFileName);

        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();

        return new String(buffer, "UTF-8");
    }
}
