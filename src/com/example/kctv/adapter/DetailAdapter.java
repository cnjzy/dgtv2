package com.example.kctv.adapter;

import com.example.kctv.R;
import com.example.kctv.utils.ViewHolderUtil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailAdapter extends BaseAdapter{
	
	private Context context;
	private String[] datas;
	private LayoutInflater inflater;
	
	public DetailAdapter(Context context, String[] datas){
		this.context = context;
		this.datas = datas;
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return datas.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if(convertView == null){
			convertView = inflater.inflate(R.layout.item_detail, null);
		}
		
		ImageView image_detail = ViewHolderUtil.get(convertView, R.id.image_detail);
		TextView text_detail = ViewHolderUtil.get(convertView, R.id.text_detail);
//		
		text_detail.setText(datas[position]);
		if(position  % 4 != 0){
			image_detail.setBackgroundResource(R.drawable.hot);
		}else if(position % 5 == 0){
			image_detail.setBackgroundResource(R.drawable.new1);
		}else{
			image_detail.setBackgroundResource(R.drawable.hd);
		}
		
		return convertView;
	}
	
}
