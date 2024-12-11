 package com.example.api;

 import android.content.Intent;
 import android.os.Bundle;
 import android.util.Log;
 import android.widget.Adapter;
 import android.widget.Button;
 import android.widget.EditText;
 import android.widget.ListView;
 import android.widget.Toast;

 import androidx.activity.EdgeToEdge;
 import androidx.appcompat.app.AppCompatActivity;
 import androidx.core.graphics.Insets;
 import androidx.core.view.ViewCompat;
 import androidx.core.view.WindowInsetsCompat;

 import java.util.ArrayList;
 import java.util.List;

 public class MainActivity extends AppCompatActivity {

     private EditText name, category, price, count;
     private Button addButton;
     private ListView listView;
     private List<Telephones> itemList;
     private ListAdapter adapter;


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
         name = findViewById(R.id.Name);
         category = findViewById(R.id.Kategori);
         count = findViewById(R.id.Count);
         price = findViewById(R.id.Price);
         addButton = findViewById(R.id.addbutton);
         listView = findViewById(R.id.listView);
         itemList = new ArrayList<>();
         adapter = new ListAdapter(this, itemList);
         listView.setAdapter(adapter);

         listView.setOnItemLongClickListener((parent, view, position, id) -> {
             Telephones item = itemList.get(position);
             itemList.remove(position);
             adapter.notifyDataSetChanged();
             Toast.makeText(this, item.getName() + " deleted", Toast.LENGTH_SHORT).show();
             return true;
         });

         addButton.setOnClickListener( e -> {
             String nameToList = name.getText().toString();
             String CoutToList = count.getText().toString();
             String PriceToList = price.getText().toString();
             String categoryToList = category.getText().toString();

             if (nameToList.isEmpty() || categoryToList.isEmpty()) {
                 Toast.makeText(this, "Töltsd ki az összes bemenetet", Toast.LENGTH_SHORT).show();
                 return;
             }

             int countToList;
             int priceToList;
             try {
                 countToList = Integer.parseInt(CoutToList);
                 priceToList = Integer.parseInt(PriceToList);
             } catch (NumberFormatException ex) {
                 Toast.makeText(this, "Hibás számbemenet", Toast.LENGTH_SHORT).show();
                 return;
             }

             Telephones item = new Telephones(nameToList, countToList, priceToList, categoryToList);
             itemList.add(item);
             adapter.notifyDataSetChanged();

             name.setText("");
             price.setText("");
             count.setText("");
             category.setText("");
         });
     }
}