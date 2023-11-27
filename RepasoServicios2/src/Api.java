
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alexa
 */
public class Api {
    private String url = "http://localhost/apijava2/api.php";
    
    public ArrayList<Estudiante> buscar(String nivel, String paralelo){
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        try{
            HttpClient cliente = HttpClientBuilder.create().build();
            HttpGet get = new HttpGet(url+"?nivel="+nivel+"&paralelo="+paralelo);
            HttpResponse response = cliente.execute(get);
            HttpEntity entity = response.getEntity();
            String strinResponse = EntityUtils.toString(entity);
            JSONArray estudiantesArray = new JSONArray(strinResponse);
            for (int i = 0; i < estudiantesArray.length(); i++) {
                JSONObject object = estudiantesArray.getJSONObject(i);
                String nombre = object.getString("nombre");
                String apellido = object.getString("apellido");
                Estudiante estudiante = new Estudiante(nombre, apellido);
                estudiantes.add(estudiante);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        
        return estudiantes;
    }
}
