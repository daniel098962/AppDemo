package type.many.extend.pakage.appdemo.custom;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import type.many.extend.pakage.appdemo.R;

/**
 * Created by User on 2020/5/4.
 */

/**
 * 轉圈Loading Dialog
 */
public class CircleProgressDialog extends ProgressDialog {
    public CircleProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circle_progress_dialog);
    }
}
