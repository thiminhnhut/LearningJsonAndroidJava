package desktop.minhnhut.demoreaddatajsonfromfile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;

import desktop.minhnhut.model.ACConfig;
import desktop.minhnhut.model.ACDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnBrandModel = findViewById(R.id.btnBrandModel);

        btnBrandModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Click Brand Model", Toast.LENGTH_SHORT).show();
                try {
                    ACDatabase acDatabase = new ACDatabase(getApplicationContext(), R.raw.database);
                    System.out.println(acDatabase.getListKeyDatabase().toString());
                    System.out.println(acDatabase.getListKeyBrandModel().toString());
                    System.out.println(acDatabase.getListKeyRemoteConfig().toString());
                    System.out.println(acDatabase.getHashMapBrandModel().toString());
                    System.out.println(acDatabase.getHashMapBrandModel().toString());
                    System.out.println(acDatabase.getRemoteConfig(2).toString());
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
