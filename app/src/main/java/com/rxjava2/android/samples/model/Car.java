package com.rxjava2.android.samples.model;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;

/**
 * Created by amitshekhar on 30/08/16.
 */
public class Car {

    private String brand;

    public void setBrand(String brand) {
        this.brand = brand;
    }
//    使用defer可以延迟被订阅者的生成，也就是使得被订阅者是在订阅发生时才生成。 创建时间不同
    public Observable<String> brandDeferObservable() {
        return Observable.defer(new Callable<ObservableSource<? extends String>>() {
            @Override
            public ObservableSource<? extends String> call() throws Exception {
                return Observable.just(brand);
            }
        });
    }

}
