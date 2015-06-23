package com.example.administrator.mengbaofushiji.adapter;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.administrator.mengbaofushiji.R;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/6/23.
 */
public class AddLogsRecyclerAdapter extends RecyclerView.Adapter<AddLogsRecyclerAdapter.ViewHolder> {

    //    public interface OnItemClickListener
//    {
//        void onItemClick(View view, int position);
//    }
//    private OnItemClickListener mOnItemClickListener;
//
//    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener)
//    {
//        this.mOnItemClickListener = mOnItemClickListener;
//    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
    private List<Map<String,Object>> list;
    public AddLogsRecyclerAdapter(List<Map<String,Object>> list) {
        this.list=list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=null;
        Log.i("viewType",viewType+"");
        switch (viewType){
            case 0:
                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.addlogs_recyclerview_item_fushi, parent, false);
                break;
            case 1:
                v= LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.addlogs_recyclerview_item_suishou, parent, false);
                break;
        }
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

    }
    @Override
    public int getItemViewType(int position) {
        Log.i("position",position+"");
        return Integer.valueOf(list.get(position).get("type").toString());
    }
    @Override
    public int getItemCount() {
        Log.i("size",list.size()+"");
        return list.size();
    }
}
