
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
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

    private String url = "http://localhost/apiCompleta/api.php";

    public ArrayList<Estudiante> GET() {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        try {
            HttpClient cliente = HttpClientBuilder.create().build();
            HttpGet get = new HttpGet(url);
            HttpResponse response = cliente.execute(get);
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity);
            JSONArray estudiantesArray = new JSONArray(responseString);
            for (int i = 0; i < estudiantesArray.length(); i++) {
                JSONObject object = estudiantesArray.getJSONObject(i);
                String cedula = object.getString("cedula");
                String nombre = object.getString("nombre");
                String apellido = object.getString("apellido");
                String direccion = object.getString("direccion");
                String telefono = object.getString("telefono");
                Estudiante estudiante = new Estudiante(cedula, nombre, apellido, direccion, telefono);
                estudiantes.add(estudiante);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        return estudiantes;
    }

    public ArrayList<Estudiante> GET(String cedulaParametro) {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        try {
            HttpClient cliente = HttpClientBuilder.create().build();
            HttpGet get = new HttpGet(url + "?cedula=" + cedulaParametro);
            HttpResponse response = cliente.execute(get);
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity);
            JSONArray estudiantesArray = new JSONArray(responseString);
            for (int i = 0; i < estudiantesArray.length(); i++) {
                JSONObject object = estudiantesArray.getJSONObject(i);
                String cedula = object.getString("cedula");
                String nombre = object.getString("nombre");
                String apellido = object.getString("apellido");
                String direccion = object.getString("direccion");
                String telefono = object.getString("telefono");
                Estudiante estudiante = new Estudiante(cedula, nombre, apellido, direccion, telefono);
                estudiantes.add(estudiante);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        return estudiantes;
    }

    public void POST(Estudiante estudiante) {
        try {
            HttpClient cliente = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost(url);
            ArrayList<BasicNameValuePair> parametros = new ArrayList<>();
            parametros.add(new BasicNameValuePair("cedula", estudiante.getCedula()));
            parametros.add(new BasicNameValuePair("nombre", estudiante.getNombre()));
            parametros.add(new BasicNameValuePair("apellido", estudiante.getApellido()));
            parametros.add(new BasicNameValuePair("direccion", estudiante.getDireccion()));
            parametros.add(new BasicNameValuePair("telefono", estudiante.getTelefono()));
            post.setEntity(new UrlEncodedFormEntity(parametros));
            HttpResponse response = cliente.execute(post);
            if (response != null) {
                JOptionPane.showMessageDialog(null, "ok");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void PUT(Estudiante estudiante) {
        try {
            HttpClient cliente = HttpClientBuilder.create().build();
            HttpPut put = new HttpPut(url + "?cedula=" + estudiante.getCedula() + "&nombre=" + estudiante.getNombre()
                    + "&apellido=" + estudiante.getApellido() + "&direccion=" + estudiante.getDireccion()
                    + "&telefono=" + estudiante.getTelefono());
            HttpResponse response = cliente.execute(put);
            if (response != null) {
                JOptionPane.showMessageDialog(null, "ok");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void DELETE(String cedula) {
        try {
            HttpClient cliente = HttpClientBuilder.create().build();
            HttpDelete delete = new HttpDelete(url + "?cedula=" + cedula);
            HttpResponse response = cliente.execute(delete);
            if (response != null) {
                JOptionPane.showMessageDialog(null, "ok");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
