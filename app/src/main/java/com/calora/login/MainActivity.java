package com.calora.login;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	final public String sGameActivity = "com.dts.freefireth.FFMainActivity";
    Prefs prefs;

    // Vendedores
    // deixe em branco, caso nao queira nada

    private native String Grupo();
    private native String LinkGrupo();
    public native String team();

    private String vendedor1 = "Calora";
    private String vendedor2 = "MrZxRX";
    private String vendedor3 = "Seller 03";
    private String vendedor4 = "Seller 04";
    private String vendedor5 = "Seller 05";
    private String vendedor6 = "Seller 06";
    private String vendedor7 = "Seller 07";


    private String link1 = "https://t.me/xychaann";
    private String link2 = "https://t.me/Verylazyhaha";
    private String link3 = "https://t.me/seller03";
    private String link4 = "https://t.me/seller04";
    private String link5 = "https://t.me/seller05";
    private String link6 = "https://t.me/seller06";
    private String link7 = "https://t.me/seller07";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.loadLibrary("SecurityCalora");
        if(!checkVPN(this)) {
            Init();
        } else {
            Toast.makeText(MainActivity.this, "no vpn", Toast.LENGTH_LONG).show();
        }
    }

    public void Init() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setCancelable(false);
        alert.setView(revendedores());
        alert.setTitle("Alert! Don't Fall For Scams!!!");
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Login();
                }
            });
        alert.create().show();

    }

    public static boolean checkVPN(Context c) {
        ConnectivityManager cm = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getNetworkInfo(ConnectivityManager.TYPE_VPN).isConnectedOrConnecting();
    }

    public void Login() {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setCancelable(false);
		// getWindow().setFlags(8192, 8192);
        alert.setView(dialog_login_nexus());
        alert.create().show();
    }

    public static GradientDrawable botoes(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(5, Color.parseColor("#05DDFF"));
        gradientDrawable.setCornerRadius(TypedValue.applyDimension(1, 5.0f, context.getResources().getDisplayMetrics()));
        return gradientDrawable;
    }

    private View dialog_login_nexus() {
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setBackgroundColor(Color.parseColor("#292828"));
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dp(40), dp(40));
        layoutParams.gravity = 5;
        Button button = new Button(this);
        button.setTag("btnFechar");
        button.setLayoutParams(layoutParams);
        button.setText("X");
        String str = "#05DDFF";
        button.setBackgroundColor(Color.parseColor(str));
        String str2 = "#ffffff";
        button.setTextColor(Color.parseColor(str2));
        button.setTypeface(null, 1);
        button.setTextSize(2, 20.0f);
        button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finishAffinity();
                }
            });
        TextView textView = new TextView(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        textView.setLayoutParams(layoutParams2);
        textView.setText(team());
        textView.setTextSize(2, 20.0f);
        textView.setTypeface(null, 1);
        textView.setTextColor(Color.parseColor(str));
        final EditText editText = new EditText(this);
        editText.setTag("edtUsuario");
        editText.setHint("Usuário");
        editText.setTextColor(Color.parseColor(str2));
        editText.setHintTextColor(Color.parseColor(str2));
        layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMarginStart(dp(8));
        layoutParams2.topMargin = dp(16);
        layoutParams2.setMarginEnd(dp(8));
        editText.setLayoutParams(layoutParams2);
        final EditText editText2 = new EditText(this);
        editText2.setTag("edtSenha");
        editText2.setHint("Senha");
        editText2.setTextColor(Color.parseColor(str2));
        editText2.setHintTextColor(Color.parseColor(str2));
        layoutParams2.setMarginStart(dp(8));
        layoutParams2.topMargin = dp(16);
        layoutParams2.setMarginEnd(dp(8));
        editText2.setLayoutParams(layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.weight = 1.0f;
        linearLayout2.setLayoutParams(layoutParams3);
        CheckBox checkBox = new CheckBox(this);
        checkBox.setTag("cbLembrar");
        layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(dp(8), dp(8), 0, dp(8));
        checkBox.setLayoutParams(layoutParams2);
        checkBox.setText("Lembrar");
        checkBox.setTextColor(Color.parseColor(str));
        if( prefs.with(MainActivity.this).read("save").equals("1")) {
            editText.setText( prefs.with(MainActivity.this).read("USER_Sv"));
            editText2.setText( prefs.with(MainActivity.this).read("PASS_Sv"));
            checkBox.setChecked(true);
        } else {
            checkBox.setChecked(false);
        }
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        editText.setText( prefs.with(MainActivity.this).read("USER_Sv"));
                        editText2.setText( prefs.with(MainActivity.this).read("PASS_Sv"));
                        prefs.with(MainActivity.this).write("save", "1");

                    } else {
                        editText.setText("");
                        editText2.setText("");
                        prefs.with(MainActivity.this).write("save", "0");

                    }
                }
            });
        linearLayout2.addView(checkBox);
        LinearLayout linearLayout3 = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.weight = 1.0f;
        linearLayout3.setLayoutParams(layoutParams4);
        linearLayout3.setOrientation(1);
        Button button2 = new Button(this);
        button2.setTag("btnEntrar");
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, dp(40));
        layoutParams5.gravity = 5;
        layoutParams5.weight = 1.0f;
        layoutParams5.topMargin = dp(8);
        layoutParams5.rightMargin = dp(8);
        layoutParams5.bottomMargin = dp(8);
        button2.setLayoutParams(layoutParams5);
        button2.setText("Entrar");
        button2.setTextColor(Color.parseColor(str));
        button2.setTextSize(2, 12.0f);
        button2.setBackground(botoes(this));
        button2.setTypeface(null, Typeface.MONOSPACE.getStyle());
        button2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    String user = editText.getText().toString().trim();
                    String pass = editText2.getText().toString().trim();
                    prefs.with(MainActivity.this).write("USER_Sv", user);
                    prefs.with(MainActivity.this).write("PASS_Sv", pass);

					new Auth(MainActivity.this).execute(new String[]{user, pass});

                }
            });
        linearLayout3.addView(button2);
        linearLayout.addView(button);
        linearLayout.addView(textView);
        linearLayout.addView(editText);
        linearLayout.addView(editText2);
        linearLayout.addView(linearLayout2);
        linearLayout.addView(linearLayout3);
        linearLayout3 = new LinearLayout(this);
        linearLayout3.setTag("ll_progress");
        layoutParams4 = new LinearLayout.LayoutParams(-1, -1);
        linearLayout3.setVisibility(8);
        linearLayout3.setBackgroundColor(Color.parseColor("#99FFFFFF"));
        linearLayout3.setOrientation(1);
        linearLayout3.setGravity(17);
        linearLayout3.setClickable(true);
        linearLayout3.setLayoutParams(layoutParams4);
        ProgressBar progressBar = new ProgressBar(this);
        progressBar.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout3.addView(progressBar);
        frameLayout.addView(linearLayout);
        frameLayout.addView(linearLayout3);
        return frameLayout;
    }

    private View revendedores() {
        ScrollView scrollView = new ScrollView(this);
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(dp(15), dp(15), dp(15), dp(15));
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setVerticalScrollBarEnabled(true);
        linearLayout.setHorizontalScrollBarEnabled(true);
        linearLayout.setGravity(1);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = dp(10);
        textView.setLayoutParams(layoutParams2);
        textView.setTypeface(null, 1);
        textView.setText("OFFICIAL OWNERS AND SELLERS");
        TextView textView2 = new TextView(this);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = dp(10);
        textView2.setLayoutParams(layoutParams3);
        textView2.setText(Grupo());
        TextView textView3 = new TextView(this);
        textView3.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView3.setText(LinkGrupo());
        textView3.setClickable(true);
        textView3.setTag("Canal");
        textView3.setLinksClickable(true);
        String str = "#48929d";
        textView3.setTextColor(Color.parseColor(str));
        TextView textView4 = new TextView(this);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = dp(5);
        textView4.setLayoutParams(layoutParams4);
        textView4.setText("click on the number to contact:)");
        TextView textView5 = new TextView(this);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.topMargin = dp(10);
        textView5.setLayoutParams(layoutParams5);
        textView5.setText(vendedor1);
        TextView textView6 = new TextView(this);
        textView6.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView6.setText(link1);
        textView6.setClickable(true);
        textView6.setTag("Vendedor1");
        textView6.setLinksClickable(true);
        textView6.setTextColor(Color.parseColor(str));
        TextView textView7 = new TextView(this);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.topMargin = dp(10);
        textView7.setLayoutParams(layoutParams6);
        textView7.setText(vendedor2);
        TextView textView8 = new TextView(this);
        textView8.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView8.setText(link2);
        textView8.setClickable(true);
        textView8.setTag("Vendedor2");
        textView8.setLinksClickable(true);
        textView8.setTextColor(Color.parseColor(str));
        TextView textView9 = new TextView(this);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams7.topMargin = dp(10);
        textView9.setLayoutParams(layoutParams7);
        textView9.setText("MADAME MODZ");
        TextView textView10 = new TextView(this);
        textView10.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView10.setText("wa.me/5565999524152");
        textView10.setClickable(true);
        textView10.setTag("00");
        textView10.setLinksClickable(true);
        textView10.setTextColor(Color.parseColor(str));
        TextView textView11 = new TextView(this);
        ScrollView scrollView2 = scrollView;
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        textView11.setLayoutParams(layoutParams8);
        textView11.setText("instagram.com/madamemodz");
        textView11.setClickable(true);
        textView11.setTag("000");
        textView11.setLinksClickable(true);
        textView11.setTextColor(Color.parseColor(str));
        TextView textView12 = new TextView(this);
        View view2 = textView11;
        layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        View view3 = textView9;
        layoutParams7.topMargin = dp(10);
        textView12.setLayoutParams(layoutParams7);
        textView12.setText("MT MONSTER");
        textView10 = new TextView(this);
        textView10.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView10.setText("wa.me/5519981876678");
        textView10.setClickable(true);
        textView10.setTag("0000");
        textView10.setLinksClickable(true);
        textView10.setTextColor(Color.parseColor(str));
        textView9 = new TextView(this);
        View view4 = textView10;
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        textView9.setLayoutParams(layoutParams8);
        textView9.setText("instagram.com/mtmonsteryt");
        textView9.setClickable(true);
        textView9.setTag("00000");
        textView9.setLinksClickable(true);
        textView9.setTextColor(Color.parseColor(str));
        textView10 = new TextView(this);
        layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        View view5 = textView9;
        layoutParams8.topMargin = dp(10);
        textView10.setLayoutParams(layoutParams8);
        textView10.setText("OMARGZ");
        TextView textView13 = new TextView(this);
        textView13.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView13.setText("instagram.com/omargzfreefire");
        textView13.setClickable(true);
        textView13.setTag("1");
        textView13.setLinksClickable(true);
        textView13.setTextColor(Color.parseColor(str));
        textView9 = new TextView(this);
        View view6 = textView13;
        textView9.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView9.setText("wa.me/526871977830");
        textView9.setClickable(true);
        textView9.setTag("2");
        textView9.setLinksClickable(true);
        textView9.setTextColor(Color.parseColor(str));
        textView13 = new TextView(this);
        View view7 = textView9;
        layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        View view8 = textView10;
        layoutParams9.topMargin = dp(10);
        textView13.setLayoutParams(layoutParams9);
        textView13.setText("ARSAD (ÍNDIA)");
        textView10 = new TextView(this);
        textView10.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView10.setText("3.com/vipmodsseller");
        textView10.setClickable(true);
        textView10.setTag("3");
        textView10.setLinksClickable(true);
        textView10.setTextColor(Color.parseColor(str));
        textView9 = new TextView(this);
        View view9 = textView10;
        textView9.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView9.setText("wa.me/917074813693");
        textView9.setClickable(true);
        textView9.setTag("4");
        textView9.setLinksClickable(true);
        textView9.setTextColor(Color.parseColor(str));
        textView10 = new TextView(this);
        View view10 = textView9;
        layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        View view11 = textView13;
        layoutParams9.topMargin = dp(10);
        textView10.setLayoutParams(layoutParams9);
        textView10.setText(vendedor3);
        textView13 = new TextView(this);
        textView13.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView13.setText(link3);
        textView13.setClickable(true);
        textView13.setTag("Vendedor3");
        textView13.setLinksClickable(true);
        textView13.setTextColor(Color.parseColor(str));
        textView11 = new TextView(this);
        View view12 = textView13;
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        View view13 = textView10;
        layoutParams10.topMargin = dp(10);
        textView11.setLayoutParams(layoutParams10);
        textView11.setText(vendedor4);
        textView10 = new TextView(this);
        textView10.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView10.setText(link4);
        textView10.setClickable(true);
        textView10.setTag("Vendedor4");
        textView10.setLinksClickable(true);
        textView10.setTextColor(Color.parseColor(str));
        textView13 = new TextView(this);
        View view14 = textView10;
        layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        View view15 = textView11;
        layoutParams10.topMargin = dp(10);
        textView13.setLayoutParams(layoutParams10);
        textView13.setText(vendedor5);
        textView10 = new TextView(this);
        textView10.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView10.setText(link5);
        textView10.setClickable(true);
        textView10.setTag("Vendedor5");
        textView10.setLinksClickable(true);
        textView10.setTextColor(Color.parseColor(str));
        textView11 = new TextView(this);
        View view16 = textView10;
        layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        View view17 = textView13;
        layoutParams10.topMargin = dp(10);
        textView11.setLayoutParams(layoutParams10);
        textView11.setText("KUSHINA MODZ");
        textView10 = new TextView(this);
        textView10.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView10.setText("wa.me/556798589963");
        textView10.setClickable(true);
        textView10.setTag("000asds");
        textView10.setLinksClickable(true);
        textView10.setTextColor(Color.parseColor(str));
        textView9 = new TextView(this);
        View view18 = textView10;
        textView9.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView9.setText("instagram.com/kushinamodz/");
        textView9.setClickable(true);
        textView9.setTag("223");
        textView9.setLinksClickable(true);
        textView9.setTextColor(Color.parseColor(str));
        textView10 = new TextView(this);
        View view19 = textView9;
        layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        View view20 = textView11;
        layoutParams8.topMargin = dp(10);
        textView10.setLayoutParams(layoutParams8);
        textView10.setText(vendedor6);
        textView13 = new TextView(this);
        textView13.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView13.setText(link6);
        textView13.setClickable(true);
        textView13.setTag("Vendedor6");
        textView13.setLinksClickable(true);
        textView13.setTextColor(Color.parseColor(str));
        textView11 = new TextView(this);
        View view21 = textView13;
        layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        View view22 = textView10;
        layoutParams10.topMargin = dp(10);
        textView11.setLayoutParams(layoutParams10);
        textView11.setText(vendedor7);
        textView10 = new TextView(this);
        textView10.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView10.setText(link7);
        textView10.setClickable(true);
        textView10.setTag("Vendedor7");
        textView10.setLinksClickable(true);
        textView10.setTextColor(Color.parseColor(str));
        textView13 = new TextView(this);
        View view23 = textView10;
        layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        View view24 = textView11;
        layoutParams10.topMargin = dp(10);
        textView13.setLayoutParams(layoutParams10);
        textView13.setText("Hackudo Gamer");
        textView10 = new TextView(this);
        textView10.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView10.setText("wa.me/5524981018848");
        textView10.setClickable(true);
        textView10.setTag("Vendedor8");
        textView10.setLinksClickable(true);
        textView10.setTextColor(Color.parseColor(str));
        textView11 = new TextView(this);
        View view25 = textView10;
        layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        View view26 = textView13;
        layoutParams10.topMargin = dp(10);
        textView11.setLayoutParams(layoutParams10);
        textView11.setText("Tokio (hud)");
        textView10 = new TextView(this);
        layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams8.bottomMargin = dp(30);
        textView10.setLayoutParams(layoutParams8);
        textView10.setText("link9");
        textView10.setClickable(true);
        textView10.setTag("Vendedor9");
        textView10.setLinksClickable(true);
        textView10.setTextColor(Color.parseColor(str));
        TextView textView14 = new TextView(this);
        View view27 = textView10;
        layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        View view28 = textView11;
        layoutParams10.topMargin = dp(10);
        textView14.setLayoutParams(layoutParams10);
        textView14.setText("Jeca Mods");
        TextView textView15 = new TextView(this);
        textView15.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView15.setText("+55 44 98462-2692");
        textView15.setClickable(true);
        textView15.setTag("Vendedor10");
        textView15.setLinksClickable(true);
        textView15.setTextColor(Color.parseColor(str));
        textView15 = new TextView(this);
        layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams8.topMargin = dp(10);
        textView15.setLayoutParams(layoutParams8);
        textView15.setText("Tekashi DMods 開發者");
        textView15 = new TextView(this);
        textView15.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView15.setText("https://t.me/DanielzinnXP");
        textView15.setClickable(true);
        textView15.setTag("Vendedor11");
        textView15.setLinksClickable(true);
        textView15.setTextColor(Color.parseColor(str));
        textView15 = new TextView(this);
        layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams8.topMargin = dp(10);
        textView15.setLayoutParams(layoutParams8);
        textView15.setText("Matador Mods");
        textView15 = new TextView(this);
        textView15.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView15.setText("https://wa.me/556499105238");
        textView15.setClickable(true);
        textView15.setTag("Vendedor12");
        textView15.setLinksClickable(true);
        textView15.setTextColor(Color.parseColor(str));
        textView15 = new TextView(this);
        layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams8.topMargin = dp(10);
        textView15.setLayoutParams(layoutParams8);
        textView15.setText("Ninja Mods");
        textView15 = new TextView(this);
        textView15.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView15.setText("https://wa.me/5585999260924");
        textView15.setClickable(true);
        textView15.setTag("Vendedor13");
        textView15.setLinksClickable(true);
        textView15.setTextColor(Color.parseColor(str));
        linearLayout.addView(textView);
        linearLayout.addView(textView4);
        linearLayout.addView(textView2);
        linearLayout.addView(textView3);
        textView3.setOnClickListener(clickvendedores(textView3.getText().toString()));
        if(vendedor1 != "") {
            linearLayout.addView(textView5);
            linearLayout.addView(textView6);
            textView6.setOnClickListener(clickvendedores(textView6.getText().toString()));
        }
        if (vendedor2 != "") {
            linearLayout.addView(textView7);
            linearLayout.addView(textView8);
            textView8.setOnClickListener(clickvendedores(textView8.getText().toString()));
        }
        if (vendedor3 != "") {
            linearLayout.addView(view13);
            linearLayout.addView(view12);
            view12.setOnClickListener(clickvendedores(link3));
        }
        if(vendedor4 != "") {
            linearLayout.addView(view15);
            linearLayout.addView(view14);
            view14.setOnClickListener(clickvendedores(link4));
        }
        if (vendedor5 != "") {
            linearLayout.addView(view17);
            linearLayout.addView(view16);
            view16.setOnClickListener(clickvendedores(link5));


        }
        if(vendedor6 != "") {


            linearLayout.addView(view22);
            linearLayout.addView(view21);

            view21.setOnClickListener(clickvendedores(link6));
        }
        if(vendedor7 != "") {

            linearLayout.addView(view24);
            linearLayout.addView(view23);
            linearLayout.addView(view26);
            view23.setOnClickListener(clickvendedores(link7));
        }



        scrollView = scrollView2;
        scrollView.addView(linearLayout);
        return scrollView;
    }

    public View.OnClickListener clickvendedores (String url2) {

        final String url = url2;

        View.OnClickListener a = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        };
        return a;
    }

    private int dp(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }

    private int getResID(String name, String type) {
        return getResources().getIdentifier(name, type, getPackageName());
    }
}





