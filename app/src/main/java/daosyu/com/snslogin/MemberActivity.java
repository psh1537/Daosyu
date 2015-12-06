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
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.daosyu.mainview.MainViewActivity;
import com.daosyu.test.TestActivity;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by parksh on 2015-11-20.
 */
public class MemberActivity extends AppCompatActivity {
    Spinner spinner;
    ArrayAdapter adapter;
    EditText profile_intro, profile_name, profile_id, profile_pwd, profile_hobby;
    RadioGroup radioGroup;
    CircleImageView profile_image;
    final int REQ_CODE = 1;
    Bundle bundle;
    HashMap<String, String> profileHash = new HashMap<String, String>();


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


        adapter = ArrayAdapter.createFromResource(this, R.array.region, android.R.layout.simple_spinner_dropdown_item);

        String id = profile_id.getText().toString();
        String pwd = profile_pwd.getText().toString();
        String hobby = profile_hobby.getText().toString();
        String intro = profile_intro.getText().toString();

        profileHash.put("id", id);
        profileHash.put("pwd", pwd);
        profileHash.put("hobby", hobby);
        profileHash.put("intro", intro);



        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String regionName = spinner.getSelectedItem().toString();
                profileHash.put("regionName", regionName);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        radioGroup = (RadioGroup) findViewById(R.id.gender);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String genderText = (String) ((RadioButton) findViewById(checkedId)).getText();
                profileHash.put("genderText", genderText);

            }
        });


        bundle.putSerializable("profile", profileHash);
    }

    public void join(View view) {
        //버튼을 누르면 회원가입이 완료되고 메인뷰로 넘어간다.
        if (view.getId() == R.id.member_join) {
            Intent intent = new Intent(this, TestActivity.class);

            intent.putExtra("profile", bundle);
            startActivity(intent);
            //finish();
        }

        //간접 인텐트를 실행하여 유저가 선택한 사진을 업로드 한다.
        if (view.getId() == R.id.profie_picture) {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
            intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, REQ_CODE);
        }
    }
}
