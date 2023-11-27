/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Alexa
 */
public class Api {
    
    private String url = "http://localhost/apijava/api.php";
    
    public ArrayList<Cliente> verDatos(String nro, String tipo){
        ArrayList<Cliente> datos = new ArrayList<>();
        try{
            HttpClient cliente = HttpClientBuilder.create().build();
            HttpGet get = new HttpGet(url+"?nroCuenta="+nro+"&tipo="+tipo);
            HttpResponse response = cliente.execute(get);
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity);
            System.out.println(responseString);
            JSONArray datosArray = new JSONArray(responseString);
            for (int i = 0; i < datosArray.length(); i++) {
                JSONObject object =datosArray.getJSONObject(i);
                String nroCuenta = object.getString("nroCuenta");
                String nombre = object.getString("nombre");
                String apellido = object.getString("apellido");
                String tipoTransaccion = object.getString("tipoTransaccion");
                double monto = object.getDouble("montoTransaccion");
                Cliente clienteB = new Cliente(nroCuenta, nombre, apellido, tipoTransaccion, monto);
                datos.add(clienteB);
            }
        }catch(IOException | ParseException | JSONException e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        return datos;
    }
    
}
