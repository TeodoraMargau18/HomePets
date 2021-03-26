package com.example.banchelorapp.mysql;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask extends AsyncTask<String,String, String> {

    public boolean eTermimnat;
    public boolean corect;
    Context context;
    public BackgroundTask(Context context){
        this.context=context;
        eTermimnat=false;
        corect=false;
    }

    @Override
    public String doInBackground(String... strings) {

        String type=strings[0];

        String loginURL="http://192.168.0.101/TestRegisterLogin/login.php";
        String regURL="http://192.168.0.101/TestRegisterLogin/test.php";

        if(type.equals("reg")){
            String email=strings[1];
            String parola=strings[2];
            String nume=strings[3];
            String prenume=strings[4];
            String adresa=strings[5];
            String numarTel=strings[6];
            try{
                URL url=new URL(regURL);
                try{
                    HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream=httpURLConnection.getOutputStream();
                    OutputStreamWriter outputStreamWriter=new OutputStreamWriter(outputStream,"UTF-8");
                    BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
                    String insertData= URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+
                            "&"+URLEncoder.encode("parola","UTF-8")+"="+URLEncoder.encode(parola,"UTF-8")+
                            "&"+URLEncoder.encode("nume","UTF-8")+"="+URLEncoder.encode(nume,"UTF-8")+
                            "&"+URLEncoder.encode("prenume","UTF-8")+"="+URLEncoder.encode(prenume,"UTF-8")+
                            "&"+URLEncoder.encode("adresa","UTF-8")+"="+URLEncoder.encode(adresa,"UTF-8")+
                            "&"+URLEncoder.encode("numarTel","UTF-8")+"="+URLEncoder.encode(numarTel,"UTF-8");
                    bufferedWriter.write(insertData);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    InputStream inputStream=httpURLConnection.getInputStream();
                    InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"ISO-8859-1");
                    BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                    String result="";
                    String line="";
                    StringBuilder stringBuilder=new StringBuilder();
                    while((line=bufferedReader.readLine())!=null){
                        stringBuilder.append(line).append("\n");
                    }
                    result=stringBuilder.toString();
                    Log.e("backgrounTask",result);
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return result;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }catch(MalformedURLException e){
                e.printStackTrace();
            }
        }else
            if(type.equals("login")){
                String email=strings[1];
                String parola=strings[2];
                try{
                    URL url=new URL(loginURL);
                    try{
                        HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();

                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream=httpURLConnection.getOutputStream();
                        OutputStreamWriter outputStreamWriter=new OutputStreamWriter(outputStream,"UTF-8");
                        BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
                        String loginData= URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+
                                "&"+URLEncoder.encode("parola","UTF-8")+"="+URLEncoder.encode(parola,"UTF-8");

                        bufferedWriter.write(loginData);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        InputStream inputStream=httpURLConnection.getInputStream();
                        InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"ISO-8859-1");
                        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                        String result="";
                        String line="";
                        StringBuilder stringBuilder=new StringBuilder();
                        while((line=bufferedReader.readLine())!=null){
                            stringBuilder.append(line).append("\n");
                        }
                        result=stringBuilder.toString();
                        Log.e("backgrounTaskLOGIN",result);
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }catch(MalformedURLException e){
                    e.printStackTrace();
                }
            }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        eTermimnat=true;
        String[] words=s.split(" ");
        Log.e("Ultimul cuvant din result",words[words.length-1]);
        corect=words[words.length-1].trim().equals("success");
        super.onPostExecute(s);
    }
}
