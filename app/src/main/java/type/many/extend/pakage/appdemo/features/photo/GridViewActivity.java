package type.many.extend.pakage.appdemo.features.photo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import type.many.extend.pakage.appdemo.R;
import type.many.extend.pakage.appdemo.custom.AppDemoApplication;
import type.many.extend.pakage.appdemo.custom.CircleProgressDialog;
import type.many.extend.pakage.appdemo.custom.view_holder.PhotoDetailViewHolder;
import type.many.extend.pakage.appdemo.data.AppProperties;
import type.many.extend.pakage.appdemo.data.model.PhotoDetail;

public class GridViewActivity extends AppCompatActivity {

    /*=================================================================*/
    // Global
    /*=================================================================*/

    //跳頁帶資料
    public static void startActivity(Context context, String data) {

        Intent intent = new Intent(context, GridViewActivity.class);
        intent.putExtra(AppProperties.Intent.STRING, data);
        context.startActivity(intent);
    }

    //跳頁
    public static void startActivity(Context context) {

        Intent intent = new Intent(context, GridViewActivity.class);
        context.startActivity(intent);
    }

    /*=================================================================*/
    // Constructor
    /*=================================================================*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        //region View
        {
            mRecyclerView = findViewById(R.id.recycler_view);
        }
        //endregion

        //region Data
        {
            //將Recycler設定為橫向網格排列
            mRecyclerView.setLayoutManager(new GridLayoutManager(GridViewActivity.this, 4));
        }
        //endregion

        //region Event
        {

        }
        //endregion

        //region Function
        {
            //同步圖片資訊
            syncPhoto();
        }
        //endregion
    }

    /*=================================================================*/
    // View
    /*=================================================================*/
    private RecyclerView mRecyclerView;
    private CircleProgressDialog mCircleProgressDialog;    //Loading Dialog

    /*=================================================================*/
    // Data
    /*=================================================================*/
    private List<PhotoDetail> mPhotoDetailList = new ArrayList<>();

    //RecyclerView 適配器
    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter() {
        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = View.inflate(parent.getContext(), R.layout.item_detail, null);

            PhotoDetailViewHolder vh = new PhotoDetailViewHolder(view);

            return vh;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            PhotoDetailViewHolder photoDetailViewHolder = (PhotoDetailViewHolder) holder;
            photoDetailViewHolder.setItem(mPhotoDetailList.get(position));
        }

        @Override
        public int getItemCount() {

            return mPhotoDetailList.size();
        }
    };

    /*=================================================================*/
    // Function
    /*=================================================================*/

    //同步圖片資訊
    private void syncPhoto() {
        //顯示Loading
        showProgressDialog();

        Callback<List<PhotoDetail>> apiCallback = new Callback<List<PhotoDetail>>() {
            @Override
            public void onResponse(Call<List<PhotoDetail>> call, Response<List<PhotoDetail>> response) {
                //隱藏Loading
                hideProgressDialog();

                Log.d("///", "Response: " + new Gson().toJson(response.body()));
                mPhotoDetailList = response.body();

                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<PhotoDetail>> call, Throwable t) {
                //隱藏Loading
                hideProgressDialog();
                Log.d("///", "Fail: " + t.getMessage());
            }
        };

        AppDemoApplication
                .instance()
                .getDemoApiManager()
                .getApi()
                .callSyncPhoto()
                .enqueue(apiCallback);
    }

    //顯示LoadingDialog
    private void showProgressDialog() {
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
    private void hideProgressDialog() {
        if (mCircleProgressDialog != null && mCircleProgressDialog.isIndeterminate() && !isDestroyed()) {
            mCircleProgressDialog.dismiss();
            mCircleProgressDialog = null;
        }
    }
}
