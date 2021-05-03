package com.example.banchelorapp.mysql;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.banchelorapp.AuthentificationActivity;
import com.example.banchelorapp.InfoAdoptie;
import com.example.banchelorapp.ListaSaloaneActivity;
import com.example.banchelorapp.MainActivity;
import com.example.banchelorapp.utils.Animal;
import com.example.banchelorapp.utils.AnimaleAdoptie;
import com.example.banchelorapp.utils.Proprietar;
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
    public static boolean inAnimaleTerminat;
    public boolean inAnimaleAdoptie;
    public boolean inSaloane;
    public boolean inServicii;
    public boolean serviciiTerminat;
    public static boolean vaccinuriTerminat;
    public static boolean interventiiTerminat;
    public static boolean deparazitariTerminat;
    public static boolean cevaTerminat;
    public  boolean corect;
    public static String numeProprietar;
    public static String prenumeProprietar;
    public static String emailProp;
    public static String parola;
    public static String adresa;
    public static String numarTel;


    Context context;
    public static String link="http://192.168.0.101/TestRegisterLogin/";

    public BackgroundTask(Context context){
        this.context=context;
        eTermimnat=false;
        corect=false;
        inAnimale=false;
        inAnimaleTerminat=false;
        inAnimaleAdoptie=false;
        inSaloane=false;
        inServicii=false;
        serviciiTerminat=false;
        vaccinuriTerminat=false;
        interventiiTerminat=false;
        deparazitariTerminat=false;
        cevaTerminat=false;
    }

    @Override
    public String doInBackground(String... strings) {

        String type=strings[0];

        String loginURL=link+"login.php";
        String regURL=link+"test.php";
        String getAnimaleURL=link+"getAnimals.php";
        String getAnimaleAdoptieURL=link+"getAnimaleAdoptie.php";
        String getSaloaneURL=link+"getPachSalon.php";
        String getVaccinuri=link+"getVaccinuri.php";
        String getInterventii=link+"getInterventii.php";
        String getDeparazitari=link+"getDeparazitari.php";
        String addDescURL=link+"getAddDesc.php";
        String addStateURL=link+"addState.php";

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
              if(type.equals("addDesc"))
              {
                  String descriereAnimal=strings[1];
                  String cipAnimal=strings[2];
                  try{
                      URL url=new URL(addDescURL);
                      try{
                          HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                          httpURLConnection.setRequestMethod("POST");
                          httpURLConnection.setDoOutput(true);
                          httpURLConnection.setDoInput(true);
                          OutputStream outputStream=httpURLConnection.getOutputStream();
                          OutputStreamWriter outputStreamWriter=new OutputStreamWriter(outputStream,"UTF-8");
                          BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
                          String insertData= URLEncoder.encode("descriereAnimal","UTF-8")+"="
                                  +URLEncoder.encode(descriereAnimal,"UTF-8")+
                          "&"+
                                  URLEncoder.encode("cipAnimal","UTF-8")+"="
                                  +URLEncoder.encode(cipAnimal,"UTF-8");
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
              if(type.equals(InfoAdoptie.type))
              {
                  String statutAnimal=strings[1];
                  String idAnimal=strings[2];
                  try{
                      URL url=new URL(addStateURL);
                      try{
                          HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                          httpURLConnection.setRequestMethod("POST");
                          httpURLConnection.setDoOutput(true);
                          httpURLConnection.setDoInput(true);
                          OutputStream outputStream=httpURLConnection.getOutputStream();
                          OutputStreamWriter outputStreamWriter=new OutputStreamWriter(outputStream,"UTF-8");
                          BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
                          String insertData= URLEncoder.encode("statutAnimal","UTF-8")+"="
                                  +URLEncoder.encode(statutAnimal,"UTF-8")+
                                  "&"+
                                  URLEncoder.encode("ID","UTF-8")+"="
                                  +URLEncoder.encode(idAnimal,"UTF-8");
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
              } else
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
            if(type.equals("getAnimaleAdoptie")){
                try{
                    URL url=new URL(getAnimaleAdoptieURL);
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
                        inAnimaleAdoptie=true;
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
            else
            if(type.equals("getVaccinuri")){
                try{
                    URL url=new URL(getVaccinuri);
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
                        try{
                            JSONArray jsonArray=new JSONArray(result);
                            JSONObject jsonObject=null;

                            for(int i=0;i<jsonArray.length();i++) {
                                jsonObject = jsonArray.getJSONObject(i);
                                String tipVaccin=jsonObject.getString("tipVaccin");

                                String dataVaccinSTR=jsonObject.getString("dataVaccin");
                                Date dataVaccin=new SimpleDateFormat("yyyy-MM-dd").parse(dataVaccinSTR);

                                String dataViitoareiVaccinariSTR=jsonObject.getString("dataViitoareiVaccinari");
                                Date dataViitoareiVaccinari=new SimpleDateFormat("yyyy-MM-dd").parse(dataViitoareiVaccinariSTR);

                                String codMedic=jsonObject.getString("codMedic");
                                String codVaccin=jsonObject.getString("codVaccin");
                                float tarifVaccin=(float)(Double.parseDouble(jsonObject.getString("tarifVaccin"))) ;
                                String cipAnimal=jsonObject.getString("cipAnimal");

                               Vaccin vaccin=new Vaccin(tipVaccin,dataVaccin,dataViitoareiVaccinari,codMedic,tarifVaccin,cipAnimal);
                               MainActivity.listaVaccinuri.add(vaccin);
                            }

                        }catch (Exception ex){
                            Toast.makeText(context,result,Toast.LENGTH_LONG).show();
                        }
                        vaccinuriTerminat=true;
                        return result;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }catch(MalformedURLException e){
                    e.printStackTrace();
                }
            }
            else
            if(type.equals("getDeparazitari")){
                try{
                    URL url=new URL(getDeparazitari);
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
                        try{
                            JSONArray jsonArray=new JSONArray(result);
                            JSONObject jsonObject=null;

                            for(int i=0;i<jsonArray.length();i++) {
                                jsonObject = jsonArray.getJSONObject(i);
                                String codDeparazitare=jsonObject.getString("codDeparazitare");
                                String dataDeparazitareSTR=jsonObject.getString("dataDeparazitare");
                                Date dataDeparazitare=new SimpleDateFormat("yyyy-MM-dd").parse(dataDeparazitareSTR);

                                String dataUrmatoareiDeparazitariSTR=jsonObject.getString("dataUrmatoareiDeparazitari");
                                Date dataUrmatoareiDeparazitari=new SimpleDateFormat("yyyy-MM-dd").parse(dataUrmatoareiDeparazitariSTR);

                                String denumireProdus=jsonObject.getString("denumireProdus");
                                String categorieDeparazitare=jsonObject.getString("categorieDeparazitare");
                                float pretProdus=(float)(Double.parseDouble(jsonObject.getString("pretProdus"))) ;
                                String cipAnimal=jsonObject.getString("cipAnimal");

                                Deparazitare deparazitare=new Deparazitare(dataDeparazitare,dataUrmatoareiDeparazitari,categorieDeparazitare,denumireProdus,pretProdus,cipAnimal);
                               MainActivity.listaDeparazitari.add(deparazitare);
                            }

                        }catch (Exception ex){
                            Toast.makeText(context,result,Toast.LENGTH_LONG).show();
                        }
                        deparazitariTerminat=true;
                        return result;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }catch(MalformedURLException e){
                    e.printStackTrace();
                }
            }
            else
            if(type.equals("getInterventii")){
                try{
                    URL url=new URL(getInterventii);
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
                        try{
                            JSONArray jsonArray=new JSONArray(result);
                            JSONObject jsonObject=null;

                            for(int i=0;i<jsonArray.length();i++) {
                                jsonObject = jsonArray.getJSONObject(i);
                                String codInterventie=jsonObject.getString("codInterventie");

                                String dataInterventieSTR=jsonObject.getString("dataInterventie");
                                Date dataInterventie=new SimpleDateFormat("yyyy-MM-dd").parse(dataInterventieSTR);


                                String tipInterventie=jsonObject.getString("tipInterventie");
                                String codMedic=jsonObject.getString("codMedic");
                                float tarifInterventie=(float)(Double.parseDouble(jsonObject.getString("tarifInterventie"))) ;
                                String cipAnimal=jsonObject.getString("cipAnimal");

                                Interventie interventie=new Interventie(tipInterventie,dataInterventie,codMedic,tarifInterventie,codInterventie,cipAnimal);
                                MainActivity.listaInterventii.add(interventie);
                            }

                        }catch (Exception ex){
                            Toast.makeText(context,result,Toast.LENGTH_LONG).show();
                        }
                        interventiiTerminat=true;
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
                    numeProprietar=jsonObject.getString("nume");
                    prenumeProprietar=jsonObject.getString("prenume");
                    emailProp=jsonObject.getString("email");
                    parola=jsonObject.getString("parola");
                    adresa=jsonObject.getString("adresa");
                    numarTel=jsonObject.getString("numarTel");
                }
            }catch (Exception ex){
                Toast.makeText(context,s,Toast.LENGTH_LONG).show();
            }
        }
        if(inAnimale){
            try{
                JSONArray jsonArray=new JSONArray(s);
                JSONObject jsonObject=null;

                for(int i=0;i<jsonArray.length();i++) {
                    jsonObject = jsonArray.getJSONObject(i);

                        ArrayList<Deparazitare> deparazitari = new ArrayList<Deparazitare>();
                        ArrayList<Interventie> interventii = new ArrayList<Interventie>();
                        ArrayList<Vaccin> vaccinuri = new ArrayList<Vaccin>();

                        String CIP=jsonObject.getString("cip");
                        String emailProp=jsonObject.getString("emailProprietar");
                        String numeAnimal=jsonObject.getString("numeAnimal");
                        String rasaAnimal=jsonObject.getString("rasaAnimal");
                        String specieAnimal=jsonObject.getString("categorieAnimal");
                        String sexAnimal=jsonObject.getString("sexAnimal");
                        String culoare=jsonObject.getString("culoareAnimal");
                        String imagine=jsonObject.getString("imagineAnimal");
                        String descriereAnimal=jsonObject.getString("despreAnimal");
                        String semneParticulare=jsonObject.getString("semneParticulare");


                        String dataNasteriiAnimalSTR=jsonObject.getString("dataNasteriiAnimal");
                        Date dataNasteriiAnimal=new SimpleDateFormat("yyyy-MM-dd").parse(dataNasteriiAnimalSTR);

//                        creez animalul
                        Animal a= new Animal(CIP,semneParticulare,imagine,emailProp,numeAnimal,rasaAnimal,descriereAnimal,specieAnimal,sexAnimal,
                                dataNasteriiAnimal,culoare,
                                vaccinuri,
                                interventii,deparazitari);
                        AuthentificationActivity.listaAnimale.add(a);
                    inAnimaleTerminat=true;
                }

            }catch (Exception ex){
                Toast.makeText(context,s,Toast.LENGTH_LONG).show();
            }

        }
        if(inAnimaleAdoptie){
            try{
                JSONArray jsonArray=new JSONArray(s);
                JSONObject jsonObject=null;

                for(int i=0;i<jsonArray.length();i++) {
                    jsonObject = jsonArray.getJSONObject(i);
                    ArrayList<Deparazitare> deparazitari = new ArrayList<Deparazitare>();
                    ArrayList<Interventie> interventii = new ArrayList<Interventie>();
                    ArrayList<Vaccin> vaccinuri = new ArrayList<Vaccin>();

                    String ID=jsonObject.getString("ID");
                    String imagine=jsonObject.getString("imagineAnimal");
                    String numeAnimal=jsonObject.getString("numeAnimal");
                    String rasaAnimal=jsonObject.getString("rasaAnimal");
                    String descriereAnimal=jsonObject.getString("despreAnimal");
                    String specieAnimal=jsonObject.getString("categorieAnimal");
                    String sexAnimal=jsonObject.getString("sexAnimal");
                    String culoare=jsonObject.getString("culoareAnimal");
                    String statut=jsonObject.getString("statutAnimal");

                    String dataNasteriiAnimalSTR=jsonObject.getString("dataNasteriiAnimal");
                    Date dataNasteriiAnimal=new SimpleDateFormat("yyyy-MM-dd").parse(dataNasteriiAnimalSTR);
//                        creez animalul
                    AnimaleAdoptie a= new AnimaleAdoptie(ID,imagine,numeAnimal,rasaAnimal,descriereAnimal,
                            specieAnimal,sexAnimal,dataNasteriiAnimal,culoare,vaccinuri,interventii,deparazitari);
                    if(statut.toLowerCase().trim().equals("neadoptat"))
                    AuthentificationActivity.listaAnimaleAdoptie.add(a);
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
                ArrayList<String> listaPozeExistente= new ArrayList();

                JSONObject jsonObject=null;
                for(int i=0;i<jsonArray.length();i++) {
                    jsonObject = jsonArray.getJSONObject(i);
                    String codSalon = jsonObject.getString("codSalon");

                    //Daca eu deja am salonul in lista doar preiau serviciul si poza si le inserez in lista de servicii si de poze a acelui salon
                    if (listaCoduriExistente.contains(codSalon)) {

                        JSONObject jsonServiciu = new JSONObject(jsonObject.getString("servicii"));
                        String codServiciu = jsonServiciu.getString("codServiciu");

                        if (listaCoduriServiciiExistente.contains(codServiciu)) {
                            //De aici inserez pozele
                            JSONObject jsonPoze = new JSONObject(jsonObject.getString("poze"));
                            String locatiePoza = jsonPoze.getString("locatiePoza");
                            if(!listaPozeExistente.contains(locatiePoza)) {//Pana aici am pozele
                                listaPozeExistente.add(locatiePoza);
                                for (int k = 0; k < AuthentificationActivity.listaSaloane.size(); k++) {
                                    if (Integer.parseInt(codSalon) == AuthentificationActivity.listaSaloane.get(k).getCod()) {
                                        AuthentificationActivity.listaSaloane.get(k).adaugaPoza(locatiePoza);
                                    }
                                }
                            }
                        }
                        else
                        //Daca nu exista codul serviciului
                        {
                            String categorieAnimal = jsonServiciu.getString("categorieAnimal");
                            String denumireServiciu = jsonServiciu.getString("denumireServiciu");
                            String tarifServiciu = jsonServiciu.getString("tarifServiciu");
                            String durataServiciu = jsonServiciu.getString("durataServiciu");

                            ServiciuSalon serviciuSalon =
                                    new ServiciuSalon(categorieAnimal, denumireServiciu, (float) (Double.parseDouble(tarifServiciu)), (float) (Double.parseDouble(durataServiciu)), Integer.parseInt(codSalon));
                            listaCoduriServiciiExistente.add(codServiciu);
                            for (int k = 0; k < AuthentificationActivity.listaSaloane.size(); k++) {
                                if (Integer.parseInt(codSalon) == AuthentificationActivity.listaSaloane.get(k).getCod()) {
                                    AuthentificationActivity.listaSaloane.get(k).adaugaServiciu(serviciuSalon);
                                }
                            }
                        }
                    }
                    //Daca nu exista codul salonului
                    else {
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
                            JSONObject jsonPoze = new JSONObject(jsonObject.getString("poze"));
                            String locatiePoza = jsonPoze.getString("locatiePoza");

                            listaPozeExistente.add(locatiePoza);
                            poze.add(locatiePoza);

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
