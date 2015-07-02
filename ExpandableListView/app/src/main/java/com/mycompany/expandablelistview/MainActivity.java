package com.mycompany.expandablelistview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private MyAdapter adapter;
    private String[] groups={"法師","劍士","弓箭手","玩家"};
    private String[][] children={{"冰雷大魔島","祭司","火毒大魔島"},{"狂戰士","聖騎士","鬥士"},{"神射手","弩弓手","黃忠","射手"},{"player"}};
    private final Integer[][] pictures = {{R.drawable.apple},   {R.drawable.orange,R.drawable.tomato},  {R.drawable.lemon,R.drawable.peach,R.drawable.watermelon},{R.drawable.cheey,R.drawable.pineapple,R.drawable.pineapple,R.drawable.pineapple}};
    ExpandableListView lv;
    MyAdapter lvAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        adapter=new MyAdapter();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ExpandableListView listView = (ExpandableListView)findViewById(R.id.expandableListView);
        listView.setAdapter(adapter);
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {//子列表事件監聽器
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String childName = (String)adapter.getChild(groupPosition,childPosition).toString();
                Toast.makeText(MainActivity.this,"Click : "+childName+" item",Toast.LENGTH_LONG).show();// 目標,訊息內容,訊息格式
                return false;
            }
        });

    }
    class MyAdapter extends BaseExpandableListAdapter{
        @Override
        public int getGroupCount() {
            return groups.length;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return children[groupPosition].length;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return groups[groupPosition];
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return children[groupPosition][childPosition];
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            TextView textView = null;
            if(convertView==null){//有沒有舊的view可以使用
                textView = new TextView(MainActivity.this);
            }else{
                textView=(TextView)convertView;
            }
            textView.setText(groups[groupPosition]);
            textView.setTextSize(30);
            textView.setPadding(50,10,0,10);//左 上 右 下
            return textView;

        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            TextView textView = null;
            if(convertView==null){
                textView = new TextView(MainActivity.this);
            }else{
                textView=(TextView)convertView;
            }
            textView.setText(children[groupPosition][childPosition]);
            textView.setTextSize(20);
            textView.setPadding(72,10,0,10);
            return textView;

        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return false;
        }
        //實作方法後幾頁解釋
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
