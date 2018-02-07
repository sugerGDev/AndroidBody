package fujiannormaluniversity.edu.androidbody;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.inputmethod.EditorInfo;
import fujiannormaluniversity.edu.androidbody.classes.login.view.LoginTextField;

public class MainActivity extends AppCompatActivity {

    private LoginTextField register_phone_inputWidget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onLoadView();
        onSetProperty();
    }

    private void onLoadView() {
       register_phone_inputWidget = (LoginTextField)findViewById(R.id.register_phone_inputWidget);
    }

    private void onSetProperty() {

        int inputType = InputType.TYPE_CLASS_PHONE;
        int imeOptions = EditorInfo.IME_ACTION_NEXT;

        register_phone_inputWidget.setEditTextKeyboardType(inputType,imeOptions);

    }
}
