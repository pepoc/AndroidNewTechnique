package com.pepoc.androidnewtechnique.rxbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxView;
import com.pepoc.androidnewtechnique.R;
import com.pepoc.androidnewtechnique.log.LogManager;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.functions.Action1;

public class RxBusActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.btn_test)
    Button btnTest;
    @Bind(R.id.btn_unsubscribe)
    Button btnUnsubscribe;

    private RxBus rxBus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_bus);
        ButterKnife.bind(this);

        init();

    }

    private void init() {
        setSupportActionBar(toolbar);

        rxBus = new RxBus();

        RxView.clicks(btnTest).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                rxBus.send("Yangchen");
            }
        });

        final Subscriber subscriber = new TestSubscriber<Object>() {
            @Override
            public void onNext(Object o) {
                Toast.makeText(RxBusActivity.this, o.toString(), Toast.LENGTH_SHORT).show();
            }
        };

        rxBus.toObserverable().subscribe(subscriber);

        RxView.clicks(btnUnsubscribe).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                LogManager.i("---------------- " + subscriber.isUnsubscribed());
                if (!subscriber.isUnsubscribed()) {
                    subscriber.unsubscribe();
                }
            }
        });

    }

    class TestSubscriber<T> extends Subscriber<T> {

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(T t) {

        }
    }

}
