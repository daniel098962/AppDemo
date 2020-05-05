package type.many.extend.pakage.appdemo.custom;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import type.many.extend.pakage.appdemo.R;

/**
 * Created by User on 2020/5/5.
 */

public class DemoActivity extends Activity {

    /*===================================================================*/
    // Constructor
    /*===================================================================*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /*===================================================================*/
    // View
    /*===================================================================*/
    private CircleProgressDialog mCircleProgressDialog;

    /*===================================================================*/
    // Function
    /*===================================================================*/

    //顯示LoadingDialog
    public void showProgressDialog() {
        if (mCircleProgressDialog == null) {
            mCircleProgressDialog = new CircleProgressDialog(this, R.style.AlertDialogStyle);
            mCircleProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

            mCircleProgressDialog.setIndeterminate(true);
            mCircleProgressDialog.setCanceledOnTouchOutside(false);
            mCircleProgressDialog.setCancelable(false);

            mCircleProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    finish();
                }
            });

            try {
                mCircleProgressDialog.show();
            } catch (Exception exception) {
                Log.d("///", exception.getMessage());
            }
        }
    }

    //隱藏Loading Dialog
    public void hideProgressDialog() {
        if (mCircleProgressDialog != null && mCircleProgressDialog.isIndeterminate() && !isDestroyed()) {
            mCircleProgressDialog.dismiss();
            mCircleProgressDialog = null;
        }
    }
}
