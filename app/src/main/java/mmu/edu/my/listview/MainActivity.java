package mmu.edu.my.listview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String []mTitle={"Gmail","Photo","Meet","Drive","Maps"};
    String []mDesc={"Give your feedback","Share your memories","Meet your lover","Share your folder","Visit your parents"};
    int []icons={R.drawable.gmail, R.drawable.photo, R.drawable.meet, R.drawable.drive, R.drawable.maps};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter(this, mTitle, mDesc, icons);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent,view,position,id)->{
            if (position==0)
                Toast.makeText(MainActivity.this,"Gmail was pressed", Toast.LENGTH_SHORT).show();
            else if (position==1)
                Toast.makeText(MainActivity.this,"Photo was pressed", Toast.LENGTH_SHORT).show();
            else if (position==2)
                Toast.makeText(MainActivity.this,"Meet was pressed", Toast.LENGTH_SHORT).show();
            else if (position==3)
                Toast.makeText(MainActivity.this,"Drive was pressed", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(MainActivity.this,"Maps was pressed", Toast.LENGTH_SHORT).show();
        });
    }
}

class MyAdapter extends ArrayAdapter<String> {
    Context context;
    String []rTitle;
    String []rDesc;
    int []rImgs;

    MyAdapter(Context c, String []title, String []Desc, int []imgs){
        super (c, R.layout.row, R.id.title, title);
        this.context=c;
        this.rTitle=title;
        this.rDesc=Desc;
        this.rImgs=imgs;
    }
    @NonNull
    @Override
    public View getView (int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater=(LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=layoutInflater.inflate(R.layout.row, parent, false);
        ImageView images=row.findViewById(R.id.images);
        TextView myTitle=row.findViewById(R.id.title);
        TextView myDesc=row.findViewById(R.id.desc);
        images.setImageResource(rImgs[position]);
        myTitle.setText(rTitle[position]);
        myDesc.setText(rDesc[position]);
        return row;
    }
}