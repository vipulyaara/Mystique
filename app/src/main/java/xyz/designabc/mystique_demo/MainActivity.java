package xyz.designabc.mystique_demo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import xyz.designabc.mystique.util.transition.DeviceUtil;
import xyz.designabc.mystique.util.transition.TransitionUtils;

public class MainActivity extends AppCompatActivity {
    private ViewGroup notificationLayout;
    private FloatingActionButton fabBadge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationLayout = (ViewGroup) findViewById(R.id.notification_layout);
        fabBadge = (FloatingActionButton) findViewById(R.id.fabBadge);

        notificationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToNotificationActivity();
            }
        });
    }

    private void goToNotificationActivity() {
        Intent intent = new Intent(this, NotificationActivity.class);
        if (!DeviceUtil.isPreLollipopDevice()) {
            ActivityOptions options = TransitionUtils.getFabExitTransitionBundle(this, intent, fabBadge);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
    }
}
