package com.example.banchelorapp.mysql;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.banchelorapp.AuthentificationActivity;
import com.example.banchelorapp.ListaSaloaneActivity;
import com.example.banchelorapp.utils.Animal;
import com.example.banchelorapp.utils.Salon;
import com.example.banchelorapp.utils.ServiciuSalon;
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
import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BackgroundTask extends AsyncTask<String,String, String> {

    public boolean eTermimnat;
    public boolean inAnimale;
    public boolean inSaloane;
    public boolean inServicii;
    public boolean serviciiTerminat;
    public boolean corect;
    Context context;
    public static String link="http://192.168.0.101/TestRegisterLogin/";

    public BackgroundTask(Context context){
        this.context=context;
        eTermimnat=false;
        corect=false;
        inAnimale=false;
        inSaloane=false;
        inServicii=false;
        serviciiTerminat=false;
    }

    @Override
    public String doInBackground(String... strings) {

        String type=strings[0];

        String loginURL=link+"login.php";
        String regURL=link+"test.php";
        String getAnimaleURL=link+"getAnimals.php";
        String getSaloaneURL=link+"getPachSalon.php";
        String getServiciiURL=link+"getServicii.php";

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
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();


                        String[] words=result.split(" ");
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
                        inAnimale=true;
                        return result;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }catch(MalformedURLException e){
                    e.printStackTrace();
                }
            }else
            if(type.equals("getSaloane")){
                try{
                    URL url=new URL(getSaloaneURL);
                    try{
                        HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();

                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);

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
                        inSaloane=true;
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
        if(corect){
            try{
                JSONArray jsonArray=new JSONArray(s);
                JSONObject jsonObject=null;
                for(int i=0;i<jsonArray.length();i++){
                    jsonObject=jsonArray.getJSONObject(i);
                    Log.e("Ar trebui sa am nume si prenume",jsonObject.toString());
                }
            }catch (Exception ex){
                Toast.makeText(context,s,Toast.LENGTH_LONG).show();
            }

        }
        if(inAnimale){
            try{
                JSONArray jsonArray=new JSONArray(s);
                JSONObject jsonObject=null;
                for(int i=0;i<jsonArray.length();i++){
                    jsonObject=jsonArray.getJSONObject(i);
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

                    String CIP=jsonObject.getString("cip");
                    String emailProp=jsonObject.getString("emailProprietar");
                    String numeAnimal=jsonObject.getString("numeAnimal");
                    String rasaAnimal=jsonObject.getString("rasaAnimal");
                    String sexAnimal=jsonObject.getString("sexAnimal");
                    String culoare=jsonObject.getString("culoareAnimal");
                    String imagine=jsonObject.getString("imagineAnimal");


                    String dataNasteriiAnimalSTR=jsonObject.getString("dataNasteriiAnimal");
                    Date dataNasteriiAnimal=new SimpleDateFormat("yyyy-MM-dd").parse(dataNasteriiAnimalSTR);

                    Animal a= new Animal(CIP,imagine,emailProp,numeAnimal,rasaAnimal,sexAnimal,
                            dataNasteriiAnimal,culoare,
                            listaVaccinuri,
                            listaOperatii,listaDeparazitari);
                    AuthentificationActivity.listaAnimale.add(a);
                }
            }catch (Exception ex){
                Toast.makeText(context,s,Toast.LENGTH_LONG).show();
            }

        }
        if(inSaloane){
            try{
                JSONArray jsonArray=new JSONArray(s);
                ArrayList<String> listaCoduriExistente=new ArrayList();
                ArrayList<String> listaCoduriServiciiExistente= new ArrayList();
                JSONObject jsonObject=null;
                for(int i=0;i<jsonArray.length();i++) {
                    jsonObject = jsonArray.getJSONObject(i);
                    String codSalon = jsonObject.getString("codSalon");
                    if (listaCoduriExistente.contains(codSalon)) {
                        JSONObject jsonServiciu = new JSONObject(jsonObject.getString("servicii"));
                        String categorieAnimal = jsonServiciu.getString("categorieAnimal");
                        String denumireServiciu = jsonServiciu.getString("denumireServiciu");
                        String tarifServiciu = jsonServiciu.getString("tarifServiciu");
                        String durataServiciu = jsonServiciu.getString("durataServiciu");
                        String codServiciu = jsonServiciu.getString("codServiciu");

                        ServiciuSalon serviciuSalon =
                                new ServiciuSalon(categorieAnimal, denumireServiciu, (float) (Double.parseDouble(tarifServiciu)), (float) (Double.parseDouble(durataServiciu)), Integer.parseInt(codSalon));
                        if (listaCoduriServiciiExistente.contains(codServiciu)) {
                            //De aici inserez pozele
                            Log.e(" Preaiau pozaaa!!!!!!!!!!! ", jsonObject.getString("poze"));
                            JSONObject jsonPoze = new JSONObject(jsonObject.getString("poze"));
                            Log.e("Am POZAAAAAAAAAAAAAAAAAA din jSON!! -> ", jsonPoze.toString());
                            String locatiePoza = jsonPoze.getString("locatiePoza");
                            //Pana aici am pozele
                            for (int k = 0; k < AuthentificationActivity.listaSaloane.size(); k++) {
                                if (Integer.parseInt(codSalon) == AuthentificationActivity.listaSaloane.get(k).getCod()) {
                                    AuthentificationActivity.listaSaloane.get(k).adaugaPoza(locatiePoza);
                                }
                            }

                            //Daca eu deja am salonul in lista doar preiau serviciul si poza si le inserez in lista de servicii si de poze a acelui salon

                        }
                        for (int k = 0; k < AuthentificationActivity.listaSaloane.size(); k++) {
                            if (Integer.parseInt(codSalon) == AuthentificationActivity.listaSaloane.get(k).getCod()) {
                                AuthentificationActivity.listaSaloane.get(k).adaugaServiciu(serviciuSalon);
                            }
                        }
                    } else {
                            //creez o lista noua de servicii daca salonul nu exista in lista
                            ArrayList<ServiciuSalon> servicii = new ArrayList<ServiciuSalon>();
                            ArrayList<String> poze = new ArrayList<String>();
                            //adaug codul daca nu exista in lista
                            listaCoduriExistente.add(codSalon);

                            String numeSalon = jsonObject.getString("numeSalon");
                            String despreSalon = jsonObject.getString("despreSalon");
                            String telefonSalon = jsonObject.getString("telefonSalon");
                            String siteSalon = jsonObject.getString("siteSalon");
                            String locatieSalon = jsonObject.getString("locatieSalon");
                            String programSalon = jsonObject.getString("programSalon");
                            String str[] = programSalon.split(",");
                            List<String> listaProgram = new ArrayList<String>();
                            listaProgram = Arrays.asList(str);

                            Log.e("dupa preluare salon ", "E ok");
                            JSONObject jsonServiciu = new JSONObject(jsonObject.getString("servicii"));

                            String codSalonServiciu = jsonServiciu.getString("codSalon");
                            String categorieAnimal = jsonServiciu.getString("categorieAnimal");
                            String denumireServiciu = jsonServiciu.getString("denumireServiciu");
                            String tarifServiciu = jsonServiciu.getString("tarifServiciu");
                            String durataServiciu = jsonServiciu.getString("durataServiciu");
                            String codServiciu = jsonServiciu.getString("codServiciu");
                            listaCoduriServiciiExistente.add(codServiciu);
                            ServiciuSalon serviciuSalon =
                                    new ServiciuSalon(categorieAnimal, denumireServiciu, (float) (Double.parseDouble(tarifServiciu)), (float) (Double.parseDouble(durataServiciu)), Integer.parseInt(codSalon));
                            servicii.add(serviciuSalon);
                            Log.e("Am adaugat serviciul", denumireServiciu);

                            Log.e("Ce am aici > ar trebuie sa fie POZAA ", jsonObject.getString("poze"));
                            JSONObject jsonPoze = new JSONObject(jsonObject.getString("poze"));
                            String locatiePoza = jsonPoze.getString("locatiePoza");
                            poze.add(locatiePoza);
                            Log.e("dupa preluare POZAAA ", "E ok");

                            Salon salon = new Salon(Integer.parseInt(codSalon), numeSalon, despreSalon, servicii, poze, telefonSalon, siteSalon, locatieSalon, listaProgram);
                            AuthentificationActivity.listaSaloane.add(salon);
                    }
                }

            }catch (Exception ex){
                Toast.makeText(context,s,Toast.LENGTH_LONG).show();
            }

        }
    }
}
