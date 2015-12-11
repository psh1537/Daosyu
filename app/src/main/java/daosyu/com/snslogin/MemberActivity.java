package daosyu.com.snslogin;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.daosyu.mainview.MainViewActivity;
import com.daosyu.test.TestActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

/*
 * Created by parksh on 2015-11-20.
 *
 */
public class MemberActivity extends AppCompatActivity {
    HttpURLConnection conn;
    InputStream is;
    String URL = "http://70.12.109.73:9090/";
    java.net.URL url;

    Spinner spinner;
    ArrayAdapter adapter;
    EditText profile_intro, profile_name, profile_id, profile_pwd, profile_hobby;
    Button memberJoin;
    RadioGroup radioGroup;
    CircleImageView profile_image;
    Bundle bundle;

    //키 값을 정하기 위한 final
    final int REQ_CODE = 1;
    final String USER_ID = "id";
    final String USER_PWD = "pwd";
    final String USER_NAME = "name";
    final String USER_HOBBY = "hobby";
    final String USER_INTRO = "intro";
    final String USER_REGION = "regionName";
    final String USER_GENDER = "genderText";

    String id, pwd, name, hobby, intro, regionName, genderText;
    String face_id, face_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_layout);

        bundle = new Bundle();


        spinner = (Spinner) findViewById(R.id.profile_region);
        profile_intro = (EditText) findViewById(R.id.profile_intro);
        profile_name = (EditText) findViewById(R.id.profile_name);
        profile_id = (EditText) findViewById(R.id.profile_id);
        profile_pwd = (EditText) findViewById(R.id.profile_pwd);
        profile_hobby = (EditText) findViewById(R.id.profile_hobby);
        profile_image = (CircleImageView) findViewById(R.id.profile_image);
        memberJoin = (Button) findViewById(R.id.memberJoin);


        adapter = ArrayAdapter.createFromResource(this, R.array.region, android.R.layout.simple_spinner_dropdown_item);


        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                regionName = spinner.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        radioGroup = (RadioGroup) findViewById(R.id.gender);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                genderText = (String) ((RadioButton) findViewById(checkedId)).getText();


            }
        });



    }

    public void join(View view) {
        //버튼을 누르면 회원가입이 완료되고 메인뷰로 넘어간다.
        if (view.getId() == R.id.memberJoin) {
            id = profile_id.getText().toString();
            pwd = profile_pwd.getText().toString();
            name = profile_name.getText().toString();
            hobby = profile_hobby.getText().toString();
            intro = profile_intro.getText().toString();

            if (id.length() == 0 || pwd.length() == 0 || name.length() == 0 || hobby.length() == 0 || intro.length() == 0) {
                Toast.makeText(getApplicationContext(), "빈칸을 채워 주십시오", Toast.LENGTH_SHORT).show();

            } else {
                Intent intent = new Intent(this, MainViewActivity.class);
                startActivity(intent);
                finish();
            }


        }

        //간접 인텐트를 실행하여 유저가 선택한 사진을 업로드 한다.
        if (view.getId() == R.id.profie_picture) {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
            intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, REQ_CODE);
        }

        //아이디 중복 검사
        if (view.getId() == R.id.checkId) {

        }
    }


}
