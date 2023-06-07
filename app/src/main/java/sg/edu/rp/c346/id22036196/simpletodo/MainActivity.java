package sg.edu.rp.c346.id22036196.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etElement;
    Button btnAdd;
    Button btnClear;
    Button btnDelete;
    ListView lvTasks;
    Spinner spnAddRem;

    ArrayList<String>alTasks;
    ArrayAdapter<String>adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement=findViewById(R.id.editTextTask);
        btnAdd=findViewById(R.id.buttonAdd);
        btnClear=findViewById(R.id.buttonClear);
        btnDelete=findViewById(R.id.buttonDelete);
        lvTasks=findViewById(R.id.listViewTasks);
        spnAddRem=findViewById(R.id.spinner);

        alTasks=new ArrayList<>();
        ArrayAdapter adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,alTasks);

        lvTasks.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task=etElement.getText().toString();
                alTasks.add(task);
                adapter.notifyDataSetChanged();
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colourName=etElement.getText().toString();
                alTasks.clear();
                adapter.notifyDataSetChanged();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colourName=etElement.getText().toString();
                int pos=Integer.parseInt(etElement.getText().toString());
                alTasks.remove(pos);
                adapter.notifyDataSetChanged();
            }
        });
        spnAddRem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        etElement.setHint("Type in new task here");
                        btnDelete.setEnabled(false);
                        btnAdd.setEnabled(true);
                        break;
                    case 1:
                        etElement.setHint("Type in the index of the task to be removed");
                        btnAdd.setEnabled(false);
                        btnDelete.setEnabled(true);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}