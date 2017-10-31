package test.bwei.homework.model;

import com.bwei.okhttp3ps.utils.GsonObjectCallback;
import com.bwei.okhttp3ps.utils.OkHttp3Utils;

import java.io.IOException;

import okhttp3.Call;
import test.bwei.homework.FinishListener;

/**
 * Created by 大白 on 2017/10/30.
 */

public class ModelSx implements ModelInterface {


    @Override
    public void getData(final FinishListener listener) {

        String url = "http://api.kkmh.com/v1/daily/comic_lists/1487606400?since=0&gender=0";

        OkHttp3Utils.doGet(url, new GsonObjectCallback<Bean>() {
            @Override
            public void onUi(Bean bean) {
                if(listener!=null) {
                    listener.Seuccess(bean);
                }
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });


    }



}
