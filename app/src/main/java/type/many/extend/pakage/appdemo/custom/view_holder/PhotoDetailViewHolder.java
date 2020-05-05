package type.many.extend.pakage.appdemo.custom.view_holder;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import type.many.extend.pakage.appdemo.R;
import type.many.extend.pakage.appdemo.data.model.PhotoDetail;
import type.many.extend.pakage.appdemo.utils.IpSumImageFactory;

/**
 * Created by User on 2020/5/4.
 */

public class PhotoDetailViewHolder extends RecyclerView.ViewHolder {

    private ImageView mImageView;
    private TextView mThumbnailUrlTextView;
    private TextView mIDTextView;
    private TextView mTitleTextView;

    public PhotoDetailViewHolder(View itemView) {
        super(itemView);

        mImageView = itemView.findViewById(R.id.item_image_view);
        mIDTextView = itemView.findViewById(R.id.item_id_text_view);
        mTitleTextView = itemView.findViewById(R.id.item_title_text_view);
        mThumbnailUrlTextView = itemView.findViewById(R.id.item_thumbnail_url_text_view);
    }

    public void setItem(PhotoDetail detail) {

        if (!TextUtils.isEmpty(detail.getUrl())) {

            String url = IpSumImageFactory.ImageUrlReplace.replaceUrl(detail.getUrl());
            ImageLoader.getInstance().displayImage(url, mImageView);
        }

        mThumbnailUrlTextView.setText(detail.getThumbnailUrl());
        mIDTextView.setText(detail.getID());
        mTitleTextView.setText(detail.getTitle());
    }
}
