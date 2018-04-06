package com.example.android.timetabledemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.timetabledemo.Utils.LetterImageView;

import org.w3c.dom.Text;

public class Subject_Day extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;
    public static SharedPreferences sharedPreferences;
    public static String SEL_DAY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject__day);

        setupUIViews();
        initToolbar();

        setupListView();
    }

    private void setupUIViews(){
        toolbar = (Toolbar)findViewById(R.id.ToolbarWeek);
        listView = (ListView)findViewById(R.id.lvWeek);
        sharedPreferences = getSharedPreferences("MY_DAY", MODE_PRIVATE);
    }
    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Subjects");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupListView(){
        String[] week = getResources().getStringArray(R.array.sub_name);

        WeekAdapter adapter = new WeekAdapter(this, R.layout.activity_subject_single_item, week);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0: {
                        Toast.makeText(getApplicationContext() , "You clicked Subject 1" , Toast.LENGTH_LONG).show();
                        break;
                    }
                    case 1: {
                        Toast.makeText(getApplicationContext() , "You clicked Subject 2" , Toast.LENGTH_LONG).show();
                        break;
                    }
                    case 2: {
                        Toast.makeText(getApplicationContext() , "You clicked Subject 3" , Toast.LENGTH_LONG).show();
                        break;
                    }
                    case 3: {
                        Toast.makeText(getApplicationContext() , "You clicked Subject 4" , Toast.LENGTH_LONG).show();
                        break;
                    }
                    case 4: {
                        Toast.makeText(getApplicationContext() , "You clicked Subject 5" , Toast.LENGTH_LONG).show();
                        break;
                    }
                    case 5: {
                        Toast.makeText(getApplicationContext() , "You clicked Subject 6" , Toast.LENGTH_LONG).show();
                        break;
                    }
                    case 6: {
                        Toast.makeText(getApplicationContext() , "You clicked Subject 7" , Toast.LENGTH_LONG).show();
                        break;
                    }
                    case 7: {
                        Toast.makeText(getApplicationContext() , "You clicked Subject 8" , Toast.LENGTH_LONG).show();
                        break;
                    }
                    case 8: {
                        Toast.makeText(getApplicationContext() , "You clicked Subject 9" , Toast.LENGTH_LONG).show();
                        break;
                    }
                    default:break;
                }
            }
        });

    }

    public class WeekAdapter extends ArrayAdapter{

        private int resource;
        private LayoutInflater layoutInflater;
        private String[] week = new String[]{};

        public WeekAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
            this.resource = resource;
            this.week = objects;
            layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder;
            if(convertView == null){
                holder = new ViewHolder();
                convertView = layoutInflater.inflate(resource, null);
                holder.ivLogo = (LetterImageView)convertView.findViewById(R.id.ivLetter);
                holder.tvWeek = (TextView)convertView.findViewById(R.id.tvMain);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder)convertView.getTag();
            }

            holder.ivLogo.setOval(true);
            holder.ivLogo.setLetter(week[position].charAt(0));
            holder.tvWeek.setText(week[position]);

            return convertView;
        }

        class ViewHolder{
            private LetterImageView ivLogo;
            private TextView tvWeek;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home : {
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
