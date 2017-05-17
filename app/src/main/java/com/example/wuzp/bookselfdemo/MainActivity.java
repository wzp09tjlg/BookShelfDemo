package com.example.wuzp.bookselfdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

//这个demo就是想测试下 recyclerView在暂时
//测试跑一下 如果展示100个数据的法  会耗费多少内存和使用的流畅度
public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LoadAdapter adapter;
    private ArrayList<LoadBean> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        recyclerView = (RecyclerView)findViewById(R.id.recycler);

        initData();
    }

    private void initData(){
       mData = getData();
       //针对recyclerView 的使用
        //layoutmanager
        //itemDecorate//~
        //adapter
        //itemAnimation//~
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));//3列
        adapter = new LoadAdapter(this,mData);
        recyclerView.setAdapter(adapter);
        //如果不设置adapter 耗费内存3.3M
        //设置图片 为xhdpi中耗费内存 7.89M
        //设置图片 为drawable中 耗费内存 20M //之前处理过这样的问题 图片会被放大多倍
        //使用glide 加载网络数据 耗费内存在10M左右
        //使用picasso 加载图片数据 耗费内存在60左右（来回滑动 内存波动好厉害，幅度非常大。默认不缓存）
              //使用picasso 设置缓存配置如下
              //图片在设置大小之后 内存稳定，使用在8M左右.没有设置大小 非常耗费内存
    }

    private ArrayList<LoadBean> getData(){
        int[] ids = {R.drawable.icon_local0,
                R.drawable.icon_local,
                R.drawable.icon_local2,
                R.drawable.icon_local3,
                R.drawable.icon_local4,
                R.drawable.icon_local5,
                R.drawable.icon_local6,
                R.drawable.icon_local7,
                R.drawable.icon_local8,
        };
        String[] imgUrls = {
                "http://image.tianjimedia.com/uploadImages/2015/162/35/9XJ5313VPG1R.jpg",
                "http://image.tianjimedia.com/uploadImages/2015/162/44/9XEPI4441PDX.jpg",
                "http://image.tianjimedia.com/uploadImages/2015/162/48/O309K2WEBZ8F.jpg",
                "http://image.tianjimedia.com/uploadImages/2015/162/56/RYIFV3QLXP76.jpg",
                "http://image.tianjimedia.com/uploadImages/2015/162/39/D2O7U26Q0R32.jpg",
                "http://image.tianjimedia.com/uploadImages/2015/162/51/HOBD0QHSH8PT.jpg",
                "http://image.tianjimedia.com/uploadImages/2015/162/09/B04K1M084W3V.jpg",
                "http://image.tianjimedia.com/uploadImages/2015/162/14/Y5ZXCRP3LN82.jpg",
                "http://image.tianjimedia.com/uploadImages/2015/141/56/77ALUS838916.jpg"
        };
        String[] names = {"this is a book one","Book Two","book Threeee","BOOK Four",
                "book Five","Book Sex? six?","Book Sevennnnn","book eighttttt","bokkk nineeeee"};
        mData = new ArrayList<>();
        int tempLen = imgUrls.length;
        for(int i=0;i<200;i++){ //模拟两百本数据
            int temp = i % tempLen;
           LoadBean bean = new LoadBean();
            bean.setImg(ids[temp]);
            bean.setUrl(imgUrls[temp]);
            bean.setName(names[temp]);
            mData.add(bean);
        }
        return mData;
    }
}
