package com.example.cuc.personasmaterial;

import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by CUC on 20/05/2017.
 */

public abstract class TextWatcherPersonalizado implements TextWatcher {
    private TextInputLayout icaja;
    private String textoError;

    public TextWatcherPersonalizado(TextInputLayout icaja, String textoError) {
        this.icaja = icaja;
        this.textoError = textoError;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if(estaVacio(s)) icaja.setError(textoError);
        else if(icaja.isErrorEnabled()){
            icaja.setError(null);
        }
    }

    public abstract boolean estaVacio(Editable s);
}
