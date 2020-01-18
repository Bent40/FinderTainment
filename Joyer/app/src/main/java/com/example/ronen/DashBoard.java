package com.example.ronen;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.text.Layout;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class DashBoard extends AppCompatActivity {


    private ViewPager slider;
    private SliderAdapter sliderAdapter;
    private Drawer result;
    EditText search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        setContentView(R.layout.activity_dash_board);
        final Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        slider = findViewById(R.id.slider);
        sliderAdapter = new SliderAdapter(this);
        slider.setAdapter(sliderAdapter);

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header_background)
                .addProfiles(
                        new ProfileDrawerItem().withName("Person's Name").withEmail("person's.email@gmail.com")
                )
                .build();
        PrimaryDrawerItem search_item = new PrimaryDrawerItem().withIdentifier(1).withName("Search");
        SecondaryDrawerItem home_item = new SecondaryDrawerItem().withIdentifier(2).withName("Home");
        SecondaryDrawerItem history_item = new SecondaryDrawerItem().withIdentifier(3).withName("History");
        SecondaryDrawerItem map_icon = new SecondaryDrawerItem().withIdentifier(4).withName("Map");
        SecondaryDrawerItem saved_icon = new SecondaryDrawerItem().withIdentifier(5).withName("Saved Places");
        SecondaryDrawerItem profile_icon = new SecondaryDrawerItem().withIdentifier(6).withName("edit profile");

           result = new DrawerBuilder()
                .withAccountHeader(headerResult)
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        search_item.withSelectable(false),
                        new DividerDrawerItem(),
                        home_item,
                        history_item,
                        map_icon,
                        saved_icon,
                        profile_icon
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D
                        switch ((int)drawerItem.getIdentifier()){
                            case 1:
                                result.closeDrawer();
                                toolbar.setVisibility(View.GONE);
                                LinearLayout toolbarLayout = findViewById(R.id.toolbar_layout);
                                search = new EditText(DashBoard.this);
                                search.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                                search.setHint("Search");
                                search.setTextColor(Color.WHITE);
                                search.setHintTextColor(Color.rgb(178,190,195));
                                toolbarLayout.addView(search);

                                search.requestFocus();
                                InputMethodManager inputMethodManager =
                                        (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                                inputMethodManager.toggleSoftInputFromWindow(
                                        toolbarLayout.getApplicationWindowToken(),
                                        InputMethodManager.SHOW_FORCED, 0);
                                search.setMaxLines(1);
                                search.setInputType(InputType.TYPE_CLASS_TEXT);
                                search.setOnEditorActionListener(new EditText.OnEditorActionListener() {
                                    @Override
                                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                                        if (actionId == EditorInfo.IME_ACTION_NEXT) {
                                            Toast.makeText(DashBoard.this, v.getText(), Toast.LENGTH_SHORT).show();
                                            return true;
                                        }
                                        return false;
                                    }
                                });

                                scaleView(search,0f,1f);


                                break;
                            case 2:

                                break;
                            case 3:

                                break;
                            case 4:

                                break;
                            case 5:

                                break;
                            case 6:

                                break;
                            default:
                                throw new IllegalStateException("Unexpected value: " + (int) drawerItem.getIdentifier());
                        }
                        return true;
                    }
                })
                .build();
        result.setSelection(home_item,false);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            result.getDrawerLayout().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        }
    }

    public void scaleView(View v, float startScale, float endScale) {
        Animation anim = new ScaleAnimation(
                startScale, endScale, // Start and end values for the X axis scaling
                1f,1f , // Start and end values for the Y axis scaling
                Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
                Animation.RELATIVE_TO_SELF, 0.5f); // Pivot point of Y scaling
        anim.setFillAfter(true); // Needed to keep the result of the animation
        anim.setDuration(1000);
        v.startAnimation(anim);
    }
}
