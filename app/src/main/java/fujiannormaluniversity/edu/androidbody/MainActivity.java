package fujiannormaluniversity.edu.androidbody;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
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
//        register_phone_inputWidget = (LoginTextField)findViewById(R.id.register_phone_inputWidget);
    }

    private void onSetProperty() {

//        int inputType = InputType.TYPE_CLASS_PHONE;
//        register_phone_inputWidget.getEditText().setInputType(inputType);
//
//        int imeOptions = EditorInfo.IME_ACTION_NEXT;
//        register_phone_inputWidget.getEditText().setImeOptions(imeOptions);
    }
}
