package com.example.nkssa.entrancelog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Time;
import java.util.ArrayList;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;


import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class visitor extends Activity implements View.OnClickListener {

    visitorphp biodata = new visitorphp();
    TableLayout visitor;

    Button buttonTambahBiodata;
    ArrayList<Button> buttonEdit = new ArrayList<Button>();
    ArrayList<Button> buttonDelete = new ArrayList<Button>();

    JSONArray arrayBiodata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_visitor);


        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        visitor = (TableLayout) findViewById(R.id.tableBiodata);


        TableRow barisTabel = new TableRow(this);
        barisTabel.setBackgroundColor(Color.CYAN);

        TextView viewHeaderNo = new TextView(this);
        TextView viewHeaderrId = new TextView(this);
        TextView viewHeaderName = new TextView(this);
        TextView viewHeaderTime = new TextView(this);
        TextView viewHeaderAction = new TextView(this);


        viewHeaderNo.setText("No.");
        viewHeaderrId.setText("Rid");
        viewHeaderName.setText("Name");
        viewHeaderTime.setText("Time");
        viewHeaderAction.setText("");

        viewHeaderNo.setPadding(5, 1, 5, 1);
        viewHeaderrId.setPadding(5, 1, 5, 1);
        viewHeaderName.setPadding(5, 1, 5, 1);
        viewHeaderTime.setPadding(5, 1, 5, 1);
        viewHeaderAction.setPadding(5, 1, 5, 1);

        barisTabel.addView(viewHeaderNo);
        barisTabel.addView(viewHeaderrId);
        barisTabel.addView(viewHeaderName);
        barisTabel.addView(viewHeaderTime);
        barisTabel.addView(viewHeaderAction);

        visitor.addView(barisTabel, new TableLayout.LayoutParams(ViewPager.LayoutParams.WRAP_CONTENT, ViewPager.LayoutParams.WRAP_CONTENT));

        try {

            arrayBiodata = new JSONArray(biodata.tampilBiodata());

            for (int i = 0; i < arrayBiodata.length(); i++) {
                JSONObject jsonChildNode = arrayBiodata.getJSONObject(i);
                String name = jsonChildNode.optString("Name");
                String time = jsonChildNode.optString("Time");
                String no = jsonChildNode.optString("no.");
                String rid = jsonChildNode.optString("Id");

                System.out.println("Name:" + name);
                System.out.println("Time: " + time);
                System.out.println("no." + no);
                System.out.println("Id :" + rid);

                barisTabel = new TableRow(this);

                if (i % 2 == 0) {
                    barisTabel.setBackgroundColor(Color.LTGRAY);
                }

                TextView viewNo = new TextView(this);
                viewNo.setText(no);
                viewNo.setPadding(5, 1, 5, 1);
                barisTabel.addView(viewNo);

                TextView viewrId = new TextView(this);
                viewrId.setText(rid);
                viewrId.setPadding(5, 1, 5, 1);
                barisTabel.addView(viewrId);

                TextView viewName = new TextView(this);
                viewName.setText(name);
                viewName.setPadding(5, 1, 5, 1);
                barisTabel.addView(viewName);


                TextView viewTime = new TextView(this);
                viewTime.setText(time);
                viewTime.setPadding(5, 1, 5, 1);
                barisTabel.addView(viewTime);



                buttonEdit.add(i, new Button(this));
                buttonEdit.get(i).setId(Integer.parseInt(rid));
                buttonEdit.get(i).setTag("Report");
                buttonEdit.get(i).setText("Report");
                buttonEdit.get(i).setOnClickListener(this);
                barisTabel.addView(buttonEdit.get(i));



                visitor.addView(barisTabel, new TableLayout.LayoutParams(ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.MATCH_PARENT));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void onClick(View view) {

    }







}


