package test.bwei.lianxi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import test.bwei.lianxi.view.ViewInterface;

public class MainActivity extends AppCompatActivity implements ViewInterface{

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {

        recyclerView = (RecyclerView) findViewById(R.id.recycler);

    }


    @Override
    public void setData(Bean bean) {
         recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }
}
