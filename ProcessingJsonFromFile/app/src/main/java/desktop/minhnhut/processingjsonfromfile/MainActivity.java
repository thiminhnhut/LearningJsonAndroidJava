package desktop.minhnhut.processingjsonfromfile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import desktop.minhnhut.model.Company;
import desktop.minhnhut.model.ReadJSON;

public class MainActivity extends AppCompatActivity {

    private TextView outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputText = this.findViewById(R.id.txtView);
    }

    public void runExample(View view) {
        try {
            Company company = ReadJSON.readCompanyJSONFile(this);
            outputText.setText(company.toString());
        } catch(Exception e)  {
            outputText.setText(e.getMessage());
            e.printStackTrace();
        }
    }
}
