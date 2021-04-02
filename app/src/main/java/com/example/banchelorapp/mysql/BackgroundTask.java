package com.example.banchelorapp.mysql;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.banchelorapp.AuthentificationActivity;
import com.example.banchelorapp.utils.Animal;
import com.example.banchelorapp.utils.interventii.Deparazitare;
import com.example.banchelorapp.utils.interventii.Interventie;
import com.example.banchelorapp.utils.interventii.Vaccin;

import org.json.JSONArray;
import org.json.JSONObject;

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
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BackgroundTask extends AsyncTask<String,String, String> {

    public boolean eTermimnat;
    public boolean inAnimale;
    public boolean corect;
    Context context;

    public BackgroundTask(Context context){
        this.context=context;
        eTermimnat=false;
        corect=false;
        inAnimale=false;
    }

    @Override
    public String doInBackground(String... strings) {

        String type=strings[0];

        String loginURL="http://192.168.0.101/TestRegisterLogin/login.php";
        String regURL="http://192.168.0.101/TestRegisterLogin/test.php";
        String getAnimaleURL="http://192.168.0.101/TestRegisterLogin/getAnimals.php";

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


                        String[] words=result.split(" ");
                        Log.e("Ultimul cuvant din result",words[words.length-1]);
                        corect=words[words.length-1].trim().equals("success");

                        return result;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }catch(MalformedURLException e){
                    e.printStackTrace();
                }
            }
            else
            if(type.equals("getAnimale")){
                String email=strings[1];
                try{
                    URL url=new URL(getAnimaleURL);
                    try{
                        HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();

                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream=httpURLConnection.getOutputStream();
                        OutputStreamWriter outputStreamWriter=new OutputStreamWriter(outputStream,"UTF-8");
                        BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
                        String animaleData= URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8");

                        bufferedWriter.write(animaleData);
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
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();

                        String[] words=result.split(" ");
                        Log.e("Ultimul cuvant din result , Sunt In cauta animal",words[words.length-1]);
                        inAnimale=true;
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
        super.onPostExecute(s);
        if(inAnimale){
            Log.e ("onPostExecute","E ceva aici?"+s+"este");
            try{
                JSONArray jsonArray=new JSONArray(s);
                Log.e ("onPostExecute ce am in JSON Array? ",jsonArray.toString());
                JSONObject jsonObject=null;
                for(int i=0;i<jsonArray.length();i++){
                    Log.e("Background dupa animale","Inainte de preluare obj");
                    jsonObject=jsonArray.getJSONObject(i);
                    Log.e("Am oBiectul din jSON!! -> ",jsonObject.toString());
                    Date dataMMMM=new Date(1999  ,06,01);
                    ArrayList<Vaccin> listaVaccinuri=new ArrayList<>();
                    Vaccin v= new Vaccin("antirabic",new Date(2000,06,01),new Date(2000,06,13),"popescu18");
                    listaVaccinuri.add(v);
                    listaVaccinuri.add(v);
                    ArrayList<Interventie> listaOperatii=new ArrayList<>();
                    Interventie interventie =new Interventie("Cezariana",new Date(2021,01,01),"Gigel");
                    Interventie interventie2 =new Interventie("Tratament parvoviroza",new Date(2021,01,01),"Teodora");
                    listaOperatii.add(interventie);
                    listaOperatii.add(interventie2);
                    ArrayList<Deparazitare> listaDeparazitari=new ArrayList<Deparazitare>();
                    Deparazitare deparazitare=new Deparazitare(dataMMMM,dataMMMM,"INTERNA","Cestal");
                    Deparazitare deparazitare2=new Deparazitare(dataMMMM,dataMMMM,"EXTERNA","Parakill");
                    listaDeparazitari.add(deparazitare);
                    listaDeparazitari.add(deparazitare2);

                    Log.e("Background dupa animale","Inainte de spargere obj");
                    String CIP=jsonObject.getString("cip");
                    String emailProp=jsonObject.getString("emailProprietar");
                    String numeAnimal=jsonObject.getString("numeAnimal");
                    String rasaAnimal=jsonObject.getString("rasaAnimal");
                    String sexAnimal=jsonObject.getString("sexAnimal");
                    String culoare=jsonObject.getString("culoareAnimal");
                    String imagine=jsonObject.getString("imagineAnimal");


                    String dataNasteriiAnimalSTR=jsonObject.getString("dataNasteriiAnimal");
                    Date dataNasteriiAnimal=new SimpleDateFormat("yyyy-MM-dd").parse(dataNasteriiAnimalSTR);


                    Log.e("Animalul meu pe bucati->",CIP+" "+emailProp+" "+numeAnimal+" "+rasaAnimal+" "+sexAnimal+" "+ dataNasteriiAnimal);

                    Animal a= new Animal(CIP,imagine,emailProp,numeAnimal,rasaAnimal,sexAnimal,
                            dataNasteriiAnimal,culoare,
                            listaVaccinuri,
                            listaOperatii,listaDeparazitari);
                    Log.e("Testez imaginea",a.toString());
                    AuthentificationActivity.listaAnimale.add(a);
                }
            }catch (Exception ex){
                Toast.makeText(context,s,Toast.LENGTH_LONG).show();
            }

        }
    }
}
