package test.bwei.homework;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import test.bwei.homework.model.Bean;


/**
 * Created by 大白 on 2017/10/30.
 */

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder> {


    private List<Bean.DataBean.ComicsBean> list;
    private Context context;

    public Myadapter(List<Bean.DataBean.ComicsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
              holder.tv.setText(list.get(position).getTitle());
             Picasso.with(context).load(list.get(position).getCover_image_url()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    class  MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tv = itemView.findViewById(R.id.tv);
        }
    }

}
