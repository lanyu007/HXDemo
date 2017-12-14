package my.com.hxdemo;

import android.app.Application;

import com.hyphenate.easeui.EaseUI;

/**
 * Created by lanyu on 2017/12/11.
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        EaseUI.getInstance().init(this, null);
    }

}
