package ru.leonov.instagramClient;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;

import ru.leonov.instagramClient.R;

public class HomeFragment extends Fragment {

    private EditText etName;
    private EditText etMail;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
    }

    private void initView(View view) {
        final View fView = view;
        MaterialButton btnEnter = view.findViewById(R.id.btnEnter);
        etName = view.findViewById(R.id.tiName);
        etMail = view.findViewById(R.id.tiEmail);

        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etName.getText().toString().equals("") || etMail.getText().toString().equals("")) {
                    Snackbar mSnackbar = Snackbar.make(fView, "Поля не могут быть пустыми!", Snackbar.LENGTH_INDEFINITE);
                    mSnackbar.setAction("Понятно", snackBarOnClickListener);
                    mSnackbar.show();
                }
                else {
                    Snackbar.make(fView, "Вы зарегистрированы!", Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }

    private View.OnClickListener snackBarOnClickListener = new View.OnClickListener() {
        @Override public void onClick(View view) {
            if (etName.getText().toString().equals("")) {
                etName.requestFocus();
            }
            else if (etMail.getText().toString().equals("")) {
                etMail.requestFocus();
            }
        }
    };

}