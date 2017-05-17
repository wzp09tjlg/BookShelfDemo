package com.example.wuzp.bookselfdemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by wuzp on 2017/5/17.
 */

public class HApplication extends Application {
    public static Context gContext;

    @Override
    public void onCreate() {
        super.onCreate();
        gContext = this;
        initGlobalVar();
    }

    private void initGlobalVar(){
        //使用imageLoader 貌似不能通过compile的方式处理，只能通过添加jar的形式吧
        /*ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .threadPriority(Thread.NORM_PRIORITY - 2)    // 线程优先级
                .denyCacheImageMultipleSizesInMemory()     // 当同一个Uri获取不同大小的图片，缓存到内存时，只缓存一个。默认会缓存多个不同的大小的相同图片
                .discCacheFileNameGenerator(new Md5FileNameGenerator()) // 将保存的时候的URI名称用MD5
                .tasksProcessingOrder(QueueProcessingType.LIFO)   // 设置图片下载和显示的工作队列排序
                .writeDebugLogs()          // 打印debug log
                .build();*/
    }
}
