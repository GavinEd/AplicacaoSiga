package com.exemplo.gavin.msg;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Gavin on 09/05/2015.
 */
public class MensagemUtil {
    /**
     * Método de criação de mensagens rápidas.
     *
     * @param activity
     * @param msg
     */
    public static void addMsg(Activity activity, String msg) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * Método de criação de mensagens com botão "Ok"
     *
     * @param activity
     * @param titulo
     * @param msg
     * @param icone
     */
    public static void addMsgOk(Activity activity, String titulo, String msg, int icone) {
        AlertDialog.Builder builderDialog = new AlertDialog.Builder(activity);
        builderDialog.setTitle(titulo);
        builderDialog.setMessage(msg);
        builderDialog.setNeutralButton("Ok", null);
        builderDialog.setIcon(icone);
        builderDialog.show();
    }

    /**
     * Método para criação de uma mensagem de diálogo com opções de sim ou não
     *
     * @param activity
     * @param titulo
     * @param msg
     * @param icone
     * @param listener
     */
    public static void addMsgConfirm(Activity activity, String titulo,
                                     String msg, int icone, DialogInterface.OnClickListener listener) {
        AlertDialog.Builder builderDialog = new AlertDialog.Builder(activity);
        builderDialog.setTitle(titulo);
        builderDialog.setMessage(msg);
        builderDialog.setPositiveButton("Sim", listener);
        builderDialog.setNegativeButton("Não", null);
        builderDialog.setIcon(icone);
        builderDialog.show();
    }
}
