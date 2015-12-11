package daosyu.com.snslogin;

import android.app.ActionBar;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {
    LoginButton loginButton;
    CallbackManager callbackManager;
    FacebookCallback<LoginResult> facebookCallback;
    TextView textView;
    Profile profile;
    AccessToken accessToken;
    Button member_button;

    final String FACE_NAME = "name";
    final String FACE_ID = "id";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_main);



        textView = (TextView)findViewById(R.id.msg);

        loginButton = (LoginButton)findViewById(R.id.login_button);
        loginButton.setReadPermissions("user_friends");  //facebook button과 관련된 상태에 따라서 자동적으로 내부에서 부터 불러오는 인터페이스...
        member_button = (Button)findViewById(R.id.member_button);


        //콜백 매니저 인스턴스 생성
        callbackManager = CallbackManager.Factory.create();

        //facebookCallback 메서드 재정의
        facebookCallback = new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                //textView.setText("로그인 성공하였습니다!!");

                accessToken = loginResult.getAccessToken();
                profile = Profile.getCurrentProfile();

                if(profile != null) {
                    String name = profile.getName();
                    String id = profile.getId();

                    Intent intent = new Intent(getApplicationContext(), MemberActivity.class);
                    intent.putExtra(FACE_NAME, name);
                    intent.putExtra(FACE_ID, id);
                    startActivity(intent);

                }
            }

            @Override
            public void onCancel() {
                textView.setText("로그아웃 하셨습니다!");
            }

            @Override
            public void onError(FacebookException error) {

            }
        };

        //button과 callback 객체간의 연결
        loginButton.registerCallback(callbackManager, facebookCallback);
    }

    //key hash 얻어오기!!
    //실제 어플리케이션 실행시엔 필요없고 최초에 등록용으로만 사용할 것이다.
    public void getKeyHash(){
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "daosyu.com.snslogin",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public void join(View view){
        //회원가입 폼으로 이동한뒤 액티비티를 끝낸다.
        if(view.getId() == R.id.member_button){
            Intent intent = new Intent(this, MemberActivity.class);
            startActivity(intent);
            finish();
        }
    }

}
