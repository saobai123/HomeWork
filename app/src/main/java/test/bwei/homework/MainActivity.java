package test.bwei.homework;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import test.bwei.homework.model.Bean;
import test.bwei.homework.presenter.PresenterInterface;
import test.bwei.homework.presenter.PresenterSx;
import test.bwei.homework.view.ViewInterface;

public class MainActivity extends AppCompatActivity implements ViewInterface, SwipeRefreshLayout.OnRefreshListener {

    private   static final  int num=1;
    private   int p ;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout sp;


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what){
                case num:
                    p++;
                    presenterInterface.PassData();
                    adapter.notifyDataSetChanged();
                    sp.setRefreshing(false);
                    break;
            }
        }
    };
    private Myadapter adapter;
    private List<Bean.DataBean.ComicsBean> list;
    private PresenterInterface presenterInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        sp = (SwipeRefreshLayout) findViewById(R.id.sp);
        sp.setOnRefreshListener(this);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        presenterInterface = new PresenterSx(this);
         presenterInterface.PassData();

    }


    @Override
    public void showData(Bean bean) {

        list = bean.getData().getComics();
        adapter = new Myadapter(list,MainActivity.this);
        recyclerView.setAdapter(adapter);


    }


    @Override
    public void onRefresh() {
           handler.sendEmptyMessageDelayed(num,2000);
    }
}
