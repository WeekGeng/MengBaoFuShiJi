package com.example.administrator.mengbaofushiji.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.mengbaofushiji.R;
import com.example.administrator.mengbaofushiji.extras.AnimatedExpandableListView;
import com.example.administrator.mengbaofushiji.pagerfragment.GroupItem;
import com.github.siyamed.shapeimageview.RoundedImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Administrator on 2015/6/2.
 */
public class ExpListAdapter extends AnimatedExpandableListView.AnimatedExpandableListAdapter {
    List<GroupItem> items;
    public ExpListAdapter(List<GroupItem> items) {
        this.items = items;
    }
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.school_groupitem, parent, false);
            groupViewHolder = new GroupViewHolder(convertView);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        String title = items.get(groupPosition).title;
        groupViewHolder.tv_title.setText(title);
        return convertView;
    }
    @Override
    public View getRealChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.school_child_item, parent, false);
            childViewHolder = new ChildViewHolder(convertView);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        ImageLoader.getInstance().displayImage(items.get(groupPosition).item.get(childPosition).url, childViewHolder.school_explv_child_iv);
        childViewHolder.school_explv_child_title.setText(items.get(groupPosition).item.get(childPosition).title);
        childViewHolder.school_explv_child_content.setText(items.get(groupPosition).item.get(childPosition).description);
        childViewHolder.school_explv_child_tv_liulan.setText(""+items.get(groupPosition).item.get(childPosition).seeCount);
        childViewHolder.school_explv_child_tv_shoucang.setText(""+items.get(groupPosition).item.get(childPosition).collectionCount);
        childViewHolder.school_explv_child_tv_goumai.setText(""+items.get(groupPosition).item.get(childPosition).buyCount);
        return convertView;
    }

    @Override
    public int getRealChildrenCount(int groupPosition) {
        return items.get(groupPosition).item.size();
    }

    @Override
    public int getGroupCount() {
        return items.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return items.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return items.get(groupPosition).item.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
    class GroupViewHolder {
        TextView tv_title;
        public GroupViewHolder(View view) {
            this.tv_title = (TextView) view.findViewById(R.id.school_explv_group_tv);
        }
    }

    class ChildViewHolder {
        RoundedImageView school_explv_child_iv;
        TextView school_explv_child_title;
        TextView school_explv_child_content;
        TextView school_explv_child_tv_liulan;
        TextView school_explv_child_tv_shoucang;
        TextView school_explv_child_tv_goumai;

        public ChildViewHolder(View view) {
            this.school_explv_child_iv = (RoundedImageView) view.findViewById(R.id.school_explv_child_iv);
            this.school_explv_child_title = (TextView) view.findViewById(R.id.school_explv_child_title);
            this.school_explv_child_content = (TextView) view.findViewById(R.id.school_explv_child_content);
            this.school_explv_child_tv_liulan = (TextView) view.findViewById(R.id.school_explv_child_tv_liulan);
            this.school_explv_child_tv_shoucang = (TextView) view.findViewById(R.id.school_explv_child_tv_shoucang);
            this.school_explv_child_tv_goumai = (TextView) view.findViewById(R.id.school_explv_child_tv_goumai);
        }
    }
}
