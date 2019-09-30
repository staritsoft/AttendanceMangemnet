package xact.idea.attendancesystem.Fragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import xact.idea.attendancesystem.Adapter.UnitDepartmentAdapter;
import xact.idea.attendancesystem.R;
import xact.idea.attendancesystem.Utils.CorrectSizeUtil;
import xact.idea.attendancesystem.Utils.Utils;
import xact.idea.attendancesystem.ViewPager.HomePagerFragmentAdapter;


public class SetUpFragment extends Fragment {
    Activity mActivity;
    CorrectSizeUtil correctSizeUtil;
    private View mRoot;
    private LinearLayout lnl_category;
    RelativeLayout rlt_fragment_root;
    public static RelativeLayout rlt_home_category;
    View homeCategoryBackground;
    View CategoryLineColor;
    int[] rainbow;
    ArrayList<String> arrayList = new ArrayList<>();
    private RecyclerView rcl_this_place_list;
    private UnitDepartmentAdapter mAdapters = null;
    Button btn_1;
    Button btn_2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRoot= inflater.inflate(R.layout.fragment_set_up, container, false);
        mActivity=getActivity();
        correctSizeUtil= correctSizeUtil.getInstance(getActivity());
        correctSizeUtil.setWidthOriginal(1080);
        correctSizeUtil.correctSize(mRoot);
     //   initView();
        btn_2=mRoot.findViewById(R.id.btn_2);
        btn_1=mRoot.findViewById(R.id.btn_1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_1.setBackground(mActivity.getResources().getDrawable(R.drawable.round_button_green));
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_2.setBackground(mActivity.getResources().getDrawable(R.drawable.round_button_green));
            }
        });
        rcl_this_place_list=mRoot.findViewById(R.id.rcl_this_place_list);

        LinearLayoutManager lm = new LinearLayoutManager(mActivity);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        rcl_this_place_list.setLayoutManager(lm);


        for(int j = 0; j < 7; j++){

            arrayList.add("House "+j);
        }


        mAdapters = new UnitDepartmentAdapter(mActivity, arrayList);

        rcl_this_place_list.setAdapter(mAdapters);

        return mRoot;
    }

//    private void initView() {
//        lnl_category = (LinearLayout) mRoot.findViewById(R.id.lnl_category);
//        mRoot.findViewById(R.id.view_touch).setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Utils.hideKeyboard(getActivity(), mRoot.findViewById(R.id.view_touch));
//                return false;
//            }
//        });
//        initCategoryList(true);
//        initPager();
//        selectCategory(0, true);
//        mRoot.findViewById(R.id.view_category_selected_run).setBackground(Utils.getGradientColor(getContext()));
//    }
//    private void initCategoryList(boolean test) {
//
//        if (test==true){
//            rlt_fragment_root = (RelativeLayout) mRoot.findViewById(R.id.rlt_fragment_root);
//            rlt_home_category = (RelativeLayout) mRoot.findViewById(R.id.rlt_home_category);
//
//            scr_category = (HorizontalScrollView) mRoot.findViewById(R.id.scr_category);
//            mViewRunner = (View) mRoot.findViewById(R.id.view_category_selected_run);
//            CategoryLineColor = (View) mRoot.findViewById(R.id.CategoryLineColor);
//            homeCategoryBackground = (View) mRoot.findViewById(R.id.homeCategoryBackground);
//
//            String[] categories = mActivity.getResources().getStringArray(R.array.timeline_category);
//            rainbow = mActivity.getResources().getIntArray(R.array.colors);
//            if (lnl_category.getChildCount() != categories.length) {
//                return; // check developer mistakes
//            } else {
//                // ignore
//            }
//            for (  int i = 0; i < lnl_category.getChildCount(); i++) {
//
//                RelativeLayout rlt1 = (RelativeLayout) lnl_category.getChildAt(0);
//                RelativeLayout rlt2 = (RelativeLayout) lnl_category.getChildAt(1);
//                RelativeLayout rlt = (RelativeLayout) lnl_category.getChildAt(i);
//                final TextView txt_category1 = (TextView) rlt1.findViewById(R.id.txt_category);
//                final  TextView txt_category2 = (TextView) rlt2.findViewById(R.id.txt_category);
//                //  final  TextView txt_category = (TextView) rlt.findViewById(R.id.txt_category);
//                final View view_category_selected1 = rlt1.findViewById(R.id.view_category_selected);
//                final View view_category_selected2 = rlt2.findViewById(R.id.view_category_selected);
//                txt_category1.setText(categories[0]);
//                txt_category2.setText(categories[1]);
//                txt_category1.setTextColor(rainbow[0]);
//                txt_category2.setTextColor(rainbow[1]);
//                final int category = i;
//                final int finalI = i;
//
//                rlt1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        if (view_category_selected1.getVisibility() == View.GONE) {{
//
//
//                            txt_category1.setTextColor(rainbow[0]);
//                            txt_category2.setTextColor(rainbow[1]);
//                            selectCategory(0, true);
//                        }}
//
//                    }
//                });
//                rlt2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        //Toast.makeText(mActivity, "ddd", Toast.LENGTH_SHORT).show();
//                        if (view_category_selected2.getVisibility() == View.VISIBLE){
//                            txt_category2.setTextColor(rainbow[0]);
//                            txt_category1.setTextColor(rainbow[1]);
//                            //  Toast.makeText(mActivity, "zczxvczxc", Toast.LENGTH_SHORT).show();
//                            selectCategory(1, true);
//                        }
//                        if (view_category_selected2.getVisibility() == View.GONE) {{
//
//                            txt_category2.setTextColor(rainbow[0]);
//                            txt_category1.setTextColor(rainbow[1]);
//                            // Toast.makeText(mActivity, "zczxvczxc", Toast.LENGTH_SHORT).show();
//                            selectCategory(1, true);
//                        }}
//                    }
//                });
//
//            }
//            lnl_category.getChildAt(0).post(new Runnable() {
//                @Override
//                public void run() {
//                    initRunner();
//                }
//            });
//        }
//        else {
//            rlt_fragment_root = (RelativeLayout) mRoot.findViewById(R.id.rlt_fragment_root);
//            rlt_home_category = (RelativeLayout) mRoot.findViewById(R.id.rlt_home_category);
//            lnl_category = (LinearLayout) mRoot.findViewById(R.id.lnl_category);
//            scr_category = (HorizontalScrollView) mRoot.findViewById(R.id.scr_category);
//            mViewRunner = (View) mRoot.findViewById(R.id.view_category_selected_run);
//            CategoryLineColor = (View) mRoot.findViewById(R.id.CategoryLineColor);
//            homeCategoryBackground = (View) mRoot.findViewById(R.id.homeCategoryBackground);
//
//            String[] categories = mActivity.getResources().getStringArray(R.array.timeline_category);
//            rainbow = mActivity.getResources().getIntArray(R.array.colors);
//            if (lnl_category.getChildCount() != categories.length) {
//                return; // check developer mistakes
//            } else {
//                // ignore
//            }
//            for (  int i = 0; i < lnl_category.getChildCount(); i++) {
//
//                RelativeLayout rlt1 = (RelativeLayout) lnl_category.getChildAt(0);
//                RelativeLayout rlt2 = (RelativeLayout) lnl_category.getChildAt(1);
//                RelativeLayout rlt = (RelativeLayout) lnl_category.getChildAt(i);
//                final  TextView txt_category1 = (TextView) rlt1.findViewById(R.id.txt_category);
//                final  TextView txt_category2 = (TextView) rlt2.findViewById(R.id.txt_category);
//                //  final  TextView txt_category = (TextView) rlt.findViewById(R.id.txt_category);
//                final View view_category_selected1 = rlt1.findViewById(R.id.view_category_selected);
//                final View view_category_selected2 = rlt2.findViewById(R.id.view_category_selected);
//                txt_category1.setText(categories[0]);
//                txt_category2.setText(categories[1]);
//                txt_category1.setTextColor(rainbow[1]);
//                txt_category2.setTextColor(rainbow[0]);
//                final int category = i;
//                final int finalI = i;
//                // rlt1.setClickable(false);
//                rlt1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        //Toast.makeText(mActivity, "Once you check-in, you will be able to use this function.", Toast.LENGTH_SHORT).show();
//                        if (view_category_selected1.getVisibility() == View.GONE) {{
//
//
//                            txt_category1.setTextColor(rainbow[0]);
//                            txt_category2.setTextColor(rainbow[1]);
//                            selectCategory(0, true);
//                        }}
//
//                    }
//                });
//                rlt2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        if (view_category_selected2.getVisibility() == View.GONE) {{
//
//                            txt_category2.setTextColor(rainbow[0]);
//                            txt_category1.setTextColor(rainbow[1]);
//                            selectCategory(1, true);
//                        }}
//                    }
//                });
//
//            }
//            lnl_category.getChildAt(0).post(new Runnable() {
//                @Override
//                public void run() {
//                    initRunner();
//                }
//            });
//        }
//
//    }
//
//
//    public void selectCategory(int category, boolean changeContentPager) {
//        for (int i = 0; i < lnl_category.getChildCount(); i++) {
//            RelativeLayout rlt = (RelativeLayout) lnl_category.getChildAt(i);
//            View view_category_selected = rlt.findViewById(R.id.view_category_selected);
//            view_category_selected.setVisibility(i == category ? View.VISIBLE : View.GONE);
//        }
//        if (changeContentPager) {
//            showFragment(category);
//        } else {
//            // ignore, case called from pager
//        }
//    }
//
//
//    //---------------FRAGMENT MANAGE-----------------
//
//    public void showFragment(int fragment) {
//        vpg_home.setCurrentItem(fragment);
//
//    }
//    private ViewPager vpg_home;
//    private HomePagerFragmentAdapter mPagerAdapter = null;
//
//    private void initPager() {
//        vpg_home = (ViewPager) mRoot.findViewById(R.id.vpg_home);
//        vpg_home.setOffscreenPageLimit(6);
//        mPagerAdapter = new HomePagerFragmentAdapter(getChildFragmentManager());
//
//        vpg_home.setAdapter(mPagerAdapter);
//        vpg_home.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                if (mArrCategoryWidthOffset.size() > 0) {
//                    if (position < mArrCategoryWidth.size() - 1) {
//                        int left = mArrCategoryWidthOffset.get(position) + (int) (mArrCategoryWidth.get(position) * positionOffset);
//
//                        int width = (int) Math.ceil((mArrCategoryWidth.get(position) * (1 - positionOffset))) + (int) Math.ceil((mArrCategoryWidth.get(position + 1) * positionOffset));
//                        setRunnerStateWidth(width, left);
//                    } else {
//                        // ignore
//                    }
//                } else {
//                    // ignore
//                }
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//                Log.e("onPageSelected", "-- " + position);
//                if (position == 2) {
//                    //  HomeControllerFragment.handler.sendMessage(new Message());
//
//                } else {
//                    correctSizeUtil.setWidthOriginal(750);
//                    correctSizeUtil.correctSize(mRoot);
//
//                }
//                selectCategory(position, false);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//                if (state == ViewPager.SCROLL_STATE_IDLE) {
//                //    ((BaseFragment) mPagerAdapter.getItem(vpg_home.getCurrentItem())).onFragmentSelected();
//                }
//            }
//        });
//    }
//
//    View mViewRunner = null;
//
//    private void initRunner() {
//        initOffsetState();
//
//        mViewRunner.post(new Runnable() {
//            @Override
//            public void run() {
//                int currentItem = vpg_home.getCurrentItem();
//                if (vpg_home.getCurrentItem() != 0) {
//                    int left = mArrCategoryWidthOffset.get(currentItem);
//
//                    int width = mArrCategoryWidth.get(currentItem);
//
//                    setRunnerStateWidth(width, left);
//                } else {
//                    // run at first onCreate()
//                    int width = lnl_category.getChildAt(0).getWidth();
//                    setRunnerStateWidth(width, 0); // start at zero
//                }
//            }
//        });
//    }
//
//    public HorizontalScrollView scr_category;
//
//    private void setRunnerStateWidth(int width, int left) {
//        int scrWidth = scr_category.getWidth();
//
//        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) mViewRunner.getLayoutParams();
//        lp.width = width;
//        lp.setMargins(left, 0, 0, 0);
//        mViewRunner.setLayoutParams(lp);
//        mViewRunner.invalidate();
//
//        if (width + left > scrWidth + scr_category.getScrollX()) {
//            scr_category.scrollTo(width + left - scrWidth, 0); // scroll content to left
//        }
//        if (left < scr_category.getScrollX()) {
//            scr_category.scrollTo(left, 0); // scroll content to right
//        }
//    }
//
//    private ArrayList<Integer> mArrCategoryWidthOffset = new ArrayList();
//    private ArrayList<Integer> mArrCategoryWidth = new ArrayList();
//
//    private void initOffsetState() {
//        mArrCategoryWidth.clear();
//        mArrCategoryWidthOffset.clear();
//        mArrCategoryWidthOffset.add(0); // first offset is zero
//        for (int i = 0; i < lnl_category.getChildCount(); i++) {
//            RelativeLayout rlt = (RelativeLayout) lnl_category.getChildAt(i);
//            int width = rlt.getWidth();
//
//            mArrCategoryWidth.add(width);
//            if (i == 0) {
//                mArrCategoryWidthOffset.add(width);
//            } else {
//                mArrCategoryWidthOffset.add(width + mArrCategoryWidthOffset.get(mArrCategoryWidthOffset.size() - 1));
//            }
//        }
//
//        if (mArrCategoryWidth.get(0) == 0) {
//            // case happen when :
//            /*
//            - open app
//            - change to other footer
//            - change to multi-screen mode
//            - back to HomeFragment
//            -// cause this not displayed, then getWidth return o :(
//             */
//
//            mArrCategoryWidth.clear();
//            mArrCategoryWidthOffset.clear();
//            mArrCategoryWidthOffset.add(0); // first offset is zero
//            for (int i = 0; i < lnl_category.getChildCount(); i++) {
//                RelativeLayout rlt = (RelativeLayout) lnl_category.getChildAt(i);
//
//                rlt.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
//                int width = rlt.getMeasuredWidth();
//
//                mArrCategoryWidth.add(width);
//                if (i == 0) {
//                    mArrCategoryWidthOffset.add(width);
//                } else {
//                    mArrCategoryWidthOffset.add(width + mArrCategoryWidthOffset.get(mArrCategoryWidthOffset.size() - 1));
//                }
//            }
//        } else {
//            // ignore
//        }
//    }

}
