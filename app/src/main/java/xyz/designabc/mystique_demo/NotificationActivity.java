package xyz.designabc.mystique_demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import xyz.designabc.mystique.util.transition.TransitionUtils;

/**
 * Authored by vipulkumar on 04/08/17.
 */

public class NotificationActivity extends AppCompatActivity {
    private ViewGroup rootLayout;
    private ImageView ivBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        rootLayout = (ViewGroup) findViewById(R.id.root_layout);
        ivBack = (ImageView) findViewById(R.id.iv_back);

        TransitionUtils.setupFabEnterTransition(this, rootLayout);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
