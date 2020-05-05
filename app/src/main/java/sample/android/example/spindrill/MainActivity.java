package sample.android.example.spindrill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.MathContext;

public class MainActivity extends AppCompatActivity {

    EditText cutspeed;
    EditText diameter;
    TextView result;
    Button spinbutton;
    private boolean kotae;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView spindrill = (TextView)findViewById(R.id.textView3);

        String spin = "<u>切削速度(m/min)×1000</u>";
        spindrill.setText(Html.fromHtml(spin));

        cutspeed = (EditText) findViewById(R.id.cutspeed);
        diameter = (EditText)findViewById(R.id.diameter);
        result = (TextView)findViewById(R.id.result);
        spinbutton = (Button)findViewById(R.id.spinbutton);


        //spinbutton(回転数は)を押したときの処理
        spinbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //EditTextに何も入力されていない時の処理
                boolean isValid = true;

                if (cutspeed.length() == 0){
                    //EditTextにエラーを表示する
                    cutspeed.setError("切削速度を入力してください");
                    isValid =false;
                }

                if (diameter.getText().toString().isEmpty()){
                    //EditTextにエラーを表示する
                    diameter.setError("リーマ径を入力して下さい");
                    isValid = false;
                }

                //値が入力されているときの処理
                if (isValid) {
                    String cutspeedid = cutspeed.getText().toString();
                    String diameterid = diameter.getText().toString();

                    int cutid = Integer.parseInt(cutspeedid);
                    int diaid = Integer.parseInt(diameterid);
                    double kotae = Math.floor((cutid * 1000) / (3.14 * diaid));

                    String kotaewa = String.valueOf(kotae);

                    result.setText(kotaewa);

                }

            }
        });

        //buttonを押したときの処理
        final Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
           // private boolean kotae;

            @Override
            public void onClick(View v) {

                    String cutspeedid = cutspeed.getText().toString();
                    String diameterid = diameter.getText().toString();

                    int cutid = Integer.parseInt(cutspeedid);
                    int diaid = Integer.parseInt(diameterid);
                    double kotae = Math.floor((cutid * 1000) / (3.14 * diaid));


                    //画面遷移処理
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);

                    intent.putExtra("kaitou", kotae);
                    // intent.putExtra("kaitenn",);
                    startActivity(intent);

            }
        });

    }
}
