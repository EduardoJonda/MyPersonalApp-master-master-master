package tecsup.teoria04.eduardo.jonda.com.mypersonalapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class Main2ActivityConfig extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_config);

        listView =(ListView)findViewById(R.array.s1);
    }
}
