package id.rofiqoff.tantangan.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import java.util.List;

import id.rofiqoff.tantangan.R;
import id.rofiqoff.tantangan.adapter.DestinationAdapter;
import id.rofiqoff.tantangan.data.DataGenerator;
import id.rofiqoff.tantangan.model.Destination;
import id.rofiqoff.tantangan.utils.Tools;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private RecyclerView mListDestination1;
    private RecyclerView mListDestination2;
    private AppCompatImageView mButtonArrow;
    private LinearLayout mParentDirection;
    private RelativeLayout mParentItem;

    private boolean isShowDirection = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        Tools.changeMenuIconColor(menu, getResources().getColor(R.color.grey_60));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } else {
            Tools.showToast(getApplicationContext(), item.getTitle().toString());
        }
        return super.onOptionsItemSelected(item);
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Day Plans");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Tools.setSystemBarColor(this, R.color.grey_5);
        Tools.setSystemBarLight(this);
    }

    private void initComponent() {
        mToolbar = findViewById(R.id.toolbar);
        mListDestination1 = findViewById(R.id.list_item);
        mListDestination2 = findViewById(R.id.list_item_2);
        mButtonArrow = findViewById(R.id.icon_arrow_2);
        mParentItem = findViewById(R.id.parent_item_2);
        mParentDirection = findViewById(R.id.parent_direction);

        initToolbar();
        initListDestination1();
        initListDestination2();

        mButtonArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHideDirection(!isShowDirection);
            }
        });
    }

    private void initListDestination1() {
        mListDestination1.setHasFixedSize(true);

        List<Destination> items = DataGenerator.getDestination1(this);

        DestinationAdapter adapter = new DestinationAdapter(this, items);
        mListDestination1.setAdapter(adapter);
    }

    private void initListDestination2() {
        mListDestination2.setNestedScrollingEnabled(false);

        List<Destination> items = DataGenerator.getDestination2(this);

        DestinationAdapter adapter = new DestinationAdapter(this, items);
        mListDestination2.setAdapter(adapter);
    }

    private void showHideDirection(boolean isShow) {
        isShowDirection = isShow;
        if (isShow) {
            TransitionManager.beginDelayedTransition(mParentItem);
            mParentDirection.setVisibility(View.VISIBLE);
            mButtonArrow.setImageResource(R.drawable.ic_keyboard_arrow_up);
        } else {
            TransitionManager.beginDelayedTransition(mParentItem);
            mParentDirection.setVisibility(View.GONE);
            mButtonArrow.setImageResource(R.drawable.ic_keyboard_arrow_down);
        }
    }

}
