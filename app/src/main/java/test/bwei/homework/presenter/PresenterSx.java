package test.bwei.homework.presenter;

import test.bwei.homework.FinishListener;
import test.bwei.homework.model.Bean;
import test.bwei.homework.model.ModelInterface;
import test.bwei.homework.model.ModelSx;
import test.bwei.homework.view.ViewInterface;

/**
 * Created by 大白 on 2017/10/30.
 */

public class PresenterSx  implements  PresenterInterface,FinishListener{


    private ViewInterface viewInterface = null;
    private final ModelInterface modelInterface;

    public PresenterSx(ViewInterface viewInterface) {
        this.viewInterface = viewInterface;
        modelInterface = new ModelSx();

    }

    @Override
    public void PassData() {
        modelInterface.getData(this);
    }

    @Override
    public void Seuccess(Bean bean) {

            viewInterface.showData(bean);

    }
}
