package ru.leonov.instagramClient;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

public class HomeFragment extends Fragment {

    private EditText etName;
    private EditText etMail;
    private MaterialButton btnEnter;
    private MaterialButton btnExit;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
        initEnterButtonClick(view);
        initCloseButtonClick();
    }

    private void initView(View view) {
        btnEnter = view.findViewById(R.id.btnEnter);
        etName = view.findViewById(R.id.tiName);
        etMail = view.findViewById(R.id.tiEmail);
        btnExit = view.findViewById(R.id.btnExit);
    }

    private void initEnterButtonClick(View view) {
        final View fView = view;
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

    private void initCloseButtonClick() {
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Objects.requireNonNull(getActivity()).finish();
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