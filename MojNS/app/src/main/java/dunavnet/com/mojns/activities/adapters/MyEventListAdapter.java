package dunavnet.com.mojns.activities.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import dunavnet.com.mojns.R;
import dunavnet.com.mojns.model.MyEvents;

/**
 * Created by Tomek on 5.9.2015.
 */
public class MyEventListAdapter extends BaseAdapter {

    private Activity mActivity;
    public ViewHolder holder;
    private LayoutInflater inflater;
    ArrayList<MyEvents> myEvents;

    public MyEventListAdapter(Activity activity, ArrayList<MyEvents> myEvents) {
        this.myEvents = myEvents;
        inflater = activity.getLayoutInflater();
        mActivity = activity;
    }

    public void refreshList(ArrayList<MyEvents> myEvents){
        this.myEvents = myEvents;
    }

    public void refresh(){
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return myEvents.size();
    }

    @Override
    public Object getItem(int position) {
        return myEvents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyEvents item = myEvents.get(position);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.my_events_item, null);
            holder = new ViewHolder();

            convertView.setTag(holder);
        }

        holder = (ViewHolder) convertView.getTag();

        holder.date = (TextView) convertView.findViewById(R.id.observation_date);
        holder.time = (TextView) convertView.findViewById(R.id.observation_time_text);
        holder.desc = (TextView) convertView.findViewById(R.id.observation_description_text);
        holder.status = (TextView) convertView.findViewById(R.id.observation_status_text);


        if (item != null) {
            Date date = null;
            String datetime = "";
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
            try {
                date = format.parse(item.getDate().split(" ")[0]);

                datetime = dateFormat.format(date);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            holder.date.setText(datetime);
            holder.time.setText(item.getTime());
            holder.desc.setText(item.getDescription().split(":")[1].substring(1));
            holder.status.setText(item.getStatus());

        }
        return convertView;
    }

    class ViewHolder {
        TextView date;
        TextView time;
        TextView desc;
        TextView status;
    }

}
