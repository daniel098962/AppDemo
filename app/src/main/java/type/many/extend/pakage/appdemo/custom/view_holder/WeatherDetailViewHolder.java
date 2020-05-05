package type.many.extend.pakage.appdemo.custom.view_holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import type.many.extend.pakage.appdemo.R;
import type.many.extend.pakage.appdemo.data.model.WeatherTimeDetail;

/**
 * Created by User on 2020/5/5.
 */

public class WeatherDetailViewHolder extends RecyclerView.ViewHolder {

    public WeatherDetailViewHolder(View itemView) {
        super(itemView);

        mStartTimeTextView = itemView.findViewById(R.id.item_start_time_text_view);
        mEndTimeTextView = itemView.findViewById(R.id.item_end_time_text_view);
        mMinTempTextView = itemView.findViewById(R.id.item_min_temp_text_view);
    }

    private TextView mStartTimeTextView;
    private TextView mEndTimeTextView;
    private TextView mMinTempTextView;

    public void setItem(WeatherTimeDetail detail) {

        mStartTimeTextView.setText(detail.getStartTime());
        mEndTimeTextView.setText(detail.getEndTime());
        mMinTempTextView.setText(detail.getWeatherParameterDetail().getParameterName() + detail.getWeatherParameterDetail().getParameterUnit());
    }
}
