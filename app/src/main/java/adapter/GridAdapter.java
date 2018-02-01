package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.mf.R;

import java.util.List;

import base.AdapterBase;

/**
 * Created by Administrator on 2017/3/22 0022.
 */

public class GridAdapter extends AdapterBase<String> {
	public GridAdapter(Context ctx, List<String> mDatas) {
		super(ctx, mDatas, R.layout.item_text);
	}

	@Override
	public void Convert(int position, View convertView) {
		TextView tv_title = Get(convertView, R.id.tv);
		SetText(tv_title, getItem(position));
	}
}
