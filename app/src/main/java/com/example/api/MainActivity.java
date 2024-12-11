 package com.example.api;

 import java.util.List;

 import android.os.Bundle;
 import android.widget.Button;
 import android.widget.EditText;
 import android.widget.LinearLayout;
 import android.widget.ListView;

 import androidx.activity.EdgeToEdge;
 import androidx.appcompat.app.AppCompatActivity;
 import androidx.core.graphics.Insets;
 import androidx.core.view.ViewCompat;
 import androidx.core.view.WindowInsetsCompat;

 import retrofit2.Call;
 import retrofit2.Callback;
 import retrofit2.Response;
 import retrofit2.Retrofit;

 public class MainActivity extends AppCompatActivity {

     private EditText firstNameEditText;
     private EditText lastNameEditText;
     private EditText emailEditText;
     private EditText phoneEditText;
     private EditText ageEditText;
     private Button cancelButton;
     private Button addButton;
     private Button showAddFormButton;
     private LinearLayout formLinearLayout;
     private ListView peopleListView;
     private List<Telephones> peopleList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initialize();
    }
     private void initialize(){
         name = findViewById(R.id.name);
         author = findViewById(R.id.author);
         page = findViewById(R.id.page);
         addButton = findViewById(R.id.addbutton);
         listView = findViewById(R.id.listView);
         itemList = new ArrayList<>();
         adapter = new MyAdapter(this, itemList);
         listView.setAdapter(adapter);

         listView.setOnItemClickListener((parent, view, position, id) -> {
             Konyv item = itemList.get(position);

             Intent intent = new Intent(MainActivity.this, ItemDetailActivity.class);

             intent.putExtra("itemName", item.getName());
             intent.putExtra("itemAuthor", item.getAuthor());
             intent.putExtra("itemPage", item.getPage());

             startActivity(intent);
         });

         addButton.setOnClickListener( e -> {
             String nameToList = name.getText().toString();
             String authorToList = author.getText().toString();
             String pageToList = page.getText().toString();

             if (nameToList.isEmpty() || authorToList.isEmpty()) {
                 Toast.makeText(this, "Töltsd ki az összes bemenetet", Toast.LENGTH_SHORT).show();
                 return;
             }

             int countToList;
             try {
                 countToList = Integer.parseInt(pageToList);
                 if(countToList < 50) {
                     Toast.makeText(this, "Az oldal legyen több mint 50", Toast.LENGTH_SHORT).show();
                     return;
                 }


             } catch (NumberFormatException ex) {
                 Toast.makeText(this, "Hibás számbemenet", Toast.LENGTH_SHORT).show();
                 return;
             }

             Konyv item = new Konyv(nameToList, authorToList, countToList);
             itemList.add(item);
             adapter.notifyDataSetChanged();

             name.setText("");
             author.setText("");
             page.setText("");
         });
     }
     public void deleteListElement(Konyv data){
         itemList.remove(data);
         adapter.notifyDataSetChanged();
     }
}