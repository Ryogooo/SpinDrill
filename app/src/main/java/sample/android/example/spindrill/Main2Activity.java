package sample.android.example.spindrill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        final double kotae = this.getIntent().getDoubleExtra("kaitou",0);


        Button answer = (Button)findViewById(R.id.answer);
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText2 = (EditText)findViewById(R.id.editText2);
                String okuri2 = editText2.getText().toString();

                double okuriid2 = Double.parseDouble(okuri2);
                /*
                EditText editText = (EditText)findViewById(R.id.editText);
                editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                String okuri = editText.getText().toString();
                int okuriid = Integer.parseInt(okuri);

                 */

                // double kaitou = okuriid * kotae;
                double kaitou = okuriid2 * kotae;

                 String hyouji = String.valueOf(kaitou);

                 TextView textView = (TextView)findViewById(R.id.textView13);
                 textView.setText(hyouji);

                 TextView ans = (TextView)findViewById(R.id.ans);
                 ans.setText("Sは" + kotae);
                 TextView ans2 = (TextView)findViewById(R.id.ans2);
                 ans2.setText("Fは" + kaitou);

            }
        });


    }
}
