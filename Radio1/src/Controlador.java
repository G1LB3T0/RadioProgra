import java.util.Scanner;
import java.util.ArrayList;
public class Controlador implements IRadio{
    Radio radiomain = new Radio(false, 87.2F, true);
    private ArrayList<Float> emisorasFavoritas = new ArrayList<>();
    public Controlador() {
    }

    public void On() {

    }
    @Override
    public boolean getState() {
        return radiomain.isPower();
    }

    @Override
    public void tooglePowerOffOn() {
        int x = 0;
        if (radiomain.isPower() == false){
            radiomain.setPower(true);
            x = 1;
        }
        if (x == 0){
            if (radiomain.isPower() == true){
                radiomain.setPower(false);
                x = 1;
            }
        }
    }

    @Override
    public void toogleAMFM() {
        if (radiomain.isFrecuencia()) {  
            radiomain.setFrecuencia(false);  
            radiomain.setEmisora(530);       
        } else {  
            radiomain.setFrecuencia(true);   
            radiomain.setEmisora(87.2F);     
        }
    }

    @Override
    public boolean getStateAMFM() {
        return radiomain.isFrecuencia();
    }

    @Override
    public void nextFrequency() {
        float r = radiomain.getEmisora();
        if (radiomain.isFrecuencia()) {  
            if (r < 108.0) {
                r += 0.2F;
            } else {
                r = 87.2F;
            }
        } else {  
            if (r < 1610) {
                r += 10;
            } else {
                r = 530;
            }
        }
        r = Math.round(r * 10.0F) / 10.0F;
        radiomain.setEmisora(r);
    }

    @Override
    public void previousFrequency() {
        float r = radiomain.getEmisora();
        if (radiomain.isFrecuencia()) {  
            if (r > 87.2) {
                r -= 0.2F;
            } else {
                r = 108.0F;
            }
        } else {  
            if (r > 530) {
                r -= 10;
            } else {
                r = 1610;
            }
        }
        r = Math.round(r * 10.0F) / 10.0F;
        radiomain.setEmisora(r);
    }

    @Override
    public float getCurrentFrequency() {
        return radiomain.getEmisora();
    }

    @Override
    public void setFavFrequency(int button) {
        if (button >= 1 && button <= 5) {
            emisorasFavoritas.add(Main.controlador.getCurrentFrequency());
            System.out.println("Emisora guardada en el botón " + button);
        } else {
            System.out.println("Número de botón no válido. Solo se admiten botones del 1 al 5.");
        }
    }

    @Override
    public float getFavFrequency(int button) {
            if (button >= 1 && button <= 5 && emisorasFavoritas.size() >= button) {
            return emisorasFavoritas.get(button - 1);
        } else {
            System.out.println("Número de botón no válido o no hay emisora guardada en ese botón.");
            return 0;
        }
    }
}
